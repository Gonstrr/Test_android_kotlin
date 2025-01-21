package com.example.fundamentoskotlin.Login
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle

import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.fundamentoskotlin.Home.HomeActivity
import com.example.fundamentoskotlin.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        binding.buttonlogin.setOnClickListener {
            validarCampos() // Nombre en español y camelCase
        }
    }

    private fun navegarAHome() { // Nombre más descriptivo
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish() // Para cerrar la activity actual
    }

    fun validarCampos() {
        val email = binding.IDTxtEmail25.text.toString().trim() // Agregar trim()
        val password = binding.IdTxtPassword25.text.toString()

        when {
            !email.contains("@") -> {
                binding.IDTxtEmail25.error = "Ingrese un email válido"
            }
            email.isEmpty() -> {
                binding.IDTxtEmail25.error = "El email es requerido"
            }
            password.isEmpty() -> {
                binding.IdTxtPassword25.error = "La contraseña es requerida"
            }
            password.length < 6 -> {
                binding.IdTxtPassword25.error = "La contraseña debe tener al menos 6 caracteres"
            }
            else -> navegarAHome()
        }
    }
}