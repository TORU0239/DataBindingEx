package my.com.toru.databindingex.ui

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import my.com.toru.databindingex.R
import my.com.toru.databindingex.databinding.ActivityMainBinding
import my.com.toru.databindingex.viewmodel.MainLoginViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding:ActivityMainBinding = DataBindingUtil.setContentView(MainActivity@this, R.layout.activity_main)
        binding.userViewModel = MainLoginViewModel()
    }
}