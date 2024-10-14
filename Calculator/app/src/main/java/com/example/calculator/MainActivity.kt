package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var resCalc: TextView

    var state: Int = 1
    var op: Int = 0
    var op1: Int = 0
    var op2: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resCalc = findViewById(R.id.resCalc)

        findViewById<Button>(R.id.button0).setOnClickListener(this)
        findViewById<Button>(R.id.button1).setOnClickListener(this)
        findViewById<Button>(R.id.button2).setOnClickListener(this)
        findViewById<Button>(R.id.button3).setOnClickListener(this)
        findViewById<Button>(R.id.button4).setOnClickListener(this)
        findViewById<Button>(R.id.button5).setOnClickListener(this)
        findViewById<Button>(R.id.button6).setOnClickListener(this)
        findViewById<Button>(R.id.button7).setOnClickListener(this)
        findViewById<Button>(R.id.button8).setOnClickListener(this)
        findViewById<Button>(R.id.button9).setOnClickListener(this)

        findViewById<Button>(R.id.buttonAdd).setOnClickListener(this)
        findViewById<Button>(R.id.buttonSubtract).setOnClickListener(this)
        findViewById<Button>(R.id.buttonMultiply).setOnClickListener(this)
        findViewById<Button>(R.id.buttonDivide).setOnClickListener(this)

        findViewById<Button>(R.id.buttonCE).setOnClickListener(this)
        findViewById<Button>(R.id.buttonC).setOnClickListener(this)
        findViewById<Button>(R.id.buttonBS).setOnClickListener(this)
        findViewById<Button>(R.id.buttonEqual).setOnClickListener(this)
        findViewById<Button>(R.id.buttonPlusMinus).setOnClickListener(this)
        findViewById<Button>(R.id.buttonDot).setOnClickListener(this)
    }

    var curExpression: String = ""

    override fun onClick(p0: View?) {
        val id = p0?.id
        when(id){
            R.id.button0 -> {
                addDigit(0)
                updateExpression("0")
            }
            R.id.button1 -> {
                addDigit(1)
                updateExpression("1")
            }
            R.id.button2 -> {
                addDigit(2)
                updateExpression("2")
            }
            R.id.button3 -> {
                addDigit(3)
                updateExpression("3")
            }
            R.id.button4 -> {
                addDigit(4)
                updateExpression("4")
            }
            R.id.button5 -> {
                addDigit(5)
                updateExpression("5")
            }
            R.id.button6 -> {
                addDigit(6)
                updateExpression("6")
            }
            R.id.button7 -> {
                addDigit(7)
                updateExpression("7")
            }
            R.id.button8 -> {
                addDigit(8)
                updateExpression("8")
            }
            R.id.button9 -> {
                addDigit(9)
                updateExpression("9")
            }
            R.id.buttonAdd -> {
                op = 1
                state = 2
                updateExpression(" + ")
            }
            R.id.buttonSubtract -> {
                op = 2
                state = 2
                updateExpression(" - ")
            }
            R.id.buttonMultiply -> {
                op = 3
                state = 2
                updateExpression(" * ")
            }
            R.id.buttonDivide -> {
                op = 4
                state = 2
                updateExpression(" / ")
            }
            R.id.buttonEqual -> {
                var result: Double = 0.0
                when(op){
                    1 -> result = (op1 + op2).toDouble()
                    2 -> result = (op1 - op2).toDouble()
                    3 -> result = (op1 * op2).toDouble()
                    4 -> {
                        if(op2 != 0){
                            result = op1.toDouble() / op2.toDouble()
                        } else {
                            resCalc.text = "Error"
                            return
                        }
                    }
                }

                val formatRes = String.format("%.4f", result).trimEnd('0').trimEnd('.')

                resCalc.text = formatRes

                curExpression += " = $formatRes"
                findViewById<TextView>(R.id.viewCalc).text = curExpression

                state = 1
                op = 0
                op1 = 0
                op2 = 0
                curExpression = ""
            }
            R.id.buttonCE -> {
                op = 0
                op1 = 0
                op2 = 0
                state = 1
                resCalc.text = "0"
                curExpression = ""
                findViewById<TextView>(R.id.viewCalc).text = ""
            }
        }
    }

    fun updateExpression(s: String){
        curExpression += s
        findViewById<TextView>(R.id.viewCalc).text = curExpression
    }

    fun addDigit(c: Int){
        if(state == 1) {
            op1 = op1 * 10 + c
            resCalc.text = "$op1"
        }
        else if(state == 2){
            op2 = op2 * 10 + c
            resCalc.text = "$op2"
        }
    }
}