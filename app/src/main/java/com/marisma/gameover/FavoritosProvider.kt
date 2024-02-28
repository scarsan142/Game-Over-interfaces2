package com.marisma.gameover

object FavoritosProvider {
    val listaJuegosFavoritos = mutableListOf<Favoritos>()

    fun agregarJuegoFavorito(juego: Favoritos) {
        listaJuegosFavoritos.add(juego)
    }

    fun quitarJuegoFavorito(juego: Favoritos) {
        listaJuegosFavoritos.remove(juego)
    }

}
