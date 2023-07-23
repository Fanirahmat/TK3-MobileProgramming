package com.example.tk3.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.tk3.R
import com.example.tk3.data.AppDatabase
import com.example.tk3.data.entity.MyNumber


class HomeFragment : Fragment() {

    private lateinit var saveButton: Button
    private lateinit var resultText: TextView
    private lateinit var database: AppDatabase

    private lateinit var myContext: Context

    private var currentNumber: StringBuilder = StringBuilder()

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

        saveButton = view.findViewById(R.id.buttonSave)
        resultText = view.findViewById(R.id.textViewResult)
        database = AppDatabase.getInstance(myContext)

        val numberButtons: List<Button> = listOf(
            view.findViewById(R.id.zero),
            view.findViewById(R.id.one),
            view.findViewById(R.id.two),
            view.findViewById(R.id.three),
            view.findViewById(R.id.four),
            view.findViewById(R.id.five),
            view.findViewById(R.id.six),
            view.findViewById(R.id.seven),
            view.findViewById(R.id.eight),
            view.findViewById(R.id.nine)
        )

        for (button in numberButtons) {
            button.setOnClickListener {
                val digit = button.text.toString()
                currentNumber.append(digit)
                resultText.text = currentNumber.toString()
            }
        }

        saveButton.setOnClickListener {
            val number = resultText.text.toString()

            if (number.isNotEmpty()) {
                database.numberDao().insertAll(
                    MyNumber(null, number.toInt())
                )
            }
            currentNumber.clear()
            resultText.text = currentNumber.toString()
            Toast.makeText(requireContext(), "Angka Tersimpan", Toast.LENGTH_SHORT).show()
        }
    }

}