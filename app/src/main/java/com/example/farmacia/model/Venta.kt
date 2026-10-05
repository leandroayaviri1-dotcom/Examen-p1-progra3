package com.example.farmacia.model

import java.time.LocalDate

class Venta(
    val id: Int,
    val fecha: LocalDate,
    val cliente: Cliente,
    val empleado: Empleado
) {
    private val _detalles = mutableListOf<DetalleVenta>()
    val detalles: List<DetalleVenta> get() = _detalles.toList()

    var total: Double = 0.0
        private set
    var confirmada: Boolean = false
        private set

    fun agregarDetalle(medicamento: Medicamento, cantidad: Int) {
        check(!confirmada) { "La venta ya fue confirmada" }
        check(medicamento.stock >= cantidad) { "Stock insuficiente de ${medicamento.nombre}" }
        _detalles.add(DetalleVenta(medicamento, cantidad))
        calcularTotal()
    }

    fun calcularTotal(): Double {
        total = _detalles.sumOf { it.calcularSubtotal() }
        return total
    }

    fun confirmarVenta() {
        check(!confirmada) { "La venta ya fue confirmada" }
        check(_detalles.isNotEmpty()) { "La venta no tiene detalles" }
        _detalles.forEach { it.medicamento.reducirStock(it.cantidad) }
        confirmada = true
    }
}
