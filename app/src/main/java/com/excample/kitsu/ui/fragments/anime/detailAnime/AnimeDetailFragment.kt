package com.excample.kitsu.ui.fragments.anime.detailAnime

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.excample.kitsu.R
import com.excample.kitsu.base.BaseFragment
import com.excample.kitsu.databinding.FragmentAnimeDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeDetailFragment :
    BaseFragment<FragmentAnimeDetailBinding, AnimeDetailViewModel>(R.layout.fragment_anime_detail) {

    override val binding by viewBinding (FragmentAnimeDetailBinding::bind)
    private val navArgs by navArgs<AnimeDetailFragmentArgs>()
    override val viewModel: AnimeDetailViewModel by viewModels()

    override fun setupSubscribes() {
        subscribeAnimeDetail()
    }

    private fun subscribeAnimeDetail() = with(binding) {
        viewModel.getSingleAnime(navArgs.id).subscribe(

            onError = {
                Toast.makeText(requireContext(), "asd", Toast.LENGTH_SHORT).show()
            },
            onSuccess = {
                it.data.let {
                    Glide.with(animeDetailIm.context)
                        .load(it.attributes.posterImage.original)
                        .into(animeDetailIm)
                    animeDetailTv.text = it.attributes.titles.enJp
                }
            })
    }
    }
