package com.izzulhaqfs.theozunime.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.IntentCompat.getParcelableExtra
import com.bumptech.glide.Glide
import com.izzulhaqfs.theozunime.R
import com.izzulhaqfs.theozunime.core.domain.model.Anime
import com.izzulhaqfs.theozunime.databinding.ActivityDetailAnimeBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailAnimeActivity : AppCompatActivity() {
    private val detailAnimeViewModel: DetailAnimeViewModel by viewModel()
    private lateinit var binding: ActivityDetailAnimeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailAnimeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val detailAnime = getParcelableExtra(intent, EXTRA_DATA, Anime::class.java)
        showDetailAnime(detailAnime)
    }

    private fun showDetailAnime(detailAnime: Anime?) {
        detailAnime?.let {
            supportActionBar?.title = detailAnime.title
            val scoringUser = "${detailAnime.numScoringUsers} users"
            val rank = "Ranked #${detailAnime.rank}"
            val premiered = "${detailAnime.startSeason} ${detailAnime.startYear}"
            val durationMinute = detailAnime.averageEpisodeDuration?.div(60)
            val duration = "$durationMinute min. per ep."
            binding.contentDetailAnime.apply {
                tvDetailScore.text = detailAnime.mean.toString()
                tvDetailScoringUser.text = scoringUser
                tvDetailRank.text = rank
                tvDetailType.text = detailAnime.mediaType
                tvDetailEpisodes.text = detailAnime.numEpisodes.toString()
                tvDetailStatus.text = detailAnime.status
                tvDetailPremiered.text = premiered
                tvDetailStudios.text = detailAnime.studios
                tvDetailSource.text = detailAnime.source
                tvDetailGenres.text = detailAnime.genres
                tvDetailDuration.text = duration
                tvDetailRating.text = detailAnime.rating
                tvDetailSynopsis.text = detailAnime.synopsis
            }
            Glide.with(this@DetailAnimeActivity)
                .load(detailAnime.mainPictureLarge)
                .into(binding.imgDetailAnime)

            var isFavorite = detailAnime.isFavorite
            setStatusFavorite(isFavorite)
            binding.fab.setOnClickListener {
                isFavorite = !isFavorite
                detailAnimeViewModel.setFavoriteAnime(detailAnime, isFavorite)
                setStatusFavorite(isFavorite)
            }
        }
    }

    private fun setStatusFavorite(isFavorite: Boolean) {
        if (isFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_white))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_border_white))
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}