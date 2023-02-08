package com.excample.kitsu.ui.fragments.anime.detailAnime

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.excample.kitsu.R
import com.excample.kitsu.base.BaseFragment
import com.excample.kitsu.databinding.FragmentAnimeDetailBinding
import com.excample.kitsu.extensions.toast
import com.excample.kitsu.utils.Resource
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

    private fun subscribeAnimeDetail() = with(binding){
        viewModel.getSingleAnime(navArgs.id).observe(viewLifecycleOwner) {
            when (it){
                is Resource.Error -> {
                    toast(it.message)
                }
                is Resource.Loading -> {
                    toast("Loading")
                }
                is Resource.Success -> {
                    Glide.with(animeDetailIm.context)
                        .load(it.data?.data?.attributes?.posterImage?.original)
                        .into(animeDetailIm)
                    animeDetailTv.text = it.data?.data?.attributes?.titles?.enJp
                    toast("Success")
                }
            }
        }
    }
}
// viewModel.getSingleAnime(navArgs.id).observe(viewLifecycleOwner){
//            Glide.with(binding.animeDetailIm.context).load(it.data.attributes.posterImage.original).into(binding.animeDetailIm)
//            binding.animeDetailTv.text = it.data.attributes.titles.enJp
//        }