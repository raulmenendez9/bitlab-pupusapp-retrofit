package sv.edu.bitlab.pupusap.Models

import android.os.Parcelable

data class RellenoWrapper(var rellenos: List<Relleno>)
data class Relleno(var nombre: String, var id: Int)
data class OrdenPupusas(var relleno: Relleno, var total: Int)
data class Orden(var id: Int, var status: String,
                 var arroz: List<OrdenPupusas>, var maiz: List<OrdenPupusas>,
                 var precio_unidad: Float, var total: Float) : Parcelable
data class OrdeneWrapper(var page_size: Int, var page: Int, var ordenes: List<Orden>)
data class OrdenWrapper(var orden: Orden)