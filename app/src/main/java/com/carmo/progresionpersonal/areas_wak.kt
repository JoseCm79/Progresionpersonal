package com.carmo.progresionpersonal

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog

class areas_wak : AppCompatActivity() {
    fun libreta(){
        startActivity(Intent(this,libreta::class.java))
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        val Siempre = getSharedPreferences("Siempre", Context.MODE_PRIVATE)
        val Actual = getSharedPreferences(Siempre.getString("NombreActWak", "No existe").toString(),
            Context.MODE_PRIVATE)
        val ActualEditor : SharedPreferences.Editor = Actual.edit()
        var estadodeporte : Int
        var estadotecno: Int
        var estadoservi: Int
        var estadokabata: Int
        var estadoarte: Int

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_areas_wak)


        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        findViewById<ImageButton>(R.id.imageButton16).setOnClickListener(){
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            val inflanter: LayoutInflater = getLayoutInflater()
            val view: View = inflanter.inflate(R.layout.dialog_kabata, null)
            builder.setView(view)
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
        findViewById<ImageView>(R.id.imageView20).setOnClickListener(){
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            val inflanter: LayoutInflater = getLayoutInflater()
            val view: View = inflanter.inflate(R.layout.dialog_servicio, null)
            builder.setView(view)
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
        findViewById<ImageView>(R.id.imageView18).setOnClickListener(){
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            val inflanter: LayoutInflater = getLayoutInflater()
            val view: View = inflanter.inflate(R.layout.dialog_tecno, null)
            builder.setView(view)
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
        findViewById<ImageView>(R.id.imageView19).setOnClickListener(){
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            val inflanter: LayoutInflater = getLayoutInflater()
            val view: View = inflanter.inflate(R.layout.dialog_arte, null)
            builder.setView(view)
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
        findViewById<ImageView>(R.id.imageView21).setOnClickListener(){
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            val inflanter: LayoutInflater = getLayoutInflater()
            val view: View = inflanter.inflate(R.layout.dialog_deporte, null)
            builder.setView(view)
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }



        val checkbox1 = findViewById<CheckBox>(R.id.checkBox34)
        val checkbox2 = findViewById<CheckBox>(R.id.checkBox36)
        val checkbox3 = findViewById<CheckBox>(R.id.checkBox37)

        val checkbox4 = findViewById<CheckBox>(R.id.checkBox40)
        val checkbox5 = findViewById<CheckBox>(R.id.checkBox42)
        val checkbox6 = findViewById<CheckBox>(R.id.checkBox31)

        val checkbox7 = findViewById<CheckBox>(R.id.checkBox32)
        val checkbox8 = findViewById<CheckBox>(R.id.checkBox38)
        val checkbox9 = findViewById<CheckBox>(R.id.checkBox39)

        val checkbox10 = findViewById<CheckBox>(R.id.checkBox41)
        val checkbox11 = findViewById<CheckBox>(R.id.checkBox33)
        val checkbox12 = findViewById<CheckBox>(R.id.checkBox35)

        val checkbox13 = findViewById<CheckBox>(R.id.checkBox43)
        val checkbox14 = findViewById<CheckBox>(R.id.checkBox44)
        val checkbox15 = findViewById<CheckBox>(R.id.checkBox45)

        val checkboxs = mutableListOf(checkbox1,checkbox2,checkbox3,checkbox4,checkbox5,checkbox6,checkbox7,checkbox8,checkbox9, checkbox10, checkbox11,checkbox12,checkbox13,checkbox14,checkbox15)
        val checkboxCol1 = mutableListOf(checkbox1,checkbox2,checkbox3)
        val checkboxCol2 = mutableListOf(checkbox4,checkbox5,checkbox6)
        val checkboxCol3 = mutableListOf(checkbox7,checkbox8,checkbox9)
        val checkboxCol4 = mutableListOf(checkbox10,checkbox11,checkbox12)
        val checkboxCol5 = mutableListOf(checkbox13,checkbox14,checkbox15)

        for(i in 1..15){

            checkboxs.get(i-1).isChecked = Actual.getBoolean("checkboxAreas"+i, false)

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
            estadokabata = 0
            checkear(estadokabata, checkboxCol1)

            ActualEditor.putString("estadokabata", estadokabata.toString()).commit()
        }
        checkbox2.setOnClickListener(){
            estadokabata = 1
            checkear(estadokabata, checkboxCol1)
            ActualEditor.putString("estadokabata", estadokabata.toString()).commit()
        }
        checkbox3.setOnClickListener(){
            estadokabata = 2
            checkear(estadokabata, checkboxCol1)
            ActualEditor.putString("estadokabata", estadokabata.toString()).commit()
        }
        checkbox4.setOnClickListener(){
            estadoservi = 0
            checkear(estadoservi, checkboxCol2)
            ActualEditor.putString("estadoservi", estadoservi.toString()).commit()
        }
        checkbox5.setOnClickListener(){
            estadoservi = 1
            checkear(estadoservi, checkboxCol2)
            ActualEditor.putString("estadoservi", estadoservi.toString()).commit()
        }
        checkbox6.setOnClickListener(){
            estadoservi = 2
            checkear(estadoservi, checkboxCol2)
            ActualEditor.putString("estadoservi", estadoservi.toString()).commit()
        }
        checkbox7.setOnClickListener(){
            estadotecno = 0
            checkear(estadotecno, checkboxCol3)
            ActualEditor.putString("estadotecno", estadotecno.toString()).commit()
        }
        checkbox8.setOnClickListener(){
            estadotecno = 1
            checkear(estadotecno, checkboxCol3)
            ActualEditor.putString("estadotecno", estadotecno.toString()).commit()
        }
        checkbox9.setOnClickListener(){
            estadotecno = 2
            checkear(estadotecno, checkboxCol3)
            ActualEditor.putString("estadotecno", estadotecno.toString()).commit()
        }
        checkbox10.setOnClickListener() {
            estadoarte = 0
            checkear(estadoarte, checkboxCol4)
            ActualEditor.putString("estadoarte", estadoarte.toString()).commit()
        }
        checkbox11.setOnClickListener() {
            estadoarte = 1
            checkear(estadoarte, checkboxCol4)
            ActualEditor.putString("estadoarte", estadoarte.toString()).commit()
        }
        checkbox12.setOnClickListener() {
            estadoarte = 2
            checkear(estadoarte, checkboxCol4)
            ActualEditor.putString("estadoarte", estadoarte.toString()).commit()
        }
        checkbox13.setOnClickListener() {
            estadodeporte = 0
            checkear(estadodeporte, checkboxCol5)
            ActualEditor.putString("estadodeporte", estadodeporte.toString()).commit()
        }
        checkbox14.setOnClickListener() {
            estadodeporte = 1
            checkear(estadodeporte, checkboxCol5)
            ActualEditor.putString("estadodeporte", estadodeporte.toString()).commit()
        }
        checkbox15.setOnClickListener() {
            estadodeporte = 2
            checkear(estadodeporte, checkboxCol5)
            ActualEditor.putString("estadodeporte", estadodeporte.toString()).commit()
        }

        val boton5 = findViewById<ImageButton>(R.id.imageButton20)
        boton5.setOnClickListener(){
            ActualEditor.putString("libretaActWak","aire").commit()
            libreta()
        }
        val boton6 = findViewById<ImageButton>(R.id.imageButton19)
        boton6.setOnClickListener(){
            ActualEditor.putString("libretaActWak","servicio").commit()
            libreta()

        }
        val boton7 = findViewById<ImageButton>(R.id.imageButton21)
        boton7.setOnClickListener(){
            ActualEditor.putString("libretaActWak","tecno").commit()
            libreta()

        }
        val boton8 = findViewById<ImageButton>(R.id.imageButton17)
        boton8.setOnClickListener() {
            ActualEditor.putString("libretaActWak", "arte").commit()
            libreta()

        }
        val boton9 = findViewById<ImageButton>(R.id.imageButton18)
        boton9.setOnClickListener() {
            ActualEditor.putString("libretaActWak", "deporte").commit()
            libreta()

        }


    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        val Siempre = getSharedPreferences("Siempre", Context.MODE_PRIVATE)
        val Actual = getSharedPreferences(Siempre.getString("NombreActWak", "No existe").toString(),
            Context.MODE_PRIVATE)
        val ActualEditor : SharedPreferences.Editor = Actual.edit()



        val checkbox1 = findViewById<CheckBox>(R.id.checkBox34)
        val checkbox2 = findViewById<CheckBox>(R.id.checkBox36)
        val checkbox3 = findViewById<CheckBox>(R.id.checkBox37)

        val checkbox4 = findViewById<CheckBox>(R.id.checkBox40)
        val checkbox5 = findViewById<CheckBox>(R.id.checkBox42)
        val checkbox6 = findViewById<CheckBox>(R.id.checkBox31)

        val checkbox7 = findViewById<CheckBox>(R.id.checkBox32)
        val checkbox8 = findViewById<CheckBox>(R.id.checkBox38)
        val checkbox9 = findViewById<CheckBox>(R.id.checkBox39)

        val checkbox10 = findViewById<CheckBox>(R.id.checkBox41)
        val checkbox11 = findViewById<CheckBox>(R.id.checkBox33)
        val checkbox12 = findViewById<CheckBox>(R.id.checkBox35)

        val checkbox13 = findViewById<CheckBox>(R.id.checkBox43)
        val checkbox14 = findViewById<CheckBox>(R.id.checkBox44)
        val checkbox15 = findViewById<CheckBox>(R.id.checkBox45)

        val checkboxs = mutableListOf(checkbox1,checkbox2,checkbox3,checkbox4,checkbox5,checkbox6,checkbox7,checkbox8,checkbox9, checkbox10, checkbox11,checkbox12,checkbox13,checkbox14,checkbox15)



        if(keyCode == KeyEvent.KEYCODE_BACK){
            startActivity(Intent(this, InicioWak::class.java))
            for(i in 1..15){

                ActualEditor.putBoolean("checkboxAreas"+i, checkboxs.get(i-1).isChecked).commit()

            }
            finish()
        }
        return super.onKeyDown(keyCode, event)
    }

}