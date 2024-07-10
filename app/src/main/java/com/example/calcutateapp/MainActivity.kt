package com.example.calcutateapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    var showText : TextView? = null
    var lastNumaric : Boolean? = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.constr_layout)

        showText = findViewById(R.id.WrittenTv)

    }

    fun onDigit(view: View){

        val b = view as Button
        val buttonText = b.text.toString()
        showText?.append(buttonText)

        lastNumaric = true
    }
    fun clearData(view: View){
        showText?.text= ""
    }

    fun onEqual(view: View){
        if (lastNumaric == true){

            var TVvalue = showText?.text.toString()
            try {

                if (TVvalue.contains("-")){
                    var splitTV = TVvalue.split("-")

                    var one = splitTV[0]
                    var two = splitTV[1]

                    showText?.text = (one.toDouble() - two.toDouble()).toString()
                }else if (TVvalue.contains("+")){

                    var splitTV = TVvalue.split("+")

                    var one = splitTV[0]
                    var two = splitTV[1]

                    showText?.text = (one.toDouble() + two.toDouble()).toString()

                    }else if (TVvalue.contains("/")){

                    var splitTV = TVvalue.split("/")

                    var one = splitTV[0]
                    var two = splitTV[1]

                    showText?.text = (one.toDouble() / two.toDouble()).toString()


                    }else if(TVvalue.contains("*")){

                        var splitTv = TVvalue.split("*")
                    var one = splitTv[0]
                    var two = splitTv[1]

                    showText?.text = (one.toDouble()*two.toDouble()).toString()

                    }

            }catch (e: ArithmeticException){
                e.printStackTrace()
            }

        }
    }
    fun onOperater(view: View){
        showText?.text?.let {

            if (lastNumaric == true && !isOperatedAdded(it.toString())){
                showText?.append((view as Button).text)
                lastNumaric = false
            }
        }
    }

    fun isOperatedAdded(value :String):Boolean{
        return if (value.startsWith("-")){
            false
        }else{
            value.contains("/") || value.contains("*") || value.contains("-") || value.contains("+")
        }
    }
}