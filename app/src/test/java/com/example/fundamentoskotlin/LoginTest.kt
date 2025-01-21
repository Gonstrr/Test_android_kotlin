package com.example.fundamentoskotlin.Login

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class LoginTest {

        private lateinit var loginValidator: LoginValidator

        @Before
        fun setup() {
                loginValidator = LoginValidator()
        }

        @Test
        fun `campo email vacio retorna false`() {
                val resultado = loginValidator.validarCampos("", "1234567")
                assertFalse(resultado.exito)
                assertTrue(resultado.error == "El email es requerido")
        }

        @Test
        fun `campo password vacio retorna false`() {
                val resultado = loginValidator.validarCampos("Gonzalo@gmail.com", "")
                assertFalse(resultado.exito)
                assertTrue(resultado.error == "La contraseña es requerida")

}



// Clase auxiliar para validaciones
class LoginValidator {
        data class ResultadoValidacion(
                val exito: Boolean,
                val error: String = ""
        )

        fun validarCampos(email: String, password: String): ResultadoValidacion {
                return when {
                        email.isEmpty() -> ResultadoValidacion(false, "El email es requerido")
                        password.isEmpty() -> ResultadoValidacion(false, "La contraseña es requerida")
                        password.length < 6 -> ResultadoValidacion(false, "La contraseña debe tener al menos 6 caracteres")
                        else -> ResultadoValidacion(true)
                }
        }
}
}