package com.carmo.progresionpersonal

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.drawable.Drawable
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import java.security.AccessController.getContext

class configura_wak : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configura_wak)

        val Siempre = getSharedPreferences("Siempre", Context.MODE_PRIVATE)
        findViewById<TextView>(R.id.NombreWakAct).setText(
            Siempre.getString(
                "NombreActWak",
                "No existe"
            ).toString()
        )

        val Actual = getSharedPreferences(Siempre.getString("NombreActWak", "No existe").toString(),Context.MODE_PRIVATE)
        val switch = findViewById<Switch>(R.id.switch1)
        val ActualEditor: SharedPreferences.Editor = Actual.edit()

        val nombreAct = Siempre.getString("NombreActWak", "No existe").toString()
        val queue = Volley.newRequestQueue(this)
        val url = "http://josecarmona79.tk/wak/consultar.php/?Nombre=$nombreAct"
        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener   {
                    response ->
                if(response.getString("Disponible") == "true"){
                    switch.isChecked = true
                }else{
                    switch.isChecked = false
                }
            }
            ,Response.ErrorListener { error ->
                switch.isChecked = false
            }

        )
        queue.add(jsonObjectRequest)



            val con: ConnectivityManager =
                getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
            var networkInfo = con.activeNetworkInfo;

            switch.setOnClickListener() {


                val con: ConnectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
                var networkInfo = con.activeNetworkInfo;
                if (networkInfo?.isConnected != null) {
                    ActualEditor.putBoolean("bd", switch.isChecked).commit()


                    val url = "https://api-restppp.000webhostapp.com/wak/update2.php/"
                    val queue = Volley.newRequestQueue(this)
                    val resultadoPost = object : StringRequest(
                        Method.POST, url,
                        Response.Listener<String> { response ->
                            Toast.makeText(
                                this,
                                "Configuración insertada exitosamente",
                                Toast.LENGTH_LONG
                            ).show()
                        }, Response.ErrorListener { error ->
                            Toast.makeText(
                                this,
                                "Configuración no insertada ",
                                Toast.LENGTH_LONG
                            ).show()
                        }) {
                        override fun getParams(): MutableMap<String, String>? {
                            val parametros = HashMap<String, String>()
                            parametros.put("Nombre",Siempre.getString("NombreActWak", "No existe").toString())
                            parametros.put("Disponible", switch.isChecked.toString())
                            return parametros
                        }
                    }
                    queue.add(resultadoPost)

                } else {
                    Toast.makeText(this, "No estás conectado a una red", Toast.LENGTH_SHORT).show()
                }

            }


    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        val Siempre = getSharedPreferences("Siempre", Context.MODE_PRIVATE)
        val Actual = getSharedPreferences(
            Siempre.getString("ActWak", "No existe").toString(),
            Context.MODE_PRIVATE
        )
        val ActualEditor: SharedPreferences.Editor = Actual.edit()
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            startActivity(Intent(this, InicioWak::class.java))
            finish()
        }
        return super.onKeyDown(keyCode, event)
    }
}