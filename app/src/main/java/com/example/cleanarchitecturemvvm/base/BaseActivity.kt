package com.example.cleanarchitecturemvvm.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<vb: ViewBinding?> : AppCompatActivity() {

    private var bind : vb? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = getActivityBinding(layoutInflater)
        val view = bind?.root
        setContentView(view)
        onInit()
        onOtherActivity()
    }

    override fun onDestroy() {
        super.onDestroy()
        bind = null
    }

    abstract fun onOtherActivity()
    abstract fun onInit()
    abstract fun getActivityBinding(layoutinflater: LayoutInflater ) : vb

}
