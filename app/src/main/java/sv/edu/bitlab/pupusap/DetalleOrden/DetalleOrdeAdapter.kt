package sv.edu.bitlab.pupusap.DetalleOrden

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sv.edu.bitlab.pupusap.Models.Orden
import sv.edu.bitlab.pupusap.Models.OrdenPupusas
import sv.edu.bitlab.pupusap.R

class DetalleOrdeAdapter(var orden: List<Orden>, var rellenoMaiz:String, var rellenoArroz:String, val listener: DetalleOrdeViewHolder.DetalleListener): RecyclerView.Adapter<DetalleOrdeViewHolder>(){
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetalleOrdeViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.list_row_detalle, parent, false)
    return DetalleOrdeViewHolder(view, listener)
  }

  override fun getItemCount(): Int {
    return orden.size
  }

  override fun onBindViewHolder(holder: DetalleOrdeViewHolder, position: Int) {

    holder.detalleItems(orden[position], rellenoMaiz[position].toString(), rellenoArroz[position].toString())
  }

}