package com.example.farmacia.model

abstract class Persona(
    val id: Int,
    var nombre: String,
    var telefono: String,
    var email: String
) {
    // En Kotlin la propiedad `nombre` ya expone su getter (getNombre() en JVM).
    fun actualizarContacto(nuevoTelefono: String, nuevoEmail: String) {
        telefono = nuevoTelefono
        email = nuevoEmail
    }

    abstract fun descripcion(): String
}
