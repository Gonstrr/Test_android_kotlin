package com.example.fundamentoskotlin.Login

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fundamentoskotlin.Home.HomeActivity
import com.example.fundamentoskotlin.R
import com.example.fundamentoskotlin.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding


    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        binding.buttonlogin.setOnClickListener {
            ValidandoCampos() // Llamando a la funcion de validacion de campos
        }







    }


    private fun TransicionPage(){
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)

    }





    private fun ValidandoCampos(){
        val email = binding.IDTxtEmail25.text.toString()
        val password = binding.IdTxtPassword25.text.toString()

        if(email.isEmpty()){
            binding.IDTxtEmail25.error = "El email es requerido"
            return
        }

        if(password.isEmpty()){
            binding.IdTxtPassword25.error = "La contraseña es requerida"
            return
        }

        if(password.length < 6){
            binding.IdTxtPassword25.error = "La contraseña debe tener al menos 6 caracteres"
            return
        }

        TransicionPage()

    }


}