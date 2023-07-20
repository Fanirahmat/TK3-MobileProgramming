package com.example.tk3.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tk3.R
import com.example.tk3.data.entity.MyNumber

class MyNumberAdapter(var list: List<MyNumber>) :
    RecyclerView.Adapter<MyNumberAdapter.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var tvNumber: TextView
        init {
            tvNumber = view.findViewById(R.id.tvNumber)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.row_my_number, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvNumber.text = list[position].numValue.toString()
    }
}