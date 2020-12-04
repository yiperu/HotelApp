package com.arqoders.hotelapp

import android.app.Application
import com.arqoders.data.repository.HotelsRepository
import com.arqoders.data.repository.PermissionChecker
import com.arqoders.data.repository.RegionRepository
import com.arqoders.hotelapp.data.AndroidPermissionChecker
import com.arqoders.hotelapp.ui.detail.DetailActivity
import com.arqoders.hotelapp.ui.detail.DetailViewModel
import com.arqoders.hotelapp.ui.home.HomeViewModel
import com.arqoders.hotelapp.ui.main.MainActivity
import com.arqoders.hotelapp.ui.main.MainViewModel
import com.arqoders.hotelapp.ui.splash.SplashScreenViewModel
import com.arqoders.hotelapp.util.API_BASE_URL
import com.arqoders.hotelapp.util.API_KEY
import com.arqoders.hotelapp.util.API_LOCALE
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
import org.koin.core.module.Module
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
    single(named("apiKey")) { API_KEY }
    factory<PermissionChecker> { AndroidPermissionChecker(get()) }
    single<CoroutineDispatcher> { Dispatchers.Main }
    single(named("baseUrl")) { API_BASE_URL }
    single(named("locale")) { API_LOCALE }
    viewModel { SplashScreenViewModel() }
    viewModel { MainViewModel() }
    viewModel { HomeViewModel() }
}

val dataModule = module {
}

private val scopesModule = module {
    scope(named<MainActivity>()) {
    }
}
