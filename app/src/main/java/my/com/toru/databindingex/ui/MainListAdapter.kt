package my.com.toru.databindingex.ui

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import my.com.toru.databindingex.R
import my.com.toru.databindingex.data.MainListData
import my.com.toru.databindingex.databinding.AdapterMainListBinding

class MainListAdapter(private var itemList:ArrayList<MainListData>): RecyclerView.Adapter<MainListVH>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainListVH{
        val binding:AdapterMainListBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.adapter_main_list, parent, false)
        return MainListVH(binding)
    }

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: MainListVH, position: Int) {
        holder.bind(itemList[position])
    }

    fun notifyDataChange(newList:ArrayList<MainListData>){
        itemList.clear()
        itemList.addAll(newList)
        notifyDataSetChanged()
    }
}

class MainListVH(var binding:AdapterMainListBinding):RecyclerView.ViewHolder(binding.root){
    fun bind(item:MainListData){
        binding.mainText.text = item.name
    }
}