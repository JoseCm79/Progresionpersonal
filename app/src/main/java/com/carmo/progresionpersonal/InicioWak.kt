package com.carmo.progresionpersonal

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.ActivityInfo
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class InicioWak : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.wakinicio)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        val Siempre = getSharedPreferences("Siempre", Context.MODE_PRIVATE)
        val Actual = getSharedPreferences(Siempre.getString("ActWak", "No existe").toString(),Context.MODE_PRIVATE)
        val Actual2 = getSharedPreferences(Siempre.getString("NombreActWak", "No existe").toString(),Context.MODE_PRIVATE)
        val Persona_Space = findViewById<TextView>(R.id.Persona_wak)
        val nombreAct = Siempre.getString("NombreActWak", "No existe").toString()
        Persona_Space.setText(nombreAct)
        val switch = Actual.getBoolean("bd",false)
        val con : ConnectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = con.activeNetworkInfo;
        if(networkInfo?.isConnected != null){

                var queue = Volley.newRequestQueue(this)
                var url = "http://josecarmona79.tk/wak/consultar.php/?Nombre=$nombreAct"
                val jsonObjectRequest = JsonObjectRequest(
                    Request.Method.GET, url, null,
                    { response ->


                        url = "http://josecarmona79.tk/wak/update.php/"
                        queue = Volley.newRequestQueue(this)
                        val resultadoPost2 = object : StringRequest(Request.Method.POST, url,
                            Response.Listener<String> { response ->
                                if(switch == true){
                                    Toast.makeText(this, "Se han actualizado los datos", Toast.LENGTH_LONG).show()
                                }
                            },
                            Response.ErrorListener { error ->
                                Toast.makeText(this, "El perfil del tsurí no se puede actualizar", Toast.LENGTH_LONG).show()
                            }
                        ){
                            override fun getParams(): MutableMap<String, String>? {
                                var parametros = HashMap<String, String>()

                                parametros.put("Nombre", nombreAct)
                                parametros.put("Etapa1", Actual2.getString("estadoDURA", "0").toString())
                                parametros.put("Etapa2", Actual2.getString("estadoDariri", "0").toString())
                                parametros.put("Etapa3", Actual2.getString("estadoTsuri", "0").toString())

                                parametros.put("Trillos1", Actual2.getString("estadobasu", "0").toString())
                                parametros.put("Trillos2", Actual2.getString("estadousure", "0").toString())
                                parametros.put("Trillos3", Actual2.getString("estadoawakal", "0").toString())
                                parametros.put("Trillos4", Actual2.getString("estadosenuk", "0").toString())
                                parametros.put("Trillos5", Actual2.getString("estadodulekalom", "0").toString())
                                parametros.put("Area1", Actual2.getString("estadokabata", "0").toString())
                                parametros.put("Area2", Actual2.getString("estadoservi", "0").toString())
                                parametros.put("Area3", Actual2.getString("estadotecno", "0").toString())
                                parametros.put("Area4", Actual2.getString("estadoarte", "0").toString())
                                parametros.put("Area5", Actual2.getString("estadodeporte", "0").toString())
                                //libretas
                                parametros.put("Etapal1", Actual2.getString("dura dura", "").toString())
                                parametros.put("Etapal2", Actual2.getString("dariri", "").toString())
                                parametros.put("Etapal3", Actual2.getString("tsuri", "").toString())
                                parametros.put("Trillosl1", Actual2.getString("basu", "").toString())
                                parametros.put("Trillosl2", Actual2.getString("usure", "").toString())
                                parametros.put("Trillosl3", Actual2.getString("awakal", "").toString())
                                parametros.put("Trillosl4", Actual2.getString("senuk", "").toString())
                                parametros.put("Trillosl5", Actual2.getString("dulekalom", "").toString())
                                  parametros.put("arealibreta1", Actual2.getString("aire", "").toString())
                                parametros.put("arealibreta2", Actual2.getString("servicio", "").toString())
                                parametros.put("arealibreta3", Actual2.getString("tecno", "").toString())
                                parametros.put("arealibreta4", Actual2.getString("arte", "").toString())
                                parametros.put("arealibreta5", Actual2.getString("deporte", "").toString())
                                parametros.put("equipoL", Actual2.getString("equipo", "" ).toString())
                                parametros.put("wakL", Actual2.getString( "wak", "" ).toString())
                                parametros.put("personalL", Actual2.getString( "personales", "" ).toString())

                                return parametros
                            }
                        }

                        queue.add(resultadoPost2)

                    }, { error ->
                        url = "http://josecarmona79.tk/wak/insertar.php"
                        queue = Volley.newRequestQueue(this)
                        val resultadoPost = object : StringRequest(Request.Method.POST, url,
                            Response.Listener<String> { response ->
                                Toast.makeText(this, "Se ha registrado el nuevo tsurí", Toast.LENGTH_LONG).show()
                            },Response.ErrorListener { error ->
                                Toast.makeText(this, "Tsurí no se ha podido registrar "+error, Toast.LENGTH_LONG).show()
                            }){
                            override fun getParams(): MutableMap<String, String>? {
                                var parametros = HashMap<String, String>()
                                parametros.put("Nombre", nombreAct)
                                parametros.put("Contrasena", "1234")
                                parametros.put("Seccion", "1")
                                parametros.put("Etapa1", Actual2.getString("estadoDURA", "0").toString())
                                parametros.put("Etapa2", Actual2.getString("estadoDariri", "0").toString())
                                parametros.put("Etapa3", Actual2.getString("estadoTsuri", "0").toString())

                                parametros.put("Trillos1", Actual2.getString("estadobasu", "0").toString())
                                parametros.put("Trillos2", Actual2.getString("estadousure", "0").toString())
                                parametros.put("Trillos3", Actual2.getString("estadoawakal", "0").toString())
                                parametros.put("Trillos4", Actual2.getString("estadosenuk", "0").toString())
                                parametros.put("Trillos5", Actual2.getString("estadodulekalom", "0").toString())
                                parametros.put("Area1", Actual2.getString("estadokabata", "0").toString())
                                parametros.put("Area2", Actual2.getString("estadoservi", "0").toString())
                                parametros.put("Area3", Actual2.getString("estadotecno", "0").toString())
                                parametros.put("Area4", Actual2.getString("estadoarte", "0").toString())
                                parametros.put("Area5", Actual2.getString("estadodeporte", "0").toString())
                                //libretas
                                parametros.put("Etapal1", Actual2.getString("dura dura", "").toString())
                                parametros.put("Etapal2", Actual2.getString("dariri", "").toString())
                                parametros.put("Etapal3", Actual2.getString("tsuri", "").toString())
                                parametros.put("Trillosl1", Actual2.getString("basu", "").toString())
                                parametros.put("Trillosl2", Actual2.getString("usure", "").toString())
                                parametros.put("Trillosl3", Actual2.getString("awakal", "").toString())
                                parametros.put("Trillosl4", Actual2.getString("senuk", "").toString())
                                parametros.put("Trillosl5", Actual2.getString("dulekalom", "").toString())
                                parametros.put("arealibreta1", Actual2.getString("aire", "").toString())
                                parametros.put("arealibreta2", Actual2.getString("servicio", "").toString())
                                parametros.put("arealibreta3", Actual2.getString("tecno", "").toString())
                                parametros.put("arealibreta4", Actual2.getString("arte", "").toString())
                                parametros.put("arealibreta5", Actual2.getString("deporte", "").toString())
                                parametros.put("equipoL", Actual2.getString("equipo", "" ).toString())
                                parametros.put("wakL", Actual2.getString( "wak", "" ).toString())
                                parametros.put("personalL", Actual2.getString( "personales", "" ).toString())

                                return parametros
                            }
                        }
                        queue.add(resultadoPost)

                    }

                )
                queue.add(jsonObjectRequest)

        }

        findViewById<ImageButton>(R.id.EtapasWak).setOnClickListener(){
            val intent = Intent(this, EtapasWak::class.java)
            startActivity(intent)
            finish()
        }
        findViewById<ImageButton>(R.id.TrillosWak).setOnClickListener(){
            val intent = Intent(this, Trillos_wak::class.java)
            startActivity(intent)
            finish()
        }
        findViewById<ImageButton>(R.id.AreaWak).setOnClickListener(){
            val intent = Intent(this, areas_wak::class.java)
            startActivity(intent)
            finish()
        }
        findViewById<ImageButton>(R.id.MetasWak).setOnClickListener() {
            val intent = Intent(this, metas_wak::class.java)
            startActivity(intent)
            finish()
        }
        findViewById<ImageButton>(R.id.configuracion).setOnClickListener() {
                    val intent = Intent(this, configura_wak::class.java)
                    startActivity(intent)
                    finish()
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