package com.arqoders.hotelapp.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.arqoders.domain.Hotel
import com.arqoders.hotelapp.ui.common.ScopedViewModel
import com.arqoders.usecases.GetHotels
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class MainViewModel(
    private val getHotels: GetHotels,
    uiDispatcher: CoroutineDispatcher
) : ScopedViewModel(uiDispatcher) {

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
            if (_model.value == null) refresh()
            return _model
        }

    sealed class UiModel {
        object Loading : UiModel()
        data class Content(val hotels: List<Hotel>) : UiModel()
        data class Navigation(val hotel: Hotel) : UiModel()
        object RequestLocationPermission : UiModel()
    }

    init {
        initScope()
    }

    private fun refresh() {
        _model.value = UiModel.RequestLocationPermission
    }

    fun onCoarsePermissionRequested() {
        launch {
            _model.value = UiModel.Loading
            _model.value = UiModel.Content(getHotels.invoke())
        }
    }

    fun onHotelClicked(hotel: Hotel) {
        _model.value = UiModel.Navigation(hotel)
    }

    override fun onCleared() {
        destroyScope()
        super.onCleared()
    }
}