package sv.edu.bitlab.pupusap.HistoryScreen.HistoryRecyclerView

import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import sv.edu.bitlab.pupusap.Models.Orden
import sv.edu.bitlab.pupusap.Models.TakenOrden
import sv.edu.bitlab.pupusap.R

class HistoryItemViewHolder(itemView : View, val listener:OrdenItemListener) : RecyclerView.ViewHolder(itemView) {

  var idTxt: TextView? = null
  var status: TextView? = null
  var precioTxt: TextView? = null
  var totalTxt: TextView? = null
  var verDetalleBtn: Button? = null
  var contenedor:View? = null



  fun bindData(orden: Orden) {

    idTxt = itemView.findViewById(R.id.idTxt)
    status = itemView.findViewById(R.id.status)
    precioTxt = itemView.findViewById(R.id.precioTxt)
    totalTxt = itemView.findViewById(R.id.totalTxt)
    verDetalleBtn = itemView.findViewById(R.id.ordenarDenuevoBtn)
    contenedor = itemView.findViewById(R.id.itemContainer)

    idTxt!!.text = orden.id.toString()
    status!!.text = orden.status
    precioTxt!!.text = orden.precio_unidad.toString()
    totalTxt!!.text = orden.total.toString()

    verDetalleBtn!!.setOnClickListener {
      listener.onItemClick(this.adapterPosition)
    }
    contenedor!!.setOnClickListener { Log.d("RECYCLER_VIEW", "Click en contenedor") }

  }


  interface OrdenItemListener{
    fun onOrdenarDenuevoClick(orden: TakenOrden)
    fun onItemClick(position: Int)
    fun onTextInput(input:String, position: Int)
  }
}