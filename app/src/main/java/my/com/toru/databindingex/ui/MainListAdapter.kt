package my.com.toru.databindingex.ui

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import my.com.toru.databindingex.R
import my.com.toru.databindingex.BR
import my.com.toru.databindingex.data.MainListData
import my.com.toru.databindingex.databinding.AdapterMainListBinding

class MainListAdapter(private var itemList:ArrayList<MainListData>): RecyclerView.Adapter<MainListVH>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListVH{
        val binding:AdapterMainListBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.adapter_main_list, parent, false)

        return MainListVH(binding){
            Log.w("MainListAdapter", "item:: ${it.name}")
        }
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: MainListVH, position: Int) {
        holder.bind(itemList[position])
    }

    fun notifyDataChange(newList:ArrayList<MainListData>){
        itemList.addAll(newList)
        notifyDataSetChanged()
    }
}

class MainListVH(var binding:AdapterMainListBinding, private var callback:(item:MainListData)->Unit):RecyclerView.ViewHolder(binding.root){
    fun bind(item:MainListData){
        itemView.setOnClickListener {
            callback(item)
        }

        binding.apply {
            mainListData = item
            executePendingBindings()
        }
    }
}

class BindableAdapter(_adapter:MainListAdapter):BaseObservable(){
    @Bindable
    var adapter:MainListAdapter = _adapter

    set(value) {
        notifyPropertyChanged(BR.adapter)
    }

    fun test(){
        val list = ArrayList<MainListData>()
        list.add(MainListData("Natalia"))
        list.add(MainListData("Austeja"))
        list.add(MainListData("Patience"))
        adapter.notifyDataChange(list)
    }
}