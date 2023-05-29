package com.carmo.progresionpersonal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent

class etapas_tropa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_etapas_tropa)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {

        if(keyCode == KeyEvent.KEYCODE_BACK){
            startActivity(Intent(this, SecondActivity::class.java))
            finish()
        }
        return super.onKeyDown(keyCode, event)
    }
}