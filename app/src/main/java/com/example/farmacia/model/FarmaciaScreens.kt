package com.example.farmacia.model



import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// Modelos simplificados para renderizar en Compose
data class MedicamentoItem(
    val id: Int,
    val nombre: String,
    val precio: Double,
    val stock: Int,
    val requiereReceta: Boolean
)

data class VentaItem(
    val id: Int,
    val cliente: String,
    val fecha: String,
    val total: Double
)

// ==========================================
// PANTALLA 1: Listado de Medicamentos
// ==========================================
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MedicamentosScreen() {
    val listaMedicamentos = listOf(
        MedicamentoItem(101, "Paracetamol 500mg", 2.50, 100, false),
        MedicamentoItem(102, "Ibuprofeno 400mg", 3.80, 50, false),
        MedicamentoItem(103, "Amoxicilina 500mg", 12.00, 30, true),
        MedicamentoItem(104, "Omeprazol 20mg", 8.50, 20, false)
    )

    Scaffold(
        topBar = { TopAppBar(title = { Text("Inventario de Medicamentos") }) }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(listaMedicamentos) { med ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(text = med.nombre, style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = "Precio: Bs. ${med.precio} | Stock: ${med.stock}")
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = if (med.requiereReceta) "⚠️ Requiere Receta" else "✅ Venta Libre",
                            color = if (med.requiereReceta) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }
    }
}

// ==========================================
// PANTALLA 2: Listado de Ventas
// ==========================================
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VentasScreen() {
    val listaVentas = listOf(
        VentaItem(1, "María Gómez", "05/10/2026", 18.30),
        VentaItem(2, "Juan Pérez", "05/10/2026", 45.00),
        VentaItem(3, "Carlos Mendoza", "04/10/2026", 12.50)
    )

    Scaffold(
        topBar = { TopAppBar(title = { Text("Historial de Ventas") }) }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(listaVentas) { venta ->
                ElevatedCard(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Venta #${venta.id} - ${venta.cliente}",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(text = "Fecha: ${venta.fecha}")
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Total: Bs. ${venta.total}",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            }
        }
    }
}