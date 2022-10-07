package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //0->nada, 1->suma, 2->resta, 3->multi, 4->division
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
        var num2: String = tv_num2.text.toString()

        when(view.id){
            R.id.ceroBoton -> tv_num2.setText(num2 + "0")
            R.id.unoBoton -> tv_num2.setText(num2 + "1")
            R.id.dosBoton -> tv_num2.setText(num2 + "2")
            R.id.tresBoton -> tv_num2.setText(num2 + "3")
            R.id.cuatroBoton -> tv_num2.setText(num2 + "4")
            R.id.cincoBoton -> tv_num2.setText(num2 + "5")
            R.id.seisBoton -> tv_num2.setText(num2 + "6")
            R.id.sieteBoton -> tv_num2.setText(num2 + "7")
            R.id.ochoBoton -> tv_num2.setText(num2 + "8")
            R.id.nueveBoton -> tv_num2.setText(num2 + "9")
            R.id.puntoBoton -> tv_num2.setText(num2 + ".")

        }

    }

    fun clicOperacion(view: View){
        numero1 = tv_num2.text.toString().toDouble()
        var num2_text: String = tv_num2.text.toString()
        tv_num2.setText("")

        when(view.id){
            R.id.sumaBoton ->{
                tv_num1.setText(num2_text + "+")
                oper = 1
            }
            R.id.restaBoton ->{
                tv_num1.setText(num2_text + "-")
                oper = 2
            }
            R.id.multiBoton ->{
                tv_num1.setText(num2_text + "*")
                oper = 3
            }
            R.id.diviBoton ->{
                tv_num1.setText(num2_text + "/")
                oper = 4
            }
        }
    }
}