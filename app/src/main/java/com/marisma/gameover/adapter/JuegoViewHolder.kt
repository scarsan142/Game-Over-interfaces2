package com.marisma.gameover.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.marisma.gameover.Favoritos
import com.marisma.gameover.FavoritosProvider
import com.marisma.gameover.Juego
import com.marisma.gameover.databinding.ItemFavoritoBinding
import com.marisma.gameover.databinding.ItemJuegoBinding

class JuegoViewHolder(view: View) : RecyclerView.ViewHolder(view){
    val binding = ItemJuegoBinding.bind(view)


    fun render(juegoModel: Juego, onClickListener: (Juego) -> Unit){
        binding.tvJuegoName.text = juegoModel.juego
        binding.tvGenero.text = juegoModel.genero
        binding.tvEstudio.text = juegoModel.estudio
        Glide.with(binding.ivJuego.context).load(juegoModel.foto).into(binding.ivJuego)
        /*
        binding.ivEquipo.setOnClickListener{
            Toast.makeText(
                binding.ivEquipo.context,
                equipoModel.equipo,
                Toast.LENGTH_SHORT
            ).show()
        }
        itemView.setOnClickListener{
            Toast.makeText(
                binding.ivEquipo.context,
                equipoModel.estadio,
                Toast.LENGTH_SHORT
            ).show()
        }*/

        // Set click listener for the favorite button
       binding.btnFavourite.setOnClickListener {
            // Create a Favoritos object from the Juego

            val favorito = Favoritos(juegoModel.id)
            // Add the game to favorites list
            FavoritosProvider.agregarJuegoFavorito(favorito)
        }
        /*binding2.btnDelete.setOnClickListener {
            // Create a Favoritos object from the Juego
            val favorito = Favoritos(juegoModel.juego, juegoModel.foto)
            // Add the game to favorites list
            FavoritosProvider.quitarJuegoFavorito(favorito)
        }*/



        itemView.setOnClickListener{onClickListener(juegoModel)}
    }


}