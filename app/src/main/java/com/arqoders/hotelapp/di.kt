package com.arqoders.hotelapp

import android.app.Application
import com.arqoders.data.repository.HotelsRepository
import com.arqoders.data.repository.PermissionChecker
import com.arqoders.data.repository.RegionRepository
import com.arqoders.hotelapp.data.AndroidPermissionChecker
import com.arqoders.hotelapp.ui.detail.DetailActivity
import com.arqoders.hotelapp.ui.detail.DetailViewModel
import com.arqoders.hotelapp.ui.main.MainActivity
import com.arqoders.hotelapp.ui.main.MainViewModel
import com.arqoders.usecases.FindHotelById
import com.arqoders.usecases.GetHotels
import com.arqoders.usecases.ToggleHotelFavorite
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun Application.initDI() {
    startKoin {
        androidLogger()
        androidContext(this@initDI)
        modules(listOf(appModule, dataModule, scopesModule ))
    }
}

private val appModule = module {
    single(named("apiKey")) { androidApplication().getString(R.string.api_key) }
    factory<PermissionChecker> { AndroidPermissionChecker(get()) }
    single<CoroutineDispatcher> { Dispatchers.Main }
    single(named("baseUrl")) { "https://hotels4.p.rapidapi.com/" }
}

val dataModule = module {
    factory { RegionRepository(get(), get()) }
    factory { HotelsRepository(get(), get(), get(), get(named("apiKey"))) }
}

private val scopesModule = module {
    scope(named<MainActivity>()) {
        viewModel { MainViewModel(get(), get()) }
        scoped { GetHotels(get()) }
    }

    scope(named<DetailActivity>()) {
        viewModel { (id: Int) -> DetailViewModel(id, get(), get(), get()) }
        scoped { FindHotelById(get()) }
        scoped { ToggleHotelFavorite(get()) }
    }
}
