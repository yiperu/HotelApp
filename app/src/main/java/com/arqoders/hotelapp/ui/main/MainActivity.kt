package com.arqoders.hotelapp.ui.main

import android.os.Bundle
import com.arqoders.hotelapp.R
import com.arqoders.hotelapp.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.getViewModel

class MainActivity : BaseActivity<MainViewState, MainViewModel>() {
    override fun initViewModel(): MainViewModel = getViewModel()

    override fun getLayoutResource(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.initialize()
    }

    override fun onViewStateUpdated(viewState: MainViewState) {
    }
}