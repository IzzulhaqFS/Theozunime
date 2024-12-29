package com.izzulhaqfs.theozunime.core.di

import androidx.room.Room
import com.izzulhaqfs.theozunime.core.data.AnimeRepository
import com.izzulhaqfs.theozunime.core.data.source.local.LocalDataSource
import com.izzulhaqfs.theozunime.core.data.source.local.room.AnimeDatabase
import com.izzulhaqfs.theozunime.core.data.source.remote.RemoteDataSource
import com.izzulhaqfs.theozunime.core.data.source.remote.network.ApiService
import com.izzulhaqfs.theozunime.core.domain.repository.IAnimeRepository
import com.izzulhaqfs.theozunime.core.utils.AppExecutors
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<AnimeDatabase>().animeDao() }
    single {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("izzulhaqfs".toCharArray())
        val factory = SupportFactory(passphrase)
        Room.databaseBuilder(
            androidContext(),
            AnimeDatabase::class.java,
            "anime_db"
        ).fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }
}

val networkModule = module {
    single {
        val hostName = "api.myanimelist.net"
        val certificatePinner = CertificatePinner.Builder()
            .add(hostName, "sha256/bzD+soGwibR7GgbcTZHEIoUGTLsIpn4ICG2CFn2l+z4=")
            .add(hostName, "sha256/vxRon/El5KuI4vx5ey1DgmsYmRY0nDd5Cg4GfJ8S+bg=")
            .add(hostName, "sha256/++MBgDH5WGvL9Bcn5Be30cRcL0f5O+NyoXuWtQdX1aI=")
            .build()
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .certificatePinner(certificatePinner)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.myanimelist.net/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<IAnimeRepository> {
        AnimeRepository(
            get(),
            get(),
            get()
        )
    }
}