package my.com.toru.databindingex.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import my.com.toru.databindingex.R
import my.com.toru.databindingex.databinding.ActivityLoginBinding
import my.com.toru.databindingex.viewmodel.AbsViewModel
import my.com.toru.databindingex.viewmodel.LoginViewModel

class LoginActivity : BaseActivity() {
    override fun initViewModel(): AbsViewModel = LoginViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityLoginBinding = DataBindingUtil.setContentView(LoginActivity@this, R.layout.activity_login)
        absViewModel.onCreate()
        binding.userViewModel = absViewModel as LoginViewModel
        binding.executePendingBindings()
    }
}