import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.marisma.gameover.R
import com.marisma.gameover.UsuarioProvider
import com.marisma.gameover.databinding.FragmentUserInfoFragmentBinding

class UserInfoFragmentFragment : Fragment() {
    private var _binding : FragmentUserInfoFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserInfoFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Obtener el nombre de usuario almacenado en UsuarioProvider
        val nombreUsuario = UsuarioProvider.usuario?.nombre

        // Mostrar el nombre de usuario en el TextView
        binding.tvUsername.text = nombreUsuario

        binding.btnFavoritos.setOnClickListener{
            findNavController().navigate(R.id.action_userInfoFragmentFragment_to_favItemListFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
