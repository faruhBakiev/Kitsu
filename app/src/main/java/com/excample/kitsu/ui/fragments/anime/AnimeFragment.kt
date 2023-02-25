package com.excample.kitsu.ui.fragments.anime

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.excample.kitsu.R
import com.excample.kitsu.databinding.FragmentAnimeBinding
import com.excample.kitsu.ui.adapters.AnimeAdapter
import com.excample.kitsu.ui.fragments.pager.PagerFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AnimeFragment : Fragment(R.layout.fragment_anime) {

    private val binding by viewBinding(FragmentAnimeBinding::bind)
    private val viewModel by viewModels<AnimeViewModel>()
    private val animeAdapter = AnimeAdapter(this::onClickFirstListener)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        subscribeAnime()
    }

    private fun subscribeAnime() {
        viewModel.getAnime().observe(viewLifecycleOwner){
            lifecycleScope.launch {
                animeAdapter.submitData(it)
            }
        }
    }

    private fun initialize() {
        binding.recyclerView.adapter = animeAdapter
    }
    private fun onClickFirstListener(id: String){
        findNavController().navigate(
            PagerFragmentDirections.actionPagerFragmentToAnimeDetailFragment(id.toInt())
        )
    }
}