package com.example.test1

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtMsg: TextView = findViewById(R.id.txtMsg)
        val items: Array<String> = arrayOf("Data-0", "Data-1", "Data-2", "Data-3", "Data-4", "Data-5", "Data-6", "Data-7")
        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            items)
        findViewById<Spinner>(R.id.spinner1).run {
            adapter = arrayAdapter
            onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
                override fun onItemSelected(pe: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    txtMsg.text = items[p2]
                }

                override fun onNothingSelected(pe: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
        }
    }
}