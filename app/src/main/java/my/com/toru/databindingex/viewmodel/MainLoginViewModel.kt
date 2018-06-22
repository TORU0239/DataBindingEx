package my.com.toru.databindingex.viewmodel

import android.databinding.ObservableField
import android.util.Log
import android.view.View
import my.com.toru.databindingex.data.UserLogin

class MainLoginViewModel {
    companion object {
        private val TAG = MainLoginViewModel::class.java.simpleName
    }

    val loginModel:ObservableField<UserLogin> = ObservableField()
    init {
        loginModel.set(UserLogin("", ""))
    }

    fun sendLoginInfo(v: View){
        Log.w(TAG, "TEST")
        Log.w(TAG, "email:::" + loginModel.get()?.email)
        Log.w(TAG, "password:::" + loginModel.get()?.password)
    }
}