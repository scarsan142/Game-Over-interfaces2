import android.util.Log
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.marisma.gameover.Favoritos
import com.marisma.gameover.FavoritosProvider
import com.marisma.gameover.Juego
import com.marisma.gameover.JuegoProvider
import com.marisma.gameover.databinding.ItemFavoritoBinding

class FavoritoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemFavoritoBinding.bind(view)

    fun render(favorito: Favoritos, onClickListener: (Favoritos) -> Unit) {
        val juego = JuegoProvider.buscarJuegoPorId(favorito.id) as Juego
        Log.i("prueba",juego.id.toString())
        if (juego != null) {
            // Aquí puedes utilizar los campos del objeto Juego
            binding.tvJuegoName.text = juego.juego
            binding.tvGenero.text = juego.genero
            binding.tvEstudio.text = juego.estudio
            // También puedes cargar la imagen del juego utilizando Glide u otra biblioteca
            Glide.with(binding.ivJuego.context).load(juego.foto).into(binding.ivJuego)
        } else binding.tvJuegoName.text = favorito.id.toString()

        binding.btnDelete.setOnClickListener {
            FavoritosProvider.quitarJuegoFavorito(favorito)
        }
    }
}