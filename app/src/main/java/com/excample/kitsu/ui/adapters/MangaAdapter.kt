package com.excample.kitsu.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.excample.kitsu.data.models.manga.MangaItem
import com.excample.kitsu.databinding.MangaItemBinding

class MangaAdapter(private val onClickListener: (id: String) -> Unit) :
    PagingDataAdapter<MangaItem, MangaAdapter.MangaViewHolder>(diffUtil) {

    inner class MangaViewHolder(private val binding: MangaItemBinding) :
        ViewHolder(binding.root) {

        fun onBind(item: MangaItem) = with(binding) {
            Glide.with(binding.ivManga.context)
                .load(item.attributes.posterImageManga.original)
                .into(ivManga)
            binding.tvManga.text = item.attributes.titles.enJp
        }

        init {
            itemView.setOnClickListener {
                getItem(bindingAdapterPosition)?.apply { onClickListener(id) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MangaViewHolder {
        return MangaViewHolder(
            MangaItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MangaViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<MangaItem>() {
            override fun areItemsTheSame(oldItem: MangaItem, newItem: MangaItem): Boolean {
                return oldItem.attributes.titles == newItem.attributes.titles
            }

            override fun areContentsTheSame(oldItem: MangaItem, newItem: MangaItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}
