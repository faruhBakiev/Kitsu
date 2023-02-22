package com.excample.kitsu.ui.fragments.signin

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.excample.kitsu.R
import com.excample.kitsu.accessToken
import com.excample.kitsu.base.BaseFragment
import com.excample.kitsu.data.models.auth.AuthModel
import com.excample.kitsu.data.preferences.PreferenceData
import com.excample.kitsu.databinding.FragmentSignInBinding
import com.excample.kitsu.extensions.toast
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SignInFragment : BaseFragment<FragmentSignInBinding, SignInViewModel>(
    R.layout.fragment_sign_in
) {
    @Inject
    lateinit var PreferenceData: PreferenceData
    override val binding by viewBinding(FragmentSignInBinding::bind)
    override val viewModel: SignInViewModel by viewModels()

    override fun setupSubscribes() = with(binding) {

        binding.signInBtn.setOnClickListener {
            val email = emailEt.text.toString()
            val password = passwordEt.text.toString()
            val authModel = AuthModel("password", email, password)

            viewModel.postUserData(authModel).observe(viewLifecycleOwner) {
                PreferenceData.apply {
                    isAuthorized = true
                    accessToken = accessToken
                    refreshToken = refreshToken
                }

                findNavController().navigate(
                    R.id.pagerFragment
                )
            }
        }
    }
}

