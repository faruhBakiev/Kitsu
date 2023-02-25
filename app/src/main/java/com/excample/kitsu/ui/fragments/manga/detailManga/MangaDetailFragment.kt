package com.excample.kitsu.ui.fragments.manga.detailManga

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.excample.kitsu.R
import com.excample.kitsu.base.BaseFragment
import com.excample.kitsu.databinding.FragmentMangaDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MangaDetailFragment :
    BaseFragment<FragmentMangaDetailBinding, MangaDetailViewModel>(R.layout.fragment_manga_detail) {

    override val binding by viewBinding(FragmentMangaDetailBinding::bind)
    override val viewModel: MangaDetailViewModel by viewModels()
    private val navArgs by navArgs<MangaDetailFragmentArgs>()
    override fun setupSubscribes() {
        setupSubscribesManga()
    }
    private fun setupSubscribesManga() = with(binding) {
        viewModel.getSingleManga(navArgs.id).subscribe(
            onError = {
                Toast.makeText(requireContext(), "", Toast.LENGTH_SHORT).show()
            },
            onSuccess = {
                it.data.let {
                    Glide.with(mangaDetailIm.context)
                        .load(it.attributes.posterImageManga.original)
                        .into(mangaDetailIm)
                    mangaDetailTv.text = it.attributes.titles.enJp
                }
            })
    }
}