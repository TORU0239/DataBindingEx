package my.com.toru.kdatabinding.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Intent
import android.util.Log
import android.view.View
import my.com.toru.kdatabinding.data.User
import my.com.toru.kdatabinding.ui.SignUpActivity

class LogiinViewModel: ViewModel() {
    var userData:MutableLiveData<User> = MutableLiveData()
    init {
        userData.value = User()
    }

    fun button(v: View){
        Log.w("LoginViewModel", "test:: " + userData.value?.email + ", password:: " + userData.value?.password)
    }

    fun signUp(v:View){
        v.context.startActivity(Intent(v.context, SignUpActivity::class.java))
    }
}