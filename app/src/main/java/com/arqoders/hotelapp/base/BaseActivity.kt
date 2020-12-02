package com.arqoders.hotelapp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

abstract class BaseActivity<VS, VM : BaseViewModel<VS>> : AppCompatActivity() {
    protected lateinit var viewModel: VM
    abstract fun initViewModel(): VM
    abstract fun getLayoutResource(): Int
    abstract fun onViewStateUpdated(viewState: VS)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = initViewModel()
        viewModel.resourceViewState.observe(this, viewStateObserver)
        setContentView(getLayoutResource())
    }

    private val viewStateObserver = Observer<VS> { viewState ->
        onViewStateUpdated(viewState)
    }
}