package com.excample.kitsu.ui.fragments.anime

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.excample.kitsu.R
import com.excample.kitsu.databinding.FragmentAnimeBinding
import com.excample.kitsu.extensions.toast
import com.excample.kitsu.ui.adapters.AnimeAdapter
import com.excample.kitsu.ui.fragments.pager.PagerFragmentDirections
import com.excample.kitsu.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeFragment : Fragment(R.layout.fragment_anime) {

    private val binding by viewBinding(FragmentAnimeBinding::bind)
    private val viewModel by viewModels<AnimeViewModel>()
    private val animeAdapter = AnimeAdapter(this::onClickFirstListener)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupObserves()
    }
    private fun initialize() {
        binding.recyclerView.adapter = animeAdapter
    }

    private fun setupObserves() {
        viewModel.getAnime().observe(viewLifecycleOwner) {
            when (it){
                is Resource.Error -> {
                    toast(it.message)
                }
                is Resource.Loading -> {
                    toast("Loading")
                }
                is Resource.Success -> {
                    animeAdapter.submitList(it.data?.data)
                    toast("Success")
                }
            }
        }
    }

    private fun onClickFirstListener(id: String){
        findNavController().navigate(
            PagerFragmentDirections.actionPagerFragmentToAnimeDetailFragment(id.toInt())
        )
    }
}