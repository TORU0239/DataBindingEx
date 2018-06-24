package my.com.toru.databindingex.ui.databinder

import android.databinding.BindingAdapter
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import my.com.toru.databindingex.ui.MainListAdapter

class DataBinderUtils {
    companion object {
        @BindingAdapter("rcvAdapter")
        @JvmStatic
        fun RecyclerView.setRcvAdapter(adapter:MainListAdapter){
            this.adapter = adapter
            this.layoutManager = LinearLayoutManager(this.context)
            this.setHasFixedSize(true)
            this.addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
        }
    }

}