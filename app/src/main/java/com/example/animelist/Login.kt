package com.example.animelist

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Login : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val prefs = getSharedPreferences("APP_PREFS", MODE_PRIVATE)
        val isLoggedIn = prefs.getBoolean("IS_LOGGED_IN", false)

        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)

        if (isLoggedIn) {
            // User sudah login
            Toast.makeText(this, "Sudah login", Toast.LENGTH_SHORT).show()
            // Pindah ke Home
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
            finish() // supaya tidak bisa kembali ke Login pakai tombol Back
        }

        btnLogin.setOnClickListener {
            val username = etEmail.text.toString()
            val password = etPassword.text.toString()

            // User belum login
            if (username == "abdussalammustajib@gmail.com" && password == "qwertyui") {
                // Simpan status login
                prefs.edit().putBoolean("IS_LOGGED_IN", true).apply()

                // Pindah ke Home
                val intent = Intent(this, Home::class.java)
                startActivity(intent)
                finish() // supaya tidak bisa kembali ke Login pakai tombol Back
            } else {
                Toast.makeText(this, "Login gagal", Toast.LENGTH_SHORT).show()
            }

        }
    }
}