package com.excample.kitsu.ui.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.excample.kitsu.ui.fragments.anime.AnimeFragment
import com.excample.kitsu.ui.fragments.manga.MangaFragment

class ViewPagerAdapter (fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                AnimeFragment()
            }
            else -> {
                MangaFragment()
            }
        }
    }
}