package com.marisma.gameover

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.marisma.gameover.databinding.FragmentMainBinding


const val ARG_Nombre = "nombre"
class MainFragment : Fragment() {
    private var nombre: String? = null

    private var _binding : FragmentMainBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**EDITADO*/
        setFragmentResultListener("requestKey"){ key, bundle ->
            nombre = bundle.getString("bundleKey")
            Log.i("Saul",  nombre.orEmpty())
            binding.tvUser.text = nombre.orEmpty()
        }
        /** */

        /**setFragmentResultListener("requestKey"){
            requestKey, bundle -> val result = bundle.getString("bundleKey")
            Log.i("Saul",  result.orEmpty())
        }
        /arguments?.let {

            nombre=it.getString(ARG_Nombre)
           // Log.i("Saul",  nombre.orEmpty())
        }**/
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.i("Saul",  "Entro")
        Log.i("Saul",  nombre.orEmpty())

        _binding = FragmentMainBinding.inflate(layoutInflater,container,false)
        binding.tvUser.text = nombre.orEmpty()

        //Botón de Play que lleva al fragmento GameFragment.
        binding.btnCredits.setOnClickListener {
            val nombreUsu = binding.tvUser.text.toString()
            setFragmentResult("requestKey", bundleOf("bundleKey" to nombreUsu))
            findNavController().navigate(R.id.action_mainFragment_to_creditFragment)
        }
        binding.btnExit.setOnClickListener{
            findNavController().navigate(R.id.action_mainFragment_to_loginFragment2)
        }
        binding.ivComenzar.setOnClickListener{
            findNavController().navigate(R.id.action_mainFragment_to_itemListFragment)
        }


        val menuHost: MenuHost = requireActivity()
        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.options_menu, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.ItemListMenu -> {
                        Log.d("MainFragment", "Navigating to ItemListFragment")
                        findNavController().navigate(R.id.action_mainFragment_to_itemListFragment)
                        true
                    }
                    R.id.FavItemListMenu -> {
                        Log.d("MainFragment", "Navigating to FavItemListFragment")
                        findNavController().navigate(R.id.action_mainFragment_to_favItemListFragment)
                        true
                    }
                    R.id.UserInfoMenu -> {
                        Log.d("MainFragment", "Navigating to FavItemListFragment")
                        findNavController().navigate(R.id.action_mainFragment_to_userInfoFragmentFragment)
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)

        return binding.root

    }

    companion object{
        @JvmStatic
        fun newInstance(param1: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_Nombre, param1)
                }
            }

    }
}