package sv.edu.bitlab.pupusap.HistoryScreen.HistoryRecyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sv.edu.bitlab.pupusap.Models.TakenOrden
import sv.edu.bitlab.pupusap.R
import kotlin.collections.ArrayList

class OrdenAdapter(var ordenes: ArrayList<TakenOrden>,
                   val listener: HistoryItemViewHolder.OrdenItemListener
) : RecyclerView.Adapter<HistoryItemViewHolder>() {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryItemViewHolder {
    val view = LayoutInflater.from(parent.context)
      .inflate(R.layout.list_row, parent, false)
    return HistoryItemViewHolder(view, listener)
  }

  override fun getItemCount(): Int {
    return ordenes.size
  }

  override fun onBindViewHolder(holder: HistoryItemViewHolder, position: Int) {
    holder.bindData(ordenes[position])
  }

}