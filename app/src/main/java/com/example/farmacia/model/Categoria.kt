package com.example.farmacia.model

class Categoria(
    val id: Int,
    var nombre: String,
    var descripcion: String
) {
    fun actualizarDatos(nuevoNombre: String, nuevaDescripcion: String) {
        nombre = nuevoNombre
        descripcion = nuevaDescripcion
    }

    override fun toString() = nombre
}
