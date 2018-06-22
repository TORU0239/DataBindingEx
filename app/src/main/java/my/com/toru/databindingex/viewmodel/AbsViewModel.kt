package my.com.toru.databindingex.viewmodel

interface AbsViewModel {
    fun onCreate()
    fun onResume()
    fun onPause()
    fun onDestroy()
}