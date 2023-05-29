package com.carmo.progresionpersonal

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.ListView
import android.widget.Toast
import com.carmo.progresionpersonal.R

class ListaTropaNombre : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_tropa_nombres)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        val Siempre = getSharedPreferences("Siempre", Context.MODE_PRIVATE)
        val editorSiempre : SharedPreferences.Editor = Siempre.edit()
        var mode = Siempre.getBoolean("Modotropa", false)

        var troperosList = findViewById<ListView>(R.id.troperoslista)
        var arrayAdapter : ArrayAdapter<*>
        var troperos = mutableListOf("")
        troperos.remove("")
        for(i in 1..Siempre.getInt("IDtropa",1)){
            var nombreFor = Siempre.getString("tropero"+i,"No existe")
            if(nombreFor != "No existe")
            {
                troperos.add(nombreFor.toString())
            }

        }

        arrayAdapter = ArrayAdapter(this,R.layout.troperos,troperos)
        troperosList.adapter = arrayAdapter
        val anadirTropa = findViewById<ImageButton>(R.id.anadirtropa)

        troperosList.setOnItemClickListener(){parent, view, position, id->
            if(mode == false){
                editorSiempre.putString("NombreAct",parent.getItemAtPosition(position).toString()).commit()
                val intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
                finish()
            }
            else
            {
                for (i in 1..Siempre.getInt("IDtropa",1))
                {
                    if (Siempre.getString("tropero"+i,"no existe") == parent.getItemAtPosition(position).toString()){

                        editorSiempre.remove("tropero"+i).commit()
                        for(i in 1..Siempre.getInt("IDtropa",1)){
                            var nombreFor = Siempre.getString("tropero"+i,"No existe")
                            if(nombreFor != "No existe"){
                                troperos.add(nombreFor.toString())
                            }

                        }
                        arrayAdapter = ArrayAdapter(this,R.layout.troperos,troperos)
                        troperosList.adapter = arrayAdapter
                        val intent = Intent(this,ListaTropaNombre::class.java)
                        startActivity(intent)
                        finish()

                    }
                }
            }

        }
        anadirTropa.setOnClickListener(){
            val intent = Intent(this, RegistrarTropa::class.java)
            startActivity(intent)
            editorSiempre.putBoolean("Modotropa",false).commit()
            finish()
        }
        val botoEliminate = findViewById<ImageButton>(R.id.Eliminarboton)
        botoEliminate.setOnClickListener(){
            if (!mode){
                mode = true
                Toast.makeText(this, "Modo eliminar", Toast.LENGTH_SHORT).show()
            }
            else{
                mode=false
                Toast.makeText(this, "Modo registrar", Toast.LENGTH_SHORT).show()

            }
            editorSiempre.putBoolean("Modotropa",mode).commit()
        }


    }
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        val Siempre = getSharedPreferences("Siempre", Context.MODE_PRIVATE)
        val editorSiempre : SharedPreferences.Editor = Siempre.edit()

        if (keyCode == KeyEvent.KEYCODE_BACK) {

            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            editorSiempre.putBoolean("Modotropa",false).commit()
            finish()
        }
        return super.onKeyDown(keyCode, event)
    }
}


