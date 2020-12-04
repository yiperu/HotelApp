package com.arqoders.hotelapp.ui.home

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import com.arqoders.hotelapp.R
import com.arqoders.hotelapp.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.getViewModel

class HomeFragment : BaseFragment<HomeViewState, HomeViewModel>() {
    override fun initViewModel(): HomeViewModel = getViewModel()

    override fun getLayoutResource(): Int = R.layout.fragment_home

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.initialize()
    }

    override fun onViewStateUpdated(viewState: HomeViewState) {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(this) {
            requireActivity().finish()
        }
    }
}