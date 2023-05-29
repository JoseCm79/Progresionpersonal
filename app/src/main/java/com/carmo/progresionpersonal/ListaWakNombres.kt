package com.carmo.progresionpersonal

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.ActivityInfo
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.carmo.progresionpersonal.R

class ListaWakNombres : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_wak_nombres)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        val Siempre = getSharedPreferences("Siempre", Context.MODE_PRIVATE)
        val editorSiempre : SharedPreferences.Editor = Siempre.edit()
        var mode = Siempre.getBoolean("ModoWak", false)
        var arrayAdapter : ArrayAdapter<*>


        var tsuris = mutableListOf("")
        tsuris.remove("")
        for(i in 1..Siempre.getInt("ID",1)){
            var nombreFor = Siempre.getString("tsuri"+i,"No existe")
            if(nombreFor != "No existe"){
                tsuris.add(nombreFor.toString())
            }

        }
        arrayAdapter = ArrayAdapter(this,R.layout.troperos,tsuris)
        var ListaTsuri = findViewById<ListView>(R.id.Messi)
        ListaTsuri.adapter = arrayAdapter
        ListaTsuri.setOnItemClickListener(){parent, view, position, id->
            var con : ConnectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            var networkInfo = con.activeNetworkInfo;
            if(networkInfo?.isConnected.toString() == "null"){
                    mode=false
            }
            if(!mode){
                editorSiempre.putString("NombreActWak",parent.getItemAtPosition(position).toString()).commit()
                val intent = Intent(this, InicioWak::class.java)
                startActivity(intent)
                finish()
            }
            else
            {

                val builder: AlertDialog.Builder = AlertDialog.Builder(this)
                val inflanter: LayoutInflater = getLayoutInflater()
                val view: View = inflanter.inflate(R.layout.dialog_borrar, null)
                builder.setView(view)
                val dialog: AlertDialog = builder.create()
                dialog.show()
                view.findViewById<TextView>(R.id.textView21).setPaintFlags(view.findViewById<TextView>(R.id.textView21).getPaintFlags() or Paint.UNDERLINE_TEXT_FLAG)
                view.findViewById<TextView>(R.id.info).setPaintFlags(view.findViewById<TextView>(R.id.info).getPaintFlags() or Paint.UNDERLINE_TEXT_FLAG)

                val borrar = view.findViewById<ImageView>(R.id.Borrar)
                borrar.setOnClickListener() {
                    for (i in 1..Siempre.getInt("ID",1))
                    {
                        if (Siempre.getString("tsuri"+i,"no existe") == parent.getItemAtPosition(position).toString()){

                            editorSiempre.remove("tsuri"+i).commit()
                            for(i in 1..Siempre.getInt("ID",1)){
                                var nombreFor = Siempre.getString("tsuri"+i,"No existe")
                                if(nombreFor != "No existe"){
                                    tsuris.add(nombreFor.toString())
                                }

                            }

                            var url = "https://api-restppp.000webhostapp.com/wak/borrar.php/"
                            var queue = Volley.newRequestQueue(this)
                            val resultadoPost4 = object : StringRequest(
                                Method.POST, url,
                                Response.Listener<String> { response ->
                                    Toast.makeText(this, "Tsurí eliminado exitosamente", Toast.LENGTH_LONG).show()
                                }, Response.ErrorListener { error ->
                                    Toast.makeText(this, "Tsurí no se ha eliminado de la base de datos ", Toast.LENGTH_LONG).show()
                                }){
                                override fun getParams(): MutableMap<String, String>? {
                                    val parametros = HashMap<String, String>()
                                    parametros.put("Nombre", parent.getItemAtPosition(position).toString())
                                    return parametros
                                }
                            }
                            queue.add(resultadoPost4)

                            arrayAdapter = ArrayAdapter(this,R.layout.troperos,tsuris)
                            ListaTsuri.adapter = arrayAdapter



                            val intent = Intent(this,ListaWakNombres::class.java)
                            startActivity(intent)
                            finish()

                        }
                    }
                    dialog.dismiss()
                }

                val cancelar = view.findViewById<ImageView>(R.id.Cancelar)
                cancelar.setOnClickListener(){
                    Toast.makeText(this, "La acción se ha cancelado", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                }


            }


        }

        val anadirwak = findViewById<ImageButton>(R.id.anadirwak)
        anadirwak.setOnClickListener(){
            val intent = Intent(this, RegistrarTsuri::class.java)
            startActivity(intent)
            editorSiempre.putBoolean("ModoWak",false).commit()
            finish()
        }

        val botonEliminar = findViewById<ImageButton>(R.id.EliminarWak)
        botonEliminar.setOnClickListener(){
            var con : ConnectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            var networkInfo = con.activeNetworkInfo;
            if(networkInfo?.isConnected != null){

                if (!mode){
                    mode = true
                    Toast.makeText(this, "Modo eliminar", Toast.LENGTH_LONG).show()
                }
                else{
                    mode=false
                    Toast.makeText(this, "Modo registrar", Toast.LENGTH_LONG).show()
                }
                editorSiempre.putBoolean("ModoWak",mode).commit()
            }else{
                Toast.makeText(this, "Se ocupa estar conectado a una red para realizar esta acción", Toast.LENGTH_SHORT).show()
            }
        }

    }
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        val Siempre = getSharedPreferences("Siempre", Context.MODE_PRIVATE)
        val editorSiempre : SharedPreferences.Editor = Siempre.edit()

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            editorSiempre.putBoolean("ModoWak",false).commit()
            finish()
        }
        return super.onKeyDown(keyCode, event)
    }
}