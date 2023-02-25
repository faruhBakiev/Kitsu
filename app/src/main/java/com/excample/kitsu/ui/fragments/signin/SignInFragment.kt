package com.excample.kitsu.ui.fragments.signin

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.excample.kitsu.R
import com.excample.kitsu.base.BaseFragment
import com.excample.kitsu.data.models.auth.AuthModel
import com.excample.kitsu.data.preferences.PreferenceData
import com.excample.kitsu.databinding.FragmentSignInBinding
import com.excample.kitsu.extensions.showText
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
            viewModel.postUserData(authModel).subscribe(
                onError = {
                    Log.e("tag", "log: $it")
                },
                onSuccess = { token ->
                    showText("$token")
                    if (token != null) {
                        PreferenceData.apply {
                            isAuthorized = true
                            accessToken = token.accessToken
                            refreshToken = token.refreshToken
                        }
                        findNavController().navigate(
                            R.id.action_signInFragment_to_pagerFragment
                        )
                    }
                })
        }
    }
}

