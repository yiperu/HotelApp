package com.arqoders.hotelapp.ui.detail

import com.arqoders.hotelapp.databinding.ActivityDetailBinding
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.arqoders.hotelapp.R
import org.koin.androidx.scope.ScopeActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class DetailActivity : ScopeActivity() {
    companion object {
        const val HOTEL = "DetailActivity:hotel"
    }

    private val viewModel: DetailViewModel by viewModel {
        parametersOf(intent.getIntExtra(HOTEL, -1))
    }

    private lateinit var binding: ActivityDetailBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.model.observe(this, Observer(::updateUi))

        binding.hotelDetailFavorite.setOnClickListener { viewModel.onFavoriteClicked() }
    }

    private fun updateUi(model: DetailViewModel.UiModel) = with(binding) {
        val hotel = model.hotel
        hotelDetailToolbar.title = hotel.name

        val icon = if (hotel.favorite) R.drawable.ic_favorite_on else R.drawable.ic_favorite_off
        hotelDetailFavorite.setImageDrawable(ContextCompat.getDrawable(this@DetailActivity, icon))
    }
}