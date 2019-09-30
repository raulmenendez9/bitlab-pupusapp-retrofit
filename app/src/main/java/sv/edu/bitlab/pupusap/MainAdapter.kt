package sv.edu.bitlab.pupusap

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import sv.edu.bitlab.pupusap.Models.Relleno

class MainAdapter(var rellenos: List<Relleno>, val listener: MainViewHolder.MainItemListener): RecyclerView.Adapter<MainViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
    val v = LayoutInflater.from(parent.context).inflate(R.layout.lisrt_row, parent, false)
    return MainViewHolder(v,listener)

  }

  override fun getItemCount(): Int {
    return rellenos.size
  }


  override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

    holder.bindItems(rellenos[position])


  }
}

