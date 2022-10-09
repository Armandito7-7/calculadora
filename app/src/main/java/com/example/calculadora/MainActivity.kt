package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //0->nada, 1->suma, 2->resta, 3->multi, 4->division
    // decicion == 1 -> no hay operacion      decision == 2 -> si hay operacion  || poder concatenar strings y comvertir el numero1 en un string
    var acumulador: String = ""
    var decision: Int = 0
    var oper: Int = 0
    var numero1: Double = 0.0
    lateinit var tv_num1: TextView
    lateinit var tv_num2: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_num1 = findViewById(R.id.tv_num1)
        tv_num2 = findViewById(R.id.tv_num2)
        val borrarBoton: Button = findViewById(R.id.borrarBoton)
        val igualBoton: Button = findViewById(R.id.igualBoton)

        igualBoton.setOnClickListener{
            var numero2: Double = tv_num2.text.toString().toDouble()
            var resp: Double = 0.0

            when(oper){
                1 -> resp = numero1 + numero2
                2 -> resp = numero1 - numero2
                3 -> resp = numero1 * numero2
                4 -> resp = numero1 / numero2
            }

            tv_num2.setText(resp.toString())
            tv_num1.setText("")
        }

        borrarBoton.setOnClickListener{
            tv_num1.setText("")
            tv_num2.setText("")
            numero1 = 0.0
            oper = 0
        }

    }

    fun presionarDigito(view: View){
        //val tv_num2: TextView = findViewById(R.id.tv_num2)
        var num1: String = tv_num1.text.toString()

        when(view.id){
            R.id.ceroBoton -> {
                tv_num1.setText(num1 + "0")
                acumulador = acumulador + "0"

            }
            R.id.unoBoton -> {
                tv_num1.setText(num1 + "1")
                acumulador = acumulador + "1"
            }
            R.id.dosBoton -> {
                tv_num1.setText(num1 + "2")
                acumulador = acumulador + "2"
            }
            R.id.tresBoton -> {
                tv_num1.setText(num1 + "3")
                acumulador = acumulador + "3"
            }
            R.id.cuatroBoton -> {
                tv_num1.setText(num1 + "4")
                acumulador = acumulador + "4"
            }
            R.id.cincoBoton -> {
                tv_num1.setText(num1 + "5")
                acumulador = acumulador + "5"
            }
            R.id.seisBoton -> {
                tv_num1.setText(num1 + "6")
                acumulador = acumulador + "6"
            }
            R.id.sieteBoton -> {
                tv_num1.setText(num1 + "7")
                acumulador = acumulador + "7"
            }
            R.id.ochoBoton -> {
                tv_num1.setText(num1 + "8")
                acumulador = acumulador + "8"
            }
            R.id.nueveBoton -> {
                tv_num1.setText(num1 + "9")
                acumulador = acumulador + "9"
            }
            R.id.puntoBoton -> {
                tv_num1.setText(num1 + ".")
                acumulador = acumulador + "."
            }

        }

    }

    fun clicOperacion(view: View){
        //numero1 = tv_num2.text.toString().toDouble()
        var num1_text: String = tv_num1.text.toString()
        //tv_num2.setText("")

        when(view.id) {
            R.id.sumaBoton -> {
                tv_num1.setText(num1_text + "+")
                numero1 = acumulador.toString().toDouble()
                acumulador = ""
                //oper = 1
            }
            R.id.restaBoton -> {
                tv_num1.setText(num1_text + "-")
                acumulador = ""
                //oper = 2
            }
            R.id.multiBoton -> {
                tv_num1.setText(num1_text + "*")
                acumulador = ""
                //oper = 3
            }
            R.id.diviBoton -> {
                tv_num1.setText(num1_text + "/")
                acumulador = ""
                //oper = 4
            }
        }
    }
}