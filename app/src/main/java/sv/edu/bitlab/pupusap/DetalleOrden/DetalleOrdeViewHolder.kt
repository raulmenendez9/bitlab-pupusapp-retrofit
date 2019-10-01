package sv.edu.bitlab.pupusap.DetalleOrden

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sv.edu.bitlab.pupusap.Models.Orden
import sv.edu.bitlab.pupusap.R

class DetalleOrdeViewHolder(itemView: View, val listener: DetalleListener):RecyclerView.ViewHolder(itemView){


  fun detalleItems(orden: Orden){

    var detalle: TextView = itemView.findViewById(R.id.lineItemDetail1)
    var precio: TextView = itemView.findViewById(R.id.lineItemPrice1)

    detalle.text= orden.maiz.toString()
   //precio.text= orden.id

    //listener.displayDetalle(orden.maiz, precio)


  }
  interface DetalleListener{

    fun displayDetalle( detalle: TextView, precio: TextView, contador: Int, index: Int)

  }

  }

