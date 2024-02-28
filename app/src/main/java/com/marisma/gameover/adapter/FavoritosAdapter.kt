import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marisma.gameover.Favoritos
import com.marisma.gameover.R

class FavoritosAdapter(private val favoritosLista: List<Favoritos>, private val onClickListener: (Favoritos) -> Unit) : RecyclerView.Adapter<FavoritoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return FavoritoViewHolder(layoutInflater.inflate(R.layout.item_favorito,parent,false))
    }

    override fun getItemCount(): Int = favoritosLista.size

    override fun onBindViewHolder(holder: FavoritoViewHolder, position: Int) {
        holder.render(favoritosLista[position], onClickListener)
    }
}


