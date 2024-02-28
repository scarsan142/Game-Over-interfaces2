package com.marisma.gameover

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CreditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_credit)

        val tvWelcome: TextView = findViewById(R.id.tvWelcome)
        val contactButton: Button = findViewById(R.id.contactButton)

        // Obtener el nombre del usuario de la actividad anterior
        val name = intent.getStringExtra("Name")
        val app_name = getString(R.string.app_name)
        // Verificar si el nombre del usuario no es nulo
        if (name != null) {
            // Mostrar mensaje de bienvenida con el nombre en color amarillo
            val msgWelcome = "<font color='#f3bb3d'>$name</font>, estás usando la versión 1 de la aplicación $app_name."
            tvWelcome.text = Html.fromHtml(msgWelcome, Html.FROM_HTML_MODE_LEGACY)
        }

        // Configurar el listener para el botón de contacto
        contactButton.setOnClickListener {
            // Lanzar un intent implícito de envío de correo electrónico
            val emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.type = "plain/text"
            emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("scarsan142@g.educaand.es"))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Consulta de la app $name")

            // Comprobar si hay una aplicación de correo electrónico disponible
            if (emailIntent.resolveActivity(packageManager) != null) {
                startActivity(emailIntent)
            }
        }
    }
}
