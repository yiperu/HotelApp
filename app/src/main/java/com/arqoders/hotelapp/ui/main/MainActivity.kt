package com.arqoders.hotelapp.ui.main

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.arqoders.hotelapp.databinding.ActivityMainBinding
import com.arqoders.hotelapp.ui.common.PermissionRequester
import com.arqoders.hotelapp.ui.common.startActivity
import com.arqoders.hotelapp.ui.detail.DetailActivity
import com.arqoders.hotelapp.ui.main.MainViewModel.UiModel
import org.koin.androidx.scope.ScopeActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ScopeActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: HotelsAdapter
    private val coarsePermissionRequester =
        PermissionRequester(this, ACCESS_COARSE_LOCATION)

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = HotelsAdapter(viewModel::onHotelClicked)
        binding.recycler.adapter = adapter
        viewModel.model.observe(this, Observer(::updateUi))
    }

    private fun updateUi(model: UiModel) {

        binding.progress.visibility = if (model is UiModel.Loading) View.VISIBLE else View.GONE

        when (model) {
            is UiModel.Content -> adapter.hotels = model.hotels
            is UiModel.Navigation -> startActivity<DetailActivity> {
                putExtra(DetailActivity.HOTEL, model.hotel.id)
            }
            UiModel.RequestLocationPermission -> coarsePermissionRequester.request {
                viewModel.onCoarsePermissionRequested()
            }
        }
    }
}