package com.carmo.progresionpersonal

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView

class metas_wak : AppCompatActivity() {
    fun libreta(){
        startActivity(Intent(this,libreta::class.java))

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_metas_wak)

        val Siempre = getSharedPreferences("Siempre", Context.MODE_PRIVATE)
        val Actual = getSharedPreferences(Siempre.getString("NombreActWak", "No existe").toString(),
            Context.MODE_PRIVATE)
        val ActualEditor : SharedPreferences.Editor = Actual.edit()


        findViewById<EditText>(R.id.libretas).setText(Actual.getString("personales","Vacío").toString())
        findViewById<EditText>(R.id.libretas2).setText(Actual.getString("equipo","Vacío").toString())
        findViewById<EditText>(R.id.libretas4).setText(Actual.getString("wak","Vacío").toString())
        findViewById<EditText>(R.id.libretas).setPaintFlags(findViewById<EditText>(R.id.libretas).getPaintFlags() or Paint.UNDERLINE_TEXT_FLAG)
        findViewById<EditText>(R.id.libretas2).setPaintFlags(findViewById<EditText>(R.id.libretas2).getPaintFlags() or Paint.UNDERLINE_TEXT_FLAG)
        findViewById<EditText>(R.id.libretas4).setPaintFlags(findViewById<EditText>(R.id.libretas4).getPaintFlags() or Paint.UNDERLINE_TEXT_FLAG)

        val boton5 = findViewById<ImageButton>(R.id.imageButton10)
        boton5.setOnClickListener(){
            ActualEditor.putString("libretaActWak","personales").commit()
            libreta()
            finish()
        }
        val boton6 = findViewById<ImageButton>(R.id.imageButton14)
        boton6.setOnClickListener(){
            ActualEditor.putString("libretaActWak","equipo").commit()
            libreta()
            finish()
        }
        val boton7 = findViewById<ImageButton>(R.id.imageButton22)
        boton7.setOnClickListener(){
            ActualEditor.putString("libretaActWak","wak").commit()
            libreta()
            finish()
        }


    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            startActivity(Intent(this, InicioWak::class.java))
            finish()
        }
        return super.onKeyDown(keyCode, event)
    }
}