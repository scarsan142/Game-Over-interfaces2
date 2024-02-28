import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.marisma.gameover.Juego
import com.marisma.gameover.JuegoProvider
import com.marisma.gameover.R
import com.marisma.gameover.Usuario
import com.marisma.gameover.UsuarioProvider
import com.marisma.gameover.adapter.JuegoAdapter
import com.marisma.gameover.databinding.FragmentItemListBinding
import com.marisma.gameover.databinding.ItemJuegoBinding

class ItemListFragment : Fragment() {
    private lateinit var binding: FragmentItemListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentItemListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iniciarRecyclerView()

        // Configura el clic del elemento de la lista
        binding.recyclerJuegos.adapter = JuegoAdapter(JuegoProvider.listaJuegos) { juego ->
            // Navega a DetailitemFragment y pasa los datos del juego como argumentos
            val bundle = Bundle().apply {
                putString("juegoNombre", juego.juego)
                putString("juegoGenero", juego.genero)
                putString("juegoEstudio", juego.estudio)
                putInt("juegoNota", juego.nota)
                putString("juegoFoto", juego.foto)
            }
            findNavController().navigate(R.id.action_itemListFragment_to_detailitemFragment, bundle)
        }

        binding.btnMyUser.setOnClickListener {
            findNavController().navigate(R.id.action_itemListFragment_to_userInfoFragmentFragment)
        }

    }

    private fun iniciarRecyclerView() {
        val manager = LinearLayoutManager(requireContext())
        binding.recyclerJuegos.layoutManager = manager
        binding.recyclerJuegos.adapter = JuegoAdapter(JuegoProvider.listaJuegos) { juego ->
            onItemSelected(juego)
        }
    }

    private fun onItemSelected(juego: Juego) {
        Toast.makeText(
            requireContext(),
            juego.juego,
            Toast.LENGTH_SHORT
        ).show()
    }
}