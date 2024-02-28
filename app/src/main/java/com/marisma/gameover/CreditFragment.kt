package com.marisma.gameover


import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Intent
import android.text.Html
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.marisma.gameover.databinding.FragmentCreditBinding
import com.marisma.gameover.databinding.FragmentMainBinding

class CreditFragment : Fragment() {
    val ARG_Nombres = "nombre"
    private var nombre: String? = null
    private var _binding : FragmentCreditBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**EDITADO*/
        setFragmentResultListener("requestKey"){ key, bundle ->
            nombre = bundle.getString("bundleKey")
            Log.i("Saul",  nombre.orEmpty())
            binding.tvWelcome.text = "¡Bienvenido, " + nombre.orEmpty()


        }
        /** */

    /*arguments?.let {

        }*/
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreditBinding.inflate(layoutInflater, container, false)
        /*
        // Recuperar el nombre del usuario de la actividad anterior (MainActivity)
        val name = arguments?.getString("Name")

        // Verificar si el nombre del usuario no es nulo
        name?.let {
            // Crear un mensaje de bienvenida personalizado con el nombre del usuario
            val welcomeMessage = "¡Bienvenido, $name!"
            // Actualizar la interfaz de usuario con el mensaje de bienvenida
            binding.tvWelcome.text = welcomeMessage
        }*/

        // Configurar la acción de clic para el botón de contacto
        binding.contactButton.setOnClickListener {
            // Lanzar un intent implícito de envío de correo electrónico
            val emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.type = "plain/text"
            emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("tucorreo@example.com"))
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Consulta desde la aplicación")
            //emailIntent.putExtra(Intent.EXTRA_TEXT, "Hola, soy $nombre y quisiera consultar sobre...")
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Hola, soy name y quisiera consultar sobre...")

            // Verificar si hay una aplicación de correo electrónico disponible
            if (emailIntent.resolveActivity(requireActivity().packageManager) != null) {
                startActivity(emailIntent)
            }
        }

        return binding.root
    }

    companion object{
        @JvmStatic
        fun newInstance(param1: String) =
            CreditFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_Nombres, param1)
                }
            }

    }
}