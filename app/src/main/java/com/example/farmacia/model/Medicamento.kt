package com.example.farmacia.model

class Medicamento(
    val id: Int,
    var nombre: String,
    precio: Double,
    stock: Int,
    val categoria: Categoria,
    val requiereReceta: Boolean
) {
    var precio: Double = precio
        private set
    var stock: Int = stock
        private set

    init {
        require(precio >= 0) { "El precio no puede ser negativo" }
        require(stock >= 0) { "El stock no puede ser negativo" }
    }

    fun estaDisponible(): Boolean = stock > 0

    fun aumentarStock(cantidad: Int) {
        require(cantidad > 0) { "La cantidad debe ser positiva" }
        stock += cantidad
    }

    fun reducirStock(cantidad: Int) {
        require(cantidad > 0) { "La cantidad debe ser positiva" }
        check(cantidad <= stock) { "Stock insuficiente de $nombre" }
        stock -= cantidad
    }

    fun actualizarPrecio(nuevoPrecio: Double) {
        require(nuevoPrecio >= 0) { "El precio no puede ser negativo" }
        precio = nuevoPrecio
    }
}
