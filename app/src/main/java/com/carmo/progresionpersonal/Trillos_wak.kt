package com.carmo.progresionpersonal

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.ActivityInfo
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.carmo.progresionpersonal.R

class Trillos_wak : AppCompatActivity() {
    fun libreta(){
        startActivity(Intent(this,libreta::class.java))
    }
    override fun onCreate(savedInstanceState: Bundle?) {


        val Siempre = getSharedPreferences("Siempre", Context.MODE_PRIVATE)
        val Actual = getSharedPreferences(Siempre.getString("NombreActWak", "No existe").toString(),
            Context.MODE_PRIVATE)
        val ActualEditor : SharedPreferences.Editor = Actual.edit()
        var estadobasu : Int
        var estadousure: Int
        var estadoawakal: Int
        var estadosenuk: Int
        var estadodulekalom: Int

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trillos_wak)

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)


        val checkbox1 = findViewById<CheckBox>(R.id.checkBox)
        val checkbox2 = findViewById<CheckBox>(R.id.checkBox2)
        val checkbox3 = findViewById<CheckBox>(R.id.checkBox3)

        val checkbox4 = findViewById<CheckBox>(R.id.checkBox4)
        val checkbox5 = findViewById<CheckBox>(R.id.checkBox5)
        val checkbox6 = findViewById<CheckBox>(R.id.checkBox6)

        val checkbox7 = findViewById<CheckBox>(R.id.checkBox7)
        val checkbox8 = findViewById<CheckBox>(R.id.checkBox8)
        val checkbox9 = findViewById<CheckBox>(R.id.checkBox9)

        val checkbox10 = findViewById<CheckBox>(R.id.checkBox10)
        val checkbox11 = findViewById<CheckBox>(R.id.checkBox11)
        val checkbox12 = findViewById<CheckBox>(R.id.checkBox12)

        val checkbox13 = findViewById<CheckBox>(R.id.checkBox13)
        val checkbox14 = findViewById<CheckBox>(R.id.checkBox14)
        val checkbox15 = findViewById<CheckBox>(R.id.checkBox15)

        val checkboxs = mutableListOf(checkbox1,checkbox2,checkbox3,checkbox4,checkbox5,checkbox6,checkbox7,checkbox8,checkbox9, checkbox10, checkbox11,checkbox12,checkbox13,checkbox14,checkbox15)
        val checkboxCol1 = mutableListOf(checkbox1,checkbox2,checkbox3)
        val checkboxCol2 = mutableListOf(checkbox4,checkbox5,checkbox6)
        val checkboxCol3 = mutableListOf(checkbox7,checkbox8,checkbox9)
        val checkboxCol4 = mutableListOf(checkbox10,checkbox11,checkbox12)
        val checkboxCol5 = mutableListOf(checkbox13,checkbox14,checkbox15)

        findViewById<ImageButton>(R.id.imageButton4).setOnClickListener(){
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            val inflanter: LayoutInflater = getLayoutInflater()
            val view: View = inflanter.inflate(R.layout.dialog_basu, null)
            builder.setView(view)
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
        findViewById<ImageView>(R.id.imageView8).setOnClickListener(){
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            val inflanter: LayoutInflater = getLayoutInflater()
            val view: View = inflanter.inflate(R.layout.dialog_usure, null)
            builder.setView(view)
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
        findViewById<ImageView>(R.id.imageView10).setOnClickListener(){
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            val inflanter: LayoutInflater = getLayoutInflater()
            val view: View = inflanter.inflate(R.layout.dialog_awakal, null)
            builder.setView(view)
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
        findViewById<ImageView>(R.id.imageView12).setOnClickListener(){
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            val inflanter: LayoutInflater = getLayoutInflater()
            val view: View = inflanter.inflate(R.layout.dialog_senuk, null)
            builder.setView(view)
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
        findViewById<ImageView>(R.id.imageView13).setOnClickListener(){
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            val inflanter: LayoutInflater = getLayoutInflater()
            val view: View = inflanter.inflate(R.layout.dialog_duleka, null)
            builder.setView(view)
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }

        for(i in 1..15){

            checkboxs.get(i-1).isChecked = Actual.getBoolean("checkboxTrillos"+i, false)

        }

        fun checkear(estado : Int, col : MutableList<CheckBox>){
            if(estado == 0){
                col.get(0).isChecked = true
                col.get(1).isChecked = false
                col.get(2).isChecked = false
            }
            else{
                if(estado == 1){
                    col.get(0).isChecked = false
                    col.get(1).isChecked = true
                    col.get(2).isChecked = false
                }else {
                    col.get(0).isChecked = false
                    col.get(1).isChecked = false
                    col.get(2).isChecked = true
                }


            }
        }
        checkbox1.setOnClickListener(){
            estadobasu = 0
            checkear(estadobasu, checkboxCol1)

            ActualEditor.putString("estadobasu", estadobasu.toString()).commit()
        }
        checkbox2.setOnClickListener(){
            estadobasu = 1
            checkear(estadobasu, checkboxCol1)
            ActualEditor.putString("estadobasu", estadobasu.toString()).commit()
        }
        checkbox3.setOnClickListener(){
            estadobasu = 2
            checkear(estadobasu, checkboxCol1)
            ActualEditor.putString("estadobasu", estadobasu.toString()).commit()
        }
        checkbox4.setOnClickListener(){
            estadousure = 0
            checkear(estadousure, checkboxCol2)
            ActualEditor.putString("estadousure", estadousure.toString()).commit()
        }
        checkbox5.setOnClickListener(){
            estadousure = 1
            checkear(estadousure, checkboxCol2)
            ActualEditor.putString("estadousure", estadousure.toString()).commit()
        }
        checkbox6.setOnClickListener(){
            estadousure = 2
            checkear(estadousure, checkboxCol2)
            ActualEditor.putString("estadousure", estadousure.toString()).commit()
        }
        checkbox7.setOnClickListener(){
            estadoawakal = 0
            checkear(estadoawakal, checkboxCol3)
            ActualEditor.putString("estadoawakal", estadoawakal.toString()).commit()
        }
        checkbox8.setOnClickListener(){
            estadoawakal = 1
            checkear(estadoawakal, checkboxCol3)
            ActualEditor.putString("estadoawakal", estadoawakal.toString()).commit()
        }
        checkbox9.setOnClickListener(){
            estadoawakal = 2
            checkear(estadoawakal, checkboxCol3)
            ActualEditor.putString("estadoawakal", estadoawakal.toString()).commit()
        }
        checkbox10.setOnClickListener() {
            estadosenuk = 0
            checkear(estadosenuk, checkboxCol4)
            ActualEditor.putString("estadosenuk", estadosenuk.toString()).commit()
        }
        checkbox11.setOnClickListener() {
            estadosenuk = 1
            checkear(estadosenuk, checkboxCol4)
            ActualEditor.putString("estadosenuk", estadosenuk.toString()).commit()
        }
        checkbox12.setOnClickListener() {
            estadosenuk = 2
            checkear(estadosenuk, checkboxCol4)
            ActualEditor.putString("estadosenuk", estadosenuk.toString()).commit()
        }
        checkbox13.setOnClickListener() {
            estadodulekalom = 0
            checkear(estadodulekalom, checkboxCol5)
            ActualEditor.putString("estadodulekalom", estadodulekalom.toString()).commit()
        }
        checkbox14.setOnClickListener() {
            estadodulekalom = 1
            checkear(estadodulekalom, checkboxCol5)
            ActualEditor.putString("estadodulekalom", estadodulekalom.toString()).commit()
        }
        checkbox15.setOnClickListener() {
            estadodulekalom = 2
            checkear(estadodulekalom, checkboxCol5)
            ActualEditor.putString("estadodulekalom", estadodulekalom.toString()).commit()
        }

        val boton5 = findViewById<ImageButton>(R.id.imageButton5)
        boton5.setOnClickListener(){
            ActualEditor.putString("libretaActWak","basu").commit()
            libreta()
        }
        val boton6 = findViewById<ImageButton>(R.id.imageButton6)
        boton6.setOnClickListener(){
            ActualEditor.putString("libretaActWak","usure").commit()
            libreta()

        }
        val boton7 = findViewById<ImageButton>(R.id.imageButton7)
        boton7.setOnClickListener(){
            ActualEditor.putString("libretaActWak","awakal").commit()
            libreta()

        }
        val boton8 = findViewById<ImageButton>(R.id.imageButton8)
        boton8.setOnClickListener() {
            ActualEditor.putString("libretaActWak", "senuk").commit()
            libreta()

        }
        val boton9 = findViewById<ImageButton>(R.id.imageButton9)
        boton9.setOnClickListener() {
            ActualEditor.putString("libretaActWak", "dulekalom").commit()
            libreta()

        }

    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        val Siempre = getSharedPreferences("Siempre", Context.MODE_PRIVATE)
        val Actual = getSharedPreferences(Siempre.getString("NombreActWak", "No existe").toString(),
            Context.MODE_PRIVATE)
        val ActualEditor : SharedPreferences.Editor = Actual.edit()



        val checkbox1 = findViewById<CheckBox>(R.id.checkBox)
        val checkbox2 = findViewById<CheckBox>(R.id.checkBox2)
        val checkbox3 = findViewById<CheckBox>(R.id.checkBox3)

        val checkbox4 = findViewById<CheckBox>(R.id.checkBox4)
        val checkbox5 = findViewById<CheckBox>(R.id.checkBox5)
        val checkbox6 = findViewById<CheckBox>(R.id.checkBox6)

        val checkbox7 = findViewById<CheckBox>(R.id.checkBox7)
        val checkbox8 = findViewById<CheckBox>(R.id.checkBox8)
        val checkbox9 = findViewById<CheckBox>(R.id.checkBox9)

        val checkbox10 = findViewById<CheckBox>(R.id.checkBox10)
        val checkbox11 = findViewById<CheckBox>(R.id.checkBox11)
        val checkbox12 = findViewById<CheckBox>(R.id.checkBox12)

        val checkbox13 = findViewById<CheckBox>(R.id.checkBox13)
        val checkbox14 = findViewById<CheckBox>(R.id.checkBox14)
        val checkbox15 = findViewById<CheckBox>(R.id.checkBox15)

        val checkboxs = mutableListOf(checkbox1,checkbox2,checkbox3,checkbox4,checkbox5,checkbox6,checkbox7,checkbox8,checkbox9, checkbox10, checkbox11,checkbox12,checkbox13,checkbox14,checkbox15)



        if(keyCode == KeyEvent.KEYCODE_BACK){
            startActivity(Intent(this, InicioWak::class.java))
            for(i in 1..15){



                ActualEditor.putBoolean("checkboxTrillos"+i, checkboxs.get(i-1).isChecked).commit()



            }
            finish()
        }
        return super.onKeyDown(keyCode, event)
    }
}