package com.izzulhaqfs.theozunime.favorite

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.izzulhaqfs.theozunime.core.ui.AnimeAdapter
import com.izzulhaqfs.theozunime.detail.DetailAnimeActivity
import com.izzulhaqfs.theozunime.favorite.databinding.ActivityFavoriteBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class FavoriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFavoriteBinding
    private lateinit var animeListAdapter: AnimeAdapter
    private val favoriteViewModel: FavoriteViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadKoinModules(favoriteModul)

        supportActionBar?.title = TITLE

        animeListAdapter = AnimeAdapter()
        animeListAdapter.onItemClick = { selectedData ->
            val intent = Intent(this, DetailAnimeActivity::class.java)
            intent.putExtra(DetailAnimeActivity.EXTRA_DATA, selectedData)
            startActivity(intent)
        }

        showFavoriteAnimeList()
    }

    private fun showFavoriteAnimeList() {
        favoriteViewModel.animes.observe(this@FavoriteActivity) { animes ->
            if (animes != null) {
                animeListAdapter.submitList(animes)
            }
        }

        with(binding.rvFavorite) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = animeListAdapter
        }
    }

    companion object {
        private const val TITLE = "Favorite Anime"
    }
}