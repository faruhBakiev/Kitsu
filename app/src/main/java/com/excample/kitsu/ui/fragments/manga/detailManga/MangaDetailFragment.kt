package com.excample.kitsu.ui.fragments.manga.detailManga

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.excample.kitsu.R
import com.excample.kitsu.base.BaseFragment
import com.excample.kitsu.databinding.FragmentMangaDetailBinding
import com.excample.kitsu.extensions.toast
import com.excample.kitsu.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MangaDetailFragment :
    BaseFragment<FragmentMangaDetailBinding, MangaDetailViewModel>(R.layout.fragment_manga_detail) {

    override val binding by viewBinding (FragmentMangaDetailBinding::bind)
    override val viewModel: MangaDetailViewModel by viewModels ()
    private val navArgs by navArgs<MangaDetailFragmentArgs>()

    override fun setupSubscribes() {
        setupSubscribesManga()
    }
    private fun setupSubscribesManga() = with(binding){
        viewModel.getSingleManga(navArgs.id).observe(viewLifecycleOwner){
            when (it) {
                is Resource.Error -> {
                    toast(it.message)
                }
                is Resource.Loading -> {
                    toast("Loading")
                }
                is Resource.Success -> {
                    Glide.with(mangaDetailIm.context)
                        .load(it.data?.data?.attributes?.posterImageManga?.original)
                        .into(mangaDetailIm)
                    mangaDetailTv.text = it.data?.data?.attributes?.titles?.enJp
                    toast("Success")
                }
            }
        }
    }
}





//    viewModel.getSingleManga(navArgs.id).observe(viewLifecycleOwner){
//            Glide.with(binding.mangaDetailIm.context).load(it.data.attributes.posterImage.original).into(binding.mangaDetailIm)
//            binding.mangaDetailTv.text = it.data.attributes.titles.enJp