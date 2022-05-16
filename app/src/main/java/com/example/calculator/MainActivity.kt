package com.example.calculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.lang.Exception
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        btn_clear.setOnClickListener {
            input.text = ""
            output.text = ""
        }
        btn_bracket_left.setOnClickListener {
            input.text = addToInputText("(")
        }
        btn_bracket_right.setOnClickListener {
            input.text = addToInputText(")")
        }
        btn_0.setOnClickListener {
            input.text = addToInputText("0")
        }
        btn_1.setOnClickListener {
            input.text = addToInputText("1")
        }
        btn_2.setOnClickListener {
            input.text = addToInputText("2")
        }
        btn_3.setOnClickListener {
            input.text = addToInputText("3")
        }
        btn_4.setOnClickListener {
            input.text = addToInputText("4")
        }
        btn_5.setOnClickListener {
            input.text = addToInputText("5")
        }
        btn_6.setOnClickListener {
            input.text = addToInputText("6")
        }
        btn_7.setOnClickListener {
            input.text = addToInputText("7")
        }
        btn_8.setOnClickListener {
            input.text = addToInputText("8")
        }
        btn_9.setOnClickListener {
            input.text = addToInputText("9")
        }
        btn_dot.setOnClickListener {
            input.text = addToInputText(".")
        }
        btn_division.setOnClickListener {
            input.text = addToInputText("÷")
        }
        btn_multiply.setOnClickListener {
            input.text = addToInputText("×")
        }
        btn_subtraction.setOnClickListener {
            input.text = addToInputText("-")
        }
        btn_additon.setOnClickListener {
            input.text = addToInputText("+")
        }
        btn_equals.setOnClickListener {
            output.setVisibility(View.VISIBLE)
            showResult()

        }
    }

    private fun showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()){
                output.text = "Error"
                output.setTextColor(ContextCompat.getColor(this, R.color.red))
            }else{
                output.text = DecimalFormat("0.######").format(result).toString()
                output.setTextColor(ContextCompat.getColor(this, R.color.red))
            }
        }catch (e : Exception){
            output.text = "Error"
            output.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }
    private fun getInputExpression():String {
        var expression = input.text.replace(Regex("÷"),"/")
        expression = expression.replace(Regex("×"),"*")
        return expression
    }

    private fun addToInputText(buttonValue: String):String{
        return "${input.text}$buttonValue"
    }

}