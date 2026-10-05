package com.example.farmacia.model

class DetalleVenta(
    val medicamento: Medicamento,
    val cantidad: Int
) {
    val precioUnitario: Double = medicamento.precio
    var subtotal: Double = 0.0
        private set

    init {
        require(cantidad > 0) { "La cantidad debe ser mayor a cero" }
        calcularSubtotal()
    }

    fun calcularSubtotal(): Double {
        subtotal = precioUnitario * cantidad
        return subtotal
    }
}
