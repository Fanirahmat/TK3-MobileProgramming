package com.example.tk3.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.tk3.R
import com.example.tk3.adapters.MyNumberAdapter
import com.example.tk3.data.AppDatabase
import com.example.tk3.data.entity.MyNumber

class ReportFragment : Fragment() {

    private lateinit var rvReport: RecyclerView
    private var list = mutableListOf<MyNumber>()
    private lateinit var adapter: MyNumberAdapter
    private lateinit var database: AppDatabase

    private lateinit var myContext: Context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        myContext = container?.context!!
        return inflater.inflate(R.layout.fragment_report, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        database = AppDatabase.getInstance(myContext)
        rvReport = view.findViewById(R.id.report_rv)
        adapter = MyNumberAdapter(list)

        rvReport.adapter = adapter
        rvReport.layoutManager = LinearLayoutManager(context, VERTICAL , false)
        rvReport.addItemDecoration(DividerItemDecoration(context, VERTICAL))

        getData()

    }

    override fun onResume() {
        super.onResume()
        getData()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun getData() {
        list.clear()
        list.addAll(database.numberDao().getAll())
        adapter.notifyDataSetChanged()
    }

}