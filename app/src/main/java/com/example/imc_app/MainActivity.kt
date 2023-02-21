package com.example.imc_app

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners(){
        /*alturaEDT?.doAfterTextChanged { text ->
            //Toast.makeText(this, text.toString(), Toast.LENGTH_SHORT).show()
        }
        pesoEDT?.doOnTextChanged {text, _, _, _ ->
            //titleTXT.text = text
        }*/
        calcularBTN?.setOnClickListener{
            calcularIMC(pesoEDT.text.toString(), alturaEDT.text.toString())
        }
    }

    private fun calcularIMC(peso: String, altura: String){
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()
        if (peso != null && altura != null){
            val imc = peso / (altura * altura)
            titleTXT.text = "Seu IMC é \n%.2f".format(imc)

            when(imc) {
                in 0.0..18.5 -> {
                    imc1.setBackgroundColor(Color.GREEN)
                    classe1.setBackgroundColor(Color.GREEN)
                    imc1.setTextColor(Color.BLACK)
                    classe1.setTextColor(Color.BLACK)
                }
                in 18.6..24.9 -> {
                    imc2.setBackgroundColor(Color.GREEN)
                    classe2.setBackgroundColor(Color.GREEN)
                    imc2.setTextColor(Color.BLACK)
                    classe2.setTextColor(Color.BLACK)
                }
                in 25.0..29.9 -> {
                    imc3.setBackgroundColor(Color.GREEN)
                    classe3.setBackgroundColor(Color.GREEN)
                    imc3.setTextColor(Color.BLACK)
                    classe3.setTextColor(Color.BLACK)
                }
                in 30.0..34.9 -> {
                    imc4.setBackgroundColor(Color.GREEN)
                    classe4.setBackgroundColor(Color.GREEN)
                    imc4.setTextColor(Color.BLACK)
                    classe4.setTextColor(Color.BLACK)
                }
                in 35.0..39.9 -> {
                    imc5.setBackgroundColor(Color.GREEN)
                    classe5.setBackgroundColor(Color.GREEN)
                    imc5.setTextColor(Color.BLACK)
                    classe5.setTextColor(Color.BLACK)
                }
                else -> {
                    imc6.setBackgroundColor(Color.GREEN)
                    classe6.setBackgroundColor(Color.GREEN)
                    imc6.setTextColor(Color.BLACK)
                    classe6.setTextColor(Color.BLACK)
                }
            }
        }
    }
}