package com.excample.kitsu.ui.fragments.signin.flow

import com.excample.kitsu.R
import com.excample.kitsu.base.BaseFlowFragment


class SignInFlowFragment  : BaseFlowFragment(R.layout.fragment_sign_in_flow) {
    override val navigationId: Int
        get() = R.id.sign_up_host_fragment
}