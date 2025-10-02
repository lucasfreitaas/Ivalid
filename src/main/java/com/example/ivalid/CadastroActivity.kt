package com.example.ivalid

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

// CORRETO: Herda de AppCompatActivity
class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.createaccount)

        val textLogin:  TextView = findViewById(R.id.textLogin)
        val textInitial: TextView = findViewById(R.id.buttonCadastrar)

        textLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)

            startActivity(intent)
        }
        textInitial.setOnClickListener {
            val intent = Intent(this, InitialActivity::class.java)

            startActivity(intent)
        }
    }
}