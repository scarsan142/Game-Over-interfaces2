package com.marisma.gameover

import androidx.fragment.app.add
import androidx.fragment.app.commit
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.marisma.gameover.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private var _binding : FragmentLoginBinding? = null
    private val binding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root

        /**EDITADO*/
        binding.btnMenu.setOnClickListener {
            val nombreUsu = binding.etUser.text.toString()
            if (nombreUsu.isBlank()) {
                // Si el campo de usuario está vacío, mostrar un mensaje emergente
                Toast.makeText(requireContext(), "Por favor, ingresa tu nombre de usuario", Toast.LENGTH_SHORT).show()
            } else {
                // Si el campo de usuario no está vacío, continuar con la navegación
                UsuarioProvider.usuario = Usuario(nombreUsu)
                setFragmentResult("requestKey", bundleOf("bundleKey" to nombreUsu))
                findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
            }
        }

        return view
        /** */

        /*
        if (savedInstanceState == null) {


            //val bundle = bundleOf(ARG_Nombre to R.id.etUser)
            val bundle = bundleOf(ARG_Nombre to "Hola aaaa")

            //Botón de Play que lleva al fragmento GameFragment.
            binding.btnMenu.setOnClickListener {
                findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
                val result = "result"
                setFragmentResult("requestKey", bundleOf("bundleKey" to result))*/

            }

/*
                childFragmentManager.commit {
                    setReorderingAllowed(true)
                    add<MainFragment>(R.id.fcwMain, args = bundle)

                }

            }*/
}



