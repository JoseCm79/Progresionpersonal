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
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.carmo.progresionpersonal.R
import java.util.Objects

class RegistrarTsuri : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_tsuri)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        val preferencesTsuris = getSharedPreferences("Siempre", Context.MODE_PRIVATE)
        val editorTsuris : SharedPreferences.Editor = preferencesTsuris.edit()

        val Nombre = findViewById<EditText>(R.id.NombreApellidoWak)
        val boton = findViewById<ImageButton>(R.id.Registrarwak)
        boton.setOnClickListener(){
            if(Nombre.getText().toString().isNotEmpty() && Nombre.length() > 10){

                var queue = Volley.newRequestQueue(this)
                var url = "https://api-restppp.000webhostapp.com/wak/consultar.php/?Nombre=${Nombre.getText()}"
                val jsonObjectRequest = JsonObjectRequest(
                    Request.Method.GET, url, null,
                    { response ->

                        Toast.makeText(this, "Se encontro un tsurí igual en la base de datos", Toast.LENGTH_SHORT).show()
                    }, { error ->

                        val ID = preferencesTsuris.getInt("ID",1).toString().toInt()
                        Toast.makeText(this, "Creado", Toast.LENGTH_SHORT).show()
                        editorTsuris.putString("tsuri"+ID,Nombre.getText().toString()).commit()
                        editorTsuris.putInt("ID",ID+1).commit()
                        val intent = Intent(this,ListaWakNombres::class.java)
                        startActivity(intent)
                        finish()
                    }

                )
                queue.add(jsonObjectRequest)


            }else{
                Toast.makeText(this, "Coloque el nombre completo del tsurí que desee registrar", Toast.LENGTH_SHORT).show()

            }

        }



    }
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            val intent = Intent(this,ListaWakNombres::class.java)
            startActivity(intent)
            finish()
        }
        return super.onKeyDown(keyCode, event)
    }
}