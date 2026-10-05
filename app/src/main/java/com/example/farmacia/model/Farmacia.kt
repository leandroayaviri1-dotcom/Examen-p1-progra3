package com.example.farmacia.model

class Farmacia(
    val id: Int,
    var nombre: String,
    var direccion: String,
    var telefono: String
) {
    private val _medicamentos = mutableListOf<Medicamento>()
    private val _empleados = mutableListOf<Empleado>()
    private val _ventas = mutableListOf<Venta>()

    val medicamentos: List<Medicamento> get() = _medicamentos.toList()
    val empleados: List<Empleado> get() = _empleados.toList()
    val ventas: List<Venta> get() = _ventas.toList()

    fun agregarMedicamento(medicamento: Medicamento) {
        _medicamentos.add(medicamento)
    }

    fun buscarMedicamento(texto: String): List<Medicamento> =
        _medicamentos.filter { it.nombre.contains(texto, ignoreCase = true) }

    fun contratarEmpleado(empleado: Empleado) {
        _empleados.add(empleado)
    }

    fun registrarVenta(venta: Venta) {
        check(venta.confirmada) { "Solo se registran ventas confirmadas" }
        _ventas.add(venta)
    }
}
