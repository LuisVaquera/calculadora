package com.example.calculadora

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    private var num1: Double = 0.0
    private var num2: Double = 0.0
    private var operacion: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultadoTextView.text="0"
        operacion= NO_OPERACION

        boton1.setOnClickListener{ numeroPres("1")}
        boton2.setOnClickListener{ numeroPres("2")}
        boton3.setOnClickListener{ numeroPres("3")}
        boton4.setOnClickListener{ numeroPres("4")}
        boton5.setOnClickListener{ numeroPres("5")}
        boton6.setOnClickListener{ numeroPres("6")}
        boton7.setOnClickListener{ numeroPres("7")}
        boton8.setOnClickListener{ numeroPres("8")}
        boton9.setOnClickListener{ numeroPres("9")}
        boton0.setOnClickListener{ numeroPres("0")}
        puntoBoton.setOnClickListener{ numeroPres(".")}


        sumaBoton.setOnClickListener{ opPresionada(SUMA)}
        restaBoton.setOnClickListener{ opPresionada(RESTA)}
        multBoton.setOnClickListener{ opPresionada(MULTIPLICACION)}
        divBoton.setOnClickListener{ opPresionada(DIVICION)}
        potenciaXBoton.setOnClickListener{
            var resultado = num1.pow(2)
            resultadoTextView.text = resultado.toString()
        }
        potenciaYBoton.setOnClickListener{ opPresionada(POTENCIAY)}


        delBoton.setOnClickListener{
            num1=0.0
            num2=0.0
            resultadoTextView.text="0"
        }
        acBoton.setOnClickListener{
            num1=0.0
            num2=0.0
            resultadoTextView.text="0"
            operacion= NO_OPERACION
        }

        igualBoton.setOnClickListener{
            var resultado = when(operacion){
                SUMA-> num1+num2
                RESTA-> num1-num2
                MULTIPLICACION -> num1*num2
                DIVICION -> num1/num2
                POTENCIAY -> num1.pow(num2)
                else->0
            }
            num1 = resultado as Double
            resultadoTextView.text = if("$resultado".endsWith(".0")){
                "$resultado".replace(".0","")
            }else{
                "%.2f".format(resultado)
            }
        }
    }
    private fun numeroPres(num: String){
        if(resultadoTextView.text == "0" && num != "."){
            resultadoTextView.text="$num"
        }else{
            resultadoTextView.text="${resultadoTextView.text}$num"
        }

        if(operacion == NO_OPERACION){
            num1 = resultadoTextView.text.toString().toDouble()
        }else{
            num2 = resultadoTextView.text.toString().toDouble()
        }
    }

    private fun opPresionada(operacion: Int){
        this.operacion = operacion
        num1=resultadoTextView.text.toString().toDouble()
        resultadoTextView.text = "0"
    }

    companion object{
        const val SUMA=1
        const val RESTA=2
        const val MULTIPLICACION=3
        const val DIVICION=4
        const val NO_OPERACION=0
        const val POTENCIAX=5
        const val POTENCIAY=6
    }
}