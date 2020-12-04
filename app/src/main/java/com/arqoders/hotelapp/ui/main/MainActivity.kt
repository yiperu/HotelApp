package com.arqoders.hotelapp.ui.main

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import com.arqoders.hotelapp.R
import com.arqoders.hotelapp.base.BaseActivity
import com.arqoders.hotelapp.util.ARGUMENT_HOME
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : BaseActivity<MainViewState, MainViewModel>() {
    override fun initViewModel(): MainViewModel = getViewModel()

    override fun getLayoutResource(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.initialize()
        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_home -> findNavController(R.id.main_activity_root)
                    .navigate(R.id.nav_home_fragment)
            }
            true
        }
    }

    override fun onViewStateUpdated(viewState: MainViewState) {
    }
}