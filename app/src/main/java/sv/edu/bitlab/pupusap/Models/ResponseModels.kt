package sv.edu.bitlab.pupusap.Models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class RellenoWrapper(var rellenos: List<Relleno>)
@Parcelize
data class Relleno(var nombre: String, var id: Int):Parcelable
@Parcelize
data class OrdenPupusas(var relleno: Relleno, var total: Int): Parcelable
@Parcelize
data class Orden(var id: Int, var status: String,
                 var arroz: ArrayList<OrdenPupusas>, var maiz: ArrayList<OrdenPupusas>,
                 var precio_unidad: Float, var total: Float) : Parcelable
data class OrdeneWrapper(var page_size: Int, var page: Int, var ordenes: List<Orden>)
data class OrdenWrapper(var orden: Orden)