package com.marisma.gameover.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.marisma.gameover.Juego
import com.marisma.gameover.R

class JuegoAdapter(private val juegosLista:List<Juego>, private val onClickListener: (Juego) -> Unit) : RecyclerView.Adapter<JuegoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JuegoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return JuegoViewHolder(layoutInflater.inflate(R.layout.item_juego,parent,false))
    }
    /** retornamos el tamaño de la lista del provider*/
    override fun getItemCount(): Int = juegosLista.size

    override fun onBindViewHolder(holder: JuegoViewHolder, position: Int) {
        holder.render(juegosLista[position], onClickListener)

    }

}