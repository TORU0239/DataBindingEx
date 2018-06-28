package my.com.toru.kdatabinding.ui

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import my.com.toru.kdatabinding.R
import my.com.toru.kdatabinding.databinding.ActivityLoginBinding
import my.com.toru.kdatabinding.viewmodel.LogiinViewModel

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val binding:ActivityLoginBinding = DataBindingUtil.setContentView(this@LoginActivity, R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this).get(LogiinViewModel::class.java)
        binding.let{
            it.loginViewModel = viewModel
            it.setLifecycleOwner(this)
        }
    }
}