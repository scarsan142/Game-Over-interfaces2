import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.marisma.gameover.Favoritos
import com.marisma.gameover.FavoritosProvider
import com.marisma.gameover.Juego
import com.marisma.gameover.R
import com.marisma.gameover.adapter.JuegoAdapter
import com.marisma.gameover.databinding.FragmentFavItemListBinding

class FavItemListFragment : Fragment() {
    private lateinit var binding: FragmentFavItemListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavItemListBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        iniciarRecyclerView()

    }

    private fun iniciarRecyclerView() {
        val manager = LinearLayoutManager(requireContext())
        binding.recyclerFavoritos.layoutManager = manager

        // Utilizamos el mismo JuegoAdapter para mostrar la lista de favoritos
        binding.recyclerFavoritos.adapter = FavoritosAdapter(FavoritosProvider.listaJuegosFavoritos) {

        }
    }


}
