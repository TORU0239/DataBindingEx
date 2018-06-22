package my.com.toru.databindingex.ui

import android.os.Bundle
import android.support.v7.widget.Toolbar
import my.com.toru.databindingex.R
import my.com.toru.databindingex.viewmodel.AbsViewModel
import my.com.toru.databindingex.viewmodel.MainViewModel

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar = findViewById<Toolbar>(R.id.mainToolbar)
        setSupportActionBar(toolbar)
    }

    override fun initViewModel(): AbsViewModel = MainViewModel()
}