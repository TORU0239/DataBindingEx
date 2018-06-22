package my.com.toru.databindingex.viewmodel

import android.content.Intent
import android.databinding.ObservableField
import android.util.Log
import android.view.View
import android.widget.Toast
import my.com.toru.databindingex.data.UserLogin
import my.com.toru.databindingex.ui.MainActivity

class LoginViewModel : AbsViewModel{
    companion object {
        private val TAG = LoginViewModel::class.java.simpleName
    }

    val loginModel:ObservableField<UserLogin> = ObservableField()
    init {
        loginModel.set(UserLogin("", ""))
    }

    fun sendLoginInfo(v: View){
        Log.w(TAG, "email::" +  loginModel.get()?.email)
        Log.w(TAG, "password::" +  loginModel.get()?.password)
        v.context.startActivity(Intent(v.context, MainActivity::class.java))
    }

    fun signUpNewUser(v:View){
        Toast.makeText(v.context, "Now cannot sign up", Toast.LENGTH_SHORT).show()
        loginModel.get()?.apply {
            email = ""
            password = ""
        }

        Log.w(TAG, "model:: ${loginModel.get()?.email} + ${loginModel.get()?.password}")
    }

    override fun onCreate() {}

    override fun onResume() {}

    override fun onPause() {}

    override fun onDestroy() {}
}