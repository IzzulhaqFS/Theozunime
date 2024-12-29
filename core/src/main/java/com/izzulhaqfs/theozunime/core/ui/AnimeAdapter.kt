package com.izzulhaqfs.theozunime.core.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.izzulhaqfs.theozunime.core.databinding.ItemListAnimeBinding
import com.izzulhaqfs.theozunime.core.domain.model.Anime

class AnimeAdapter : ListAdapter<Anime, AnimeAdapter.ListViewHolder>(DIFF_CALLBACK) {
    var onItemClick: ((Anime) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeAdapter.ListViewHolder {
        return ListViewHolder(
            ItemListAnimeBinding.inflate(
                android.view.LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AnimeAdapter.ListViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
    }

    inner class ListViewHolder(private var binding: ItemListAnimeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Anime) {
            val startSeason = data.startSeason + " " + data.startYear

            Glide.with(itemView.context)
                .load(data.mainPictureMedium)
                .into(binding.imgListAnime)
            binding.tvListAnimeTitle.text = data.title
            binding.tvListStartSeason.text = startSeason
            binding.tvListScore.text = data.mean.toString()
        }

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(getItem(bindingAdapterPosition))
            }
        }
    }

    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<Anime> =
            object : DiffUtil.ItemCallback<Anime>() {
                override fun areItemsTheSame(oldItem: Anime, newItem: Anime): Boolean {
                    return oldItem.id == newItem.id
                }

                override fun areContentsTheSame(oldItem: Anime, newItem: Anime): Boolean {
                    return oldItem == newItem
                }
            }
    }
}