package my.com.toru.databindingex.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import my.com.toru.databindingex.R
import my.com.toru.databindingex.databinding.ActivityMainBinding
import my.com.toru.databindingex.viewmodel.AbsViewModel
import my.com.toru.databindingex.viewmodel.MainLoginViewModel

class MainActivity : BaseActivity() {
    override fun initViewModel(): AbsViewModel = MainLoginViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMainBinding = DataBindingUtil.setContentView(MainActivity@this, R.layout.activity_main)

        absViewModel.onCreate()
        binding.userViewModel = absViewModel as MainLoginViewModel
        binding.executePendingBindings()
    }
}