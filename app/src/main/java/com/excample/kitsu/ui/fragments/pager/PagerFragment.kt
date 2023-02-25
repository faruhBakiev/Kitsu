package com.excample.kitsu.ui.fragments.pager

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.excample.kitsu.R
import com.excample.kitsu.databinding.FragmentPagerBinding
import com.excample.kitsu.ui.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class PagerFragment : Fragment(R.layout.fragment_pager) {

    private val binding by viewBinding (FragmentPagerBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }
    private fun initialize() {
        tabLayout()
    }
    private fun tabLayout(){
        val viewPagerAdapter = ViewPagerAdapter(this)
        binding.viewPager.adapter = viewPagerAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Anime"
                }
                1 -> {
                    tab.text = "Manga"
                }
            }
        }.attach()
    }
}