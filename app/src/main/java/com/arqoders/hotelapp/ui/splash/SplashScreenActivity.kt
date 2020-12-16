package com.arqoders.hotelapp.ui.splash

import android.content.Intent
import android.os.Bundle
import com.arqoders.hotelapp.R
import com.arqoders.hotelapp.base.BaseActivity
import com.arqoders.hotelapp.ui.main.MainActivity
import org.koin.androidx.viewmodel.ext.android.getViewModel

class SplashScreenActivity : BaseActivity<SplashScreenViewState, SplashScreenViewModel>() {
    override fun initViewModel(): SplashScreenViewModel = getViewModel()

    override fun getLayoutResource(): Int = R.layout.splash_activity

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme_SplashScreen)
        super.onCreate(savedInstanceState)
        viewModel.initialize()

        val background = object : Thread(){
            override fun run(){
                try{
                    Thread.sleep(1500)
                    val intent = Intent(baseContext, MainActivity::class.java)
                    startActivity(intent)
                }catch (e: Exception){}
            }
        }
        background.start()

    }
    override fun onViewStateUpdated(viewState: SplashScreenViewState) {
    }
}