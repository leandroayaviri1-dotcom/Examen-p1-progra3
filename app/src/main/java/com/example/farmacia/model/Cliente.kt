package com.example.farmacia.model

class Cliente(
    id: Int,
    nombre: String,
    telefono: String,
    email: String,
    var direccion: String
) : Persona(id, nombre, telefono, email) {

    private val historial = mutableListOf<Venta>()

    fun realizarCompra(venta: Venta) {
        historial.add(venta)
    }

    fun consultarHistorial(): List<Venta> = historial.toList()

    override fun descripcion() = "Cliente: $nombre ($direccion)"
}
