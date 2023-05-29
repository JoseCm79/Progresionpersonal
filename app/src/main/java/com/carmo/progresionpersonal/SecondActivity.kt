package com.carmo.progresionpersonal

import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.carmo.progresionpersonal.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tropainicio)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        val Siempre = getSharedPreferences("Siempre", Context.MODE_PRIVATE)
        val Persona_Space = findViewById<TextView>(R.id.persona_Space)
        Persona_Space.setText(Siempre.getString("NombreAct", "No existe").toString())

        findViewById<ImageButton>(R.id.imageButton2).setOnClickListener(){
            startActivity(Intent(this, etapas_tropa::class.java))
        }


    }
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            val intent = Intent(this,ListaTropaNombre::class.java)
            startActivity(intent)
            finish()
        }
        return super.onKeyDown(keyCode, event)
    }
}