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
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class EtapasWak : AppCompatActivity() {
    fun libreta(){
        startActivity(Intent(this,libreta::class.java))
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        val Siempre = getSharedPreferences("Siempre", Context.MODE_PRIVATE)
        val Actual = getSharedPreferences(
            Siempre.getString("NombreActWak", "No existe").toString(),
            Context.MODE_PRIVATE
        )
        val ActualEditor: SharedPreferences.Editor = Actual.edit()
        var estadoDURA: Int
        var estadoDariri: Int
        var estadoTsuri: Int

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_etapas_wak)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        findViewById<ImageButton>(R.id.imageButton4).setOnClickListener(){
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            val inflanter: LayoutInflater = getLayoutInflater()
            val view: View = inflanter.inflate(R.layout.dialog_duradura, null)
            builder.setView(view)
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
        findViewById<ImageView>(R.id.imageView8).setOnClickListener(){
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            val inflanter: LayoutInflater = getLayoutInflater()
            val view: View = inflanter.inflate(R.layout.dialog_dariri, null)
            builder.setView(view)
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
        findViewById<ImageView>(R.id.imageView10).setOnClickListener(){
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            val inflanter: LayoutInflater = getLayoutInflater()
            val view: View = inflanter.inflate(R.layout.dialog_tsuri, null)
            builder.setView(view)
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }

        val checkbox1 = findViewById<CheckBox>(R.id.checkBox)
        val checkbox2 = findViewById<CheckBox>(R.id.checkBox2)
        val checkbox3 = findViewById<CheckBox>(R.id.checkBox3)
        
        val checkbox4 = findViewById<CheckBox>(R.id.checkBox4)
        val checkbox5 = findViewById<CheckBox>(R.id.checkBox5)
        val checkbox6 = findViewById<CheckBox>(R.id.checkBox6)
        
        val checkbox7 = findViewById<CheckBox>(R.id.checkBox7)
        val checkbox8 = findViewById<CheckBox>(R.id.checkBox8)
        val checkbox9 = findViewById<CheckBox>(R.id.checkBox9)

        val checkboxs = mutableListOf(checkbox1,checkbox2,checkbox3,checkbox4,checkbox5,checkbox6,checkbox7,checkbox8,checkbox9)
        val checkboxCol1 = mutableListOf(checkbox1,checkbox2,checkbox3)
        val checkboxCol2 = mutableListOf(checkbox4,checkbox5,checkbox6)
        val checkboxCol3 = mutableListOf(checkbox7,checkbox8,checkbox9)
        for(i in 1..9){

            checkboxs.get(i-1).isChecked = Actual.getBoolean("checkbox"+i, false)

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
            estadoDURA = 0
            checkear(estadoDURA, checkboxCol1)

            ActualEditor.putString("estadoDURA", estadoDURA.toString()).commit()
        }
        checkbox2.setOnClickListener(){
            estadoDURA = 1
            checkear(estadoDURA, checkboxCol1)

            ActualEditor.putString("estadoDURA", estadoDURA.toString()).commit()
        }
        checkbox3.setOnClickListener(){
            estadoDURA = 2
            checkear(estadoDURA, checkboxCol1)

            ActualEditor.putString("estadoDURA", estadoDURA.toString()).commit()
        }
        checkbox4.setOnClickListener(){
            estadoDariri = 0
            checkear(estadoDariri, checkboxCol2)
            ActualEditor.putString("estadoDariri", estadoDariri.toString()).commit()

        }
        checkbox5.setOnClickListener(){
            estadoDariri = 1
            checkear(estadoDariri, checkboxCol2)
            ActualEditor.putString("estadoDariri", estadoDariri.toString()).commit()

        }
        checkbox6.setOnClickListener(){
            estadoDariri = 2
            checkear(estadoDariri, checkboxCol2)
            ActualEditor.putString("estadoDariri", estadoDariri.toString()).commit()

        }
        checkbox7.setOnClickListener(){
            estadoTsuri = 0
            checkear(estadoTsuri, checkboxCol3)
            ActualEditor.putString("estadoTsuri", estadoTsuri.toString()).commit()
        }
        checkbox8.setOnClickListener(){
            estadoTsuri = 1
            checkear(estadoTsuri, checkboxCol3)
            ActualEditor.putString("estadoTsuri", estadoTsuri.toString()).commit()
        }
        checkbox9.setOnClickListener(){
            estadoTsuri = 2
            checkear(estadoTsuri, checkboxCol3)

            ActualEditor.putString("estadoTsuri", estadoTsuri.toString()).commit()
        }












        val boton5 = findViewById<ImageButton>(R.id.imageButton5)
        boton5.setOnClickListener(){
            ActualEditor.putString("libretaActWak","dura dura").commit()
            libreta()
        }
        val boton6 = findViewById<ImageButton>(R.id.imageButton6)
        boton6.setOnClickListener(){
            ActualEditor.putString("libretaActWak","dariri").commit()
            libreta()

        }
        val boton7 = findViewById<ImageButton>(R.id.imageButton7)
            boton7.setOnClickListener(){
                ActualEditor.putString("libretaActWak","tsuri").commit()
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



        val checkboxs = mutableListOf(checkbox1,checkbox2,checkbox3,checkbox4,checkbox5,checkbox6,checkbox7,checkbox8,checkbox9)


        startActivity(Intent(this, InicioWak::class.java))
        for(i in 1..9){

            ActualEditor.putBoolean("checkbox"+i, checkboxs.get(i-1).isChecked).commit()

        }
        finish()
        return super.onKeyDown(keyCode, event)
    }
}