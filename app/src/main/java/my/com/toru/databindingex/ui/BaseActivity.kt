package my.com.toru.databindingex.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import my.com.toru.databindingex.viewmodel.AbsViewModel

abstract class BaseActivity : AppCompatActivity() {
    lateinit var absViewModel:AbsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        absViewModel = initViewModel()
        absViewModel.onCreate()
    }

    abstract fun initViewModel():AbsViewModel

    override fun onResume() {
        super.onResume()
        absViewModel.onResume()
    }

    override fun onPause() {
        super.onPause()
        absViewModel.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        absViewModel.onDestroy()
    }
}