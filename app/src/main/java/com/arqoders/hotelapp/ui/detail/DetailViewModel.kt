package com.arqoders.hotelapp.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.arqoders.domain.Hotel
import com.arqoders.hotelapp.ui.common.ScopedViewModel
import com.arqoders.usecases.FindHotelById
import com.arqoders.usecases.ToggleHotelFavorite
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class DetailViewModel(
    private val hotelId: Int,
    private val findHotelById: FindHotelById,
    private val toggleHotelFavorite: ToggleHotelFavorite,
    override val uiDispatcher: CoroutineDispatcher
) :
    ScopedViewModel(uiDispatcher) {

    data class UiModel(val hotel: Hotel)

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
            if (_model.value == null) findHotel()
            return _model
        }

    private fun findHotel() = launch {
        _model.value = UiModel(findHotelById.invoke(hotelId))
    }

    fun onFavoriteClicked() = launch {
        _model.value?.hotel?.let {
            _model.value = UiModel(toggleHotelFavorite.invoke(it))
        }
    }
}