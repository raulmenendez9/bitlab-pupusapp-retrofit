package sv.edu.bitlab.pupusap.HistoryScreen.HistoryRecyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sv.edu.bitlab.pupusap.Models.Orden
import sv.edu.bitlab.pupusap.R

class OrdenAdapter(var orden: List<Orden>,
                   val listener: HistoryItemViewHolder.OrdenItemListener
) : RecyclerView.Adapter<HistoryItemViewHolder>() {
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryItemViewHolder {
    val view = LayoutInflater.from(parent.context)
      .inflate(R.layout.list_row, parent, false)
    return HistoryItemViewHolder(view, listener)
  }

  override fun getItemCount(): Int {
    return orden.size
  }

  override fun onBindViewHolder(holder: HistoryItemViewHolder, position: Int) {
    holder.bindData(orden[position])
  }

}