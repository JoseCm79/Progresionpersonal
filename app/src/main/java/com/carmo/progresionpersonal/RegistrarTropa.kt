package com.carmo.progresionpersonal

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import com.carmo.progresionpersonal.R

class RegistrarTropa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_tropa)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        val preferencesTropa = getSharedPreferences("Siempre", Context.MODE_PRIVATE)
        val editorTropa : SharedPreferences.Editor = preferencesTropa.edit()

        val Nombre = findViewById<EditText>(R.id.nombreApellidoTropa)
        val boton = findViewById<ImageButton>(R.id.registrartropa)
        boton.setOnClickListener(){
            if(Nombre.getText().toString().isNotEmpty() && Nombre.length() > 10){
                val ID = preferencesTropa.getInt("IDtropa",1).toString().toInt()
                Toast.makeText(this, "Creado", Toast.LENGTH_SHORT).show()
                editorTropa.putString("tropero"+ID,Nombre.getText().toString()).commit()
                editorTropa.putInt("IDtropa",ID+1).commit()
                val intent = Intent(this,ListaTropaNombre::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this, "Coloque el nombre completo del tropero que desee registrar", Toast.LENGTH_SHORT).show()

            }


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