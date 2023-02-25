package com.excample.kitsu.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.excample.kitsu.R
import com.excample.kitsu.data.preferences.PreferenceData
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var userPreferencesData: PreferenceData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupNavigation()
    }

    private fun setupNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val navController = navHostFragment.navController

        val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)
        when {
            userPreferencesData.isAuthorized -> {
                navGraph.setStartDestination(R.id.pagerFlowFragment)
            }
            else -> {
                navGraph.setStartDestination(R.id.signInFlowFragment)
            }
        }
        navController.graph = navGraph
    }
}