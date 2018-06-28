package my.com.toru.kdatabinding.data

import android.databinding.BaseObservable
import android.databinding.Bindable
import my.com.toru.kdatabinding.BR

data class User(private var _email:String="", private var _password:String=""):BaseObservable(){
    @Bindable
    var email:String = _email

    set(value) {
        field = value
        notifyPropertyChanged(BR.email)
    }

    @Bindable
    var password:String = _password

        set(value) {
            field = value
            notifyPropertyChanged(BR.password)
        }

}