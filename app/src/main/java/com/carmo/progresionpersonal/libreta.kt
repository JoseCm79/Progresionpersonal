package com.carmo.progresionpersonal

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.ActivityInfo
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.carmo.progresionpersonal.R

class libreta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_libreta)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        val Siempre = getSharedPreferences("Siempre", Context.MODE_PRIVATE)
        val Actual = getSharedPreferences(Siempre.getString("NombreActWak", "No existe").toString(),
            Context.MODE_PRIVATE)
        val ActualEditor : SharedPreferences.Editor = Actual.edit()
        val Etapa = Actual.getString("libretaActWak","No existe")
        val libreta = findViewById<EditText>(R.id.libreta)
        libreta.setText(Actual.getString( Etapa, "" ))
        findViewById<ImageButton>(R.id.guardar).setOnClickListener(){
            ActualEditor.putString(Etapa, libreta.getText().toString()).commit()
            Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show()
        }


        findViewById<EditText>(R.id.libreta).setPaintFlags(findViewById<EditText>(R.id.libreta).getPaintFlags() or Paint.UNDERLINE_TEXT_FLAG)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        val Siempre = getSharedPreferences("Siempre", Context.MODE_PRIVATE)
        val Actual = getSharedPreferences(Siempre.getString("NombreActWak", "No existe").toString(),
            Context.MODE_PRIVATE)
        val ActualEditor : SharedPreferences.Editor = Actual.edit()
        val Etapa = Actual.getString("libretaActWak","No existe")
        val libreta = findViewById<EditText>(R.id.libreta)
        if(keyCode == KeyEvent.KEYCODE_BACK){
            if (libreta.getText().toString() != Actual.getString( Etapa, "")){
                ActualEditor.putString(Etapa, libreta.getText().toString()).commit()
                Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show()
            }
            if(Etapa == "personales" || Etapa == "equipo" || Etapa == "wak"){
                startActivity(Intent(this, metas_wak::class.java))
            }
            finish()
        }
        
        return super.onKeyDown(keyCode, event)
    }
}