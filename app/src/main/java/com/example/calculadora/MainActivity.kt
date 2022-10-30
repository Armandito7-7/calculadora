package com.example.calculadora

import android.app.AlertDialog
import android.content.Context
import android.icu.text.UnicodeSet.EMPTY
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    //0->nada, 1->suma, 2->resta, 3->multi, 4->division
    var acumulador: String = "" //variable que se almacena la cifra de cada operacion
    var oper: Int = 0 // variable que define la operacion que se va a realizar
    var numero1: Double = 0.0 // el primer numero que se digita
    lateinit var tv_num1: TextView //el primer 
    lateinit var tv_num2: TextView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_num1 = findViewById(R.id.tv_num1)
        tv_num2 = findViewById(R.id.tv_num2)
        val borrarBoton: Button = findViewById(R.id.borrarBoton)
        val igualBoton: Button = findViewById(R.id.igualBoton)
        
        val addContactDialog = AlertDialog.Builder(this)
            .setTitle("Error 2")
            .setMessage("No se puede mostrar el resultado ya que no ha reliazado ninguna operacion")
            .setIcon(R.drawable.tachita_foreground)
            .setPositiveButton("Yes"){ _, _ ->
                Toast.makeText(this,"ingrese la operacion a realizar", Toast.LENGTH_SHORT).show()
            }.create()

        igualBoton.setOnClickListener{
            if(acumulador==""){
                addContactDialog.show()
            }else {
                var numero2: Double = tv_num2.text.toString().toDouble()
                var resp: Double = 0.0


                numero1 = acumulador.toDouble()
                resp = identificaroperacion(numero2)
                acumulador = ""
                tv_num1.setText(resp.toString())
                tv_num2.setText("")
            }
        }

        borrarBoton.setOnClickListener{

            tv_num1.setText("")
            tv_num2.setText("")
            numero1 = 0.0
            oper =  0
            acumulador = ""
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
        //mensaje flotante
        val addContactDialog = AlertDialog.Builder(this)
            .setTitle("Error 1")
            .setMessage("No se puede realizar esa operación,no ingresó el numero antes de la operación")
            .setIcon(R.drawable.tachita_foreground)
            .setPositiveButton("OK"){ _, _ ->
                Toast.makeText(this,"ingresa un numero e intente nuevamente", Toast.LENGTH_SHORT).show()
            }.create()
        //numero1 = tv_num2.text.toString().toDouble()
        var num1_text: String = tv_num1.text.toString()
        var vacio: String = tv_num2.text.toString()
        var resp: Double = 0.0
        var numero2: Double
        //tv_num2.setText("")

        if (vacio == ""){
             numero2 = 0.0
        }else{
            numero2= tv_num2.text.toString().toDouble()
        }

        when(view.id) {
            R.id.sumaBoton -> {
                if (acumulador==""){
                    addContactDialog.show()
                }else {
                    tv_num1.setText(num1_text + "+")
                    numero1 = acumulador.toDouble()
                    resp = identificaroperacion(numero2)
                    acumulador = ""
                    tv_num2.setText(resp.toString())
                    oper = 1
                    //
                    Log.i("variable resp:", " " + resp)
                    Log.i("variable numero 2:", " " + numero2)
                }
            }
            R.id.restaBoton -> {
                if (acumulador==""){
                    addContactDialog.show()
                }else {
                    tv_num1.setText(num1_text + "-")
                    numero1 = acumulador.toString().toDouble()
                    resp = identificaroperacion(numero2)
                    acumulador = ""
                    tv_num2.setText(resp.toString())
                    oper = 2
                    Log.i("variable resp:", " " + resp)
                    Log.i("variable numero 2:", " " + numero2)
                }
            }
            R.id.multiBoton -> {
                if (acumulador==""){
                    addContactDialog.show()
                }else {
                    tv_num1.setText(num1_text + "*")
                    numero1 = acumulador.toString().toDouble()
                    resp = identificaroperacion(numero2)
                    acumulador = ""
                    tv_num2.setText(resp.toString())
                    oper = 3
                }
            }
            R.id.diviBoton -> {
                if (acumulador==""){
                    addContactDialog.show()
                }else {
                    tv_num1.setText(num1_text + "/")
                    numero1 = acumulador.toString().toDouble()
                    resp = identificaroperacion(numero2)
                    acumulador = ""
                    tv_num2.setText(resp.toString())
                    oper = 4
                }
            }
        }
    }

    fun identificaroperacion(numero2: Double): Double{
        var resp: Double = 0.0
        when(oper){
            0 -> resp = numero1
            1 -> resp = numero1 + numero2
            2 -> resp = numero2 - numero1
            3 -> resp = numero1 * numero2
            4 -> resp = numero2 / numero1
        }
       return resp
    }

}



