package com.example.tk3.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.tk3.R
import com.example.tk3.data.AppDatabase
import com.example.tk3.data.entity.MyNumber


class HomeFragment : Fragment() {

    private lateinit var btnSave: Button
    private lateinit var editText:EditText
    private lateinit var database: AppDatabase

    private lateinit var myContext: Context

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        myContext = container?.context!!
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnSave = view.findViewById(R.id.button)
        editText = view.findViewById(R.id.editText)
        database = AppDatabase.getInstance(myContext)

        btnSave.setOnClickListener {
            val textNumber = editText.text.toString()

            if (textNumber.isNotEmpty()) {
                database.numberDao().insertAll(
                    MyNumber(null, textNumber.toInt())
                )

            }
            // Clear the input fields
            editText.text.clear()
        }
    }

}