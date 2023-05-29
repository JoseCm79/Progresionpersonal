package com.carmo.progresionpersonal

import android.content.Intent
import android.content.pm.ActivityInfo
import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.carmo.progresionpersonal.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        val tropaboton : ImageButton = findViewById(R.id.tropabotoninicio)
        val wakboton : ImageButton = findViewById(R.id.wakbotoninicio)
        val infoboton : ImageButton = findViewById(R.id.info)

        infoboton.setOnClickListener(){


            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            val inflanter: LayoutInflater = getLayoutInflater()
            val view: View = inflanter.inflate(R.layout.dialog_info, null)
            builder.setView(view)
            val dialog: AlertDialog = builder.create()
            dialog.show()
            view.findViewById<TextView>(R.id.textView21).setPaintFlags(view.findViewById<TextView>(R.id.textView21).getPaintFlags() or Paint.UNDERLINE_TEXT_FLAG)
            view.findViewById<TextView>(R.id.info).setPaintFlags(view.findViewById<TextView>(R.id.info).getPaintFlags() or Paint.UNDERLINE_TEXT_FLAG)

            val gracias = view.findViewById<ImageView>(R.id.gracias)
            gracias.setOnClickListener() {
                Toast.makeText(this, "Muchas gracias por leer la información", Toast.LENGTH_SHORT)
                    .show()
                dialog.dismiss()
            }



        }
        wakboton.setOnClickListener(){
            val intent = Intent(this,ListaWakNombres::class.java)
            startActivity(intent)
            finish()
        }
        tropaboton.setOnClickListener() {
            /*
            val intent = Intent(this,ListaTropaNombre::class.java)
            startActivity(intent)
            finish()*/
            Toast.makeText(this, "Proximamente", Toast.LENGTH_SHORT).show()
        }

    }
}