package my.com.toru.databindingex.viewmodel

import android.databinding.BaseObservable
import android.databinding.ObservableField
import my.com.toru.databindingex.data.UserLogin

class MainLoginViewModel: BaseObservable() {
    val loginModel:ObservableField<UserLogin> = ObservableField()
}