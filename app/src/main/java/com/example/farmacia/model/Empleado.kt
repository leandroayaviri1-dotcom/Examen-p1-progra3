package com.example.farmacia.model

import java.time.LocalDate

class Empleado(
    id: Int,
    nombre: String,
    telefono: String,
    email: String,
    var cargo: String,
    var salario: Double
) : Persona(id, nombre, telefono, email) {

    fun registrarVenta(idVenta: Int, cliente: Cliente): Venta {
        val venta = Venta(idVenta, LocalDate.now(), cliente, this)
        cliente.realizarCompra(venta)
        return venta
    }

    fun actualizarDatos(nuevoCargo: String, nuevoSalario: Double) {
        require(nuevoSalario >= 0) { "El salario no puede ser negativo" }
        cargo = nuevoCargo
        salario = nuevoSalario
    }

    override fun descripcion() = "Empleado: $nombre - $cargo"
}
