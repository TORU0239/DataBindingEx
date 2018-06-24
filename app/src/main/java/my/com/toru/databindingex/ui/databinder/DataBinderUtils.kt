package my.com.toru.databindingex.ui.databinder

import android.databinding.BindingAdapter
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class DataBinderUtils {
    companion object {
        @BindingAdapter("binding:rcvAdapter")
        fun setRcvAdapter(recyclerView: RecyclerView, adapter:RecyclerView.Adapter<RecyclerView.ViewHolder>){
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
        }
    }
}