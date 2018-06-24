package my.com.toru.databindingex.ui


import android.databinding.DataBindingUtil
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.VERTICAL
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import my.com.toru.databindingex.R
import my.com.toru.databindingex.data.MainListData
import my.com.toru.databindingex.databinding.FragmentMainListBinding

class MainListFragment : Fragment() {

    private lateinit var binding: FragmentMainListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        Log.w("MainListFragment", "onCreateView")
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.w("MainListFragment", "onViewCreated")
        // test dummy data //
        val dummyList = ArrayList<MainListData>()
        dummyList.apply {
            add(MainListData("Toru"))
            add(MainListData("Kar Heng"))
            add(MainListData("Wan San"))
            add(MainListData("Ichi"))
            add(MainListData("Abby"))
            add(MainListData("Alex"))
        }

        binding.mainListRcv.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = MainListAdapter(dummyList)
            setHasFixedSize(true)
            addItemDecoration(DividerItemDecoration(context, VERTICAL))
        }
    }
}