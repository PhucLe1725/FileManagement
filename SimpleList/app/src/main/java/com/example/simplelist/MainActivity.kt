package com.example.simplelist

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextNumber: EditText = findViewById(R.id.editTextNumber)
        val radioEven: RadioButton = findViewById(R.id.radioEven)
        val radioOdd: RadioButton = findViewById(R.id.radioOdd)
        val radioSquare: RadioButton = findViewById(R.id.radioSquare)
        val buttonShow: Button = findViewById(R.id.buttonShow)
        val listViewResult: ListView = findViewById(R.id.listViewResult)
        val textViewError: TextView = findViewById(R.id.textViewError)

        buttonShow.setOnClickListener {
            val nText = editTextNumber.text.toString()
            textViewError.visibility = TextView.GONE

            if (nText.isEmpty()) {
                textViewError.text = "Vui lòng nhập một số nguyên dương"
                textViewError.visibility = TextView.VISIBLE
                return@setOnClickListener
            }

            val n = nText.toIntOrNull()
            if (n == null || n < 0) {
                textViewError.text = "Vui lòng nhập một số nguyên dương hợp lệ"
                textViewError.visibility = TextView.VISIBLE
                return@setOnClickListener
            }

            val results = when {
                radioEven.isChecked -> getEvenNumbers(n)
                radioOdd.isChecked -> getOddNumbers(n)
                radioSquare.isChecked -> getSquareNumbers(n)
                else -> emptyList()
            }

            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, results)
            listViewResult.adapter = adapter
        }
    }

    private fun getEvenNumbers(n: Int): List<Int> {
        val evens = mutableListOf<Int>()
        for (i in 0..n step 2) {
            evens.add(i)
        }
        return evens
    }

    private fun getOddNumbers(n: Int): List<Int> {
        val odds = mutableListOf<Int>()
        for (i in 1..n step 2) {
            odds.add(i)
        }
        return odds
    }

    private fun getSquareNumbers(n: Int): List<Int> {
        val squares = mutableListOf<Int>()
        for (i in 0..sqrt(n.toDouble()).toInt()) {
            squares.add(i * i)
        }
        return squares
    }
}
