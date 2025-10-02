package com.example.ivalid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.TextView

class LoginActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val textCreate:  TextView = findViewById(R.id.createAccount)
        val textInitial: TextView = findViewById(R.id.buttonLogin)

        textCreate.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)

            startActivity(intent)
        }

        textInitial.setOnClickListener {
            val intent = Intent(this, InitialActivity::class.java)

            startActivity(intent)
        }
    }
}
