package com.excample.kitsu.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.excample.kitsu.data.models.anime.AnimeItem
import com.excample.kitsu.databinding.AnimeItemBinding

class AnimeAdapter(private val clickListener: (id: String) -> Unit) :
    PagingDataAdapter<AnimeItem, AnimeAdapter.AnimeViewHolder>(diffUtil) {

    inner class AnimeViewHolder(private val binding: AnimeItemBinding) :
        ViewHolder(binding.root) {

        fun onBind(item: AnimeItem) = with(binding) {
            Glide.with(binding.ivAnime.context)
                .load(item.attributes.posterImage.original)
                .into(binding.ivAnime)
            binding.tvName.text = item.attributes.titles.enJp
        }

        init {
            itemView.setOnClickListener {
                getItem(bindingAdapterPosition)?.apply { clickListener(id) }
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        return AnimeViewHolder(
            AnimeItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }


    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<AnimeItem>() {
            override fun areItemsTheSame(oldItem: AnimeItem, newItem: AnimeItem): Boolean {
                return oldItem.attributes.titles == newItem.attributes.titles
            }

            override fun areContentsTheSame(oldItem: AnimeItem, newItem: AnimeItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}