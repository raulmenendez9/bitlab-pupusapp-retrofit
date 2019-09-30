package sv.edu.bitlab.pupusap

import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import sv.edu.bitlab.pupusap.Models.Relleno
import sv.edu.bitlab.pupusap.Models.TakenOrden

class MainViewHolder (itemView: View, val listener: MainItemListener): RecyclerView.ViewHolder(itemView){
  val orden = TakenOrden()
  var botonesMaiz = hashMapOf<String, Button>()
  var botonesArroz = hashMapOf<String, Button>()


  fun bindItems(relleno: Relleno){

    var relleno1: Button = itemView.findViewById(R.id.masaMaiz)
    var relleno2: Button = itemView.findViewById(R.id.masaArroz)

    relleno1.text= relleno.nombre
    relleno2.text= relleno.nombre

    /*botonesMaiz= hashMapOf(
      data to relleno1!!
    )
    botonesArroz= hashMapOf(
      datas to relleno2!!
    )*/

      relleno1.setOnClickListener{
        //listener.displayCounters(botonesMaiz)
       listener.addMaiz(relleno.nombre)
      }
      relleno2.setOnClickListener{
        //listener.displayCounters(botonesArroz)
        listener.addArroz(relleno.nombre)
      }



  }
  interface MainItemListener {
    fun displayCounters(relleno: String, masa: String)
    fun addMaiz(relleno: String)
    fun addArroz(relleno: String)
  }


}

