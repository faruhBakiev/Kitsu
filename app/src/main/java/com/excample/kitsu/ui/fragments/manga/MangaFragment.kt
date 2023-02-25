package com.excample.kitsu.ui.fragments.manga

import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.excample.kitsu.R
import com.excample.kitsu.base.BaseFragment
import com.excample.kitsu.databinding.FragmentMangaBinding
import com.excample.kitsu.ui.adapters.MangaAdapter
import com.excample.kitsu.ui.fragments.pager.PagerFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MangaFragment : BaseFragment<FragmentMangaBinding, MangaViewModel>(
    R.layout.fragment_manga
) {

    override val binding by viewBinding(FragmentMangaBinding::bind)
    override val viewModel: MangaViewModel by viewModels()
    private val mangaAdapter = MangaAdapter(this::onSecondClickListener)

    override fun setupSubscribes() {
        subscribeToManga()
    }

    private fun subscribeToManga() {
        viewModel.getManga().observe(viewLifecycleOwner) {
            lifecycleScope.launch {
                mangaAdapter.submitData(it)
            }
        }
    }

    override fun initialize() {
        super.initialize()
        binding.recyclerViewManga.adapter = mangaAdapter
    }

    private fun onSecondClickListener(id: String) {
        findNavController().navigate(
            PagerFragmentDirections.actionPagerFragmentToMangaDetailFragment(id.toInt())
        )
    }
}