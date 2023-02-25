package com.excample.kitsu.ui.fragments.pager.flow

import com.excample.kitsu.R
import com.excample.kitsu.base.BaseFlowFragment

class PagerFlowFragment : BaseFlowFragment(R.layout.fragment_pager_flow) {
    override val navigationId: Int
        get() = R.id.pager_host_fragment
}