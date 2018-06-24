package my.com.toru.databindingex.data

import android.databinding.BaseObservable
import android.databinding.Bindable
import my.com.toru.databindingex.BR

data class MainListData(private var _name:String):BaseObservable(){
    @Bindable
    var name:String = _name

    set(value) {
        field = value
        notifyPropertyChanged(BR.name)
    }
}