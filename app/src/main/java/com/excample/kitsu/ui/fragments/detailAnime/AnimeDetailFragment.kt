package com.excample.kitsu.ui.fragments.detailAnime

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.excample.kitsu.R
import com.excample.kitsu.databinding.FragmentAnimeBinding
import com.excample.kitsu.databinding.FragmentAnimeDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeDetailFragment : Fragment(R.layout.fragment_anime_detail) {

    private val binding by viewBinding(FragmentAnimeDetailBinding::bind)
    private val navArgs by navArgs<AnimeDetailFragmentArgs>()
    private val viewModel : AnimeDetailViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObserves()
    }

    private fun setupObserves() {
        viewModel.getSingleAnime(navArgs.id).observe(viewLifecycleOwner){
            Glide.with(binding.imageDetail.context).load(it.data.attributes.posterImage.original).into(binding.imageDetail)
            binding.textDetail.text = it.data.attributes.titles.enJp
        }
    }
}