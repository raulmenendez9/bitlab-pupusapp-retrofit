package sv.edu.bitlab.pupusap.DetalleOrden

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sv.edu.bitlab.pupusap.HistoryScreen.HistoryActivity
import sv.edu.bitlab.pupusap.Models.Orden
import sv.edu.bitlab.pupusap.R
import sv.edu.bitlab.pupusap.Relleno.ApiService
import java.text.DecimalFormat

class  DetalleOrdeActivity : AppCompatActivity(), DetalleOrdeViewHolder.DetalleListener{



  var maiz= arrayListOf<Int>()
  var arroz = arrayListOf<Int>()


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.detalle_orden_activity)


    var recyclerDetalle = findViewById<RecyclerView>(R.id.recyclerDetalle)
    recyclerDetalle.layoutManager = LinearLayoutManager(this)
    recyclerDetalle.adapter = DetalleOrdeAdapter(arrayListOf<Orden>(), listener = this)

    ApiService.create().getOrdenes().enqueue(object : Callback<List<Orden>>{
      override fun onFailure(call: Call<List<Orden>>, t: Throwable) {
        AlertDialog.Builder(getContent())
          .setTitle("ERROR")
          .setMessage("Error con el servidor lo sentimos")
          .setNeutralButton("ok", null)
          .create()
          .show()
      }

      override fun onResponse(call: Call<List<Orden>>, response: Response<List<Orden>>) {
        val ordenes = response.body()!!
        val adapter = recyclerDetalle.adapter as DetalleOrdeAdapter
        adapter.orden = ordenes
        adapter.notifyDataSetChanged()

      }

    })
    /*var total = 0.0f
    Toast.makeText(this, "onCreate()", Toast.LENGTH_LONG).show()
    val params = this.intent.extras
     maiz = params!!.getIntegerArrayList(CONTADOR_MAIZ)!!
     arroz =params.getIntegerArrayList(CONTADOR_ARROZ)!!
    val arreglo = maiz + arroz

    for (cont in arreglo){
      var totales = cont* VALOR_PUPUSA
      total +=totales
    }
    ///////
    var totalPrecio = findViewById<TextView>(R.id.lineItemPriceTotal)
    var precio = DecimalFormat("$#0.00").format(total)
    totalPrecio.text=precio
    //////

    val recyclerView : RecyclerView = findViewById(R.id.recyclerDetalle)
    recyclerView.layoutManager= LinearLayoutManager(this, RecyclerView.VERTICAL,false)


    var adapter = DetalleOrdeAdapter(arreglo as ArrayList<Int>, this)
    recyclerView.adapter=adapter*/
  }

  /*fun addFragment() {
    val fragment = OrdenDetalleFragment.newInstance(this.orden)
    val builder = supportFragmentManager
      .beginTransaction()
      .add(
        R.id.pruebaFragmentContainer, fragment,
        FRAGMENT_TAG
      )
    builder.commit()
  }*/
  fun getContent(): Context {
    return this
  }


  override fun displayDetalle(detalle: TextView, precio: TextView, contador: Int, index: Int) {
    var total = 0.0f
    if (contador>0){
      val total2 = contador* VALOR_PUPUSA
      val descrip = getDescripcion(index)
      detalle.text = getString(R.string.pupusa_line_item_description, contador, descrip)
      total += total2
      val precio2 =DecimalFormat("$#0.00").format(total2)
     precio.text = precio2

    }else{
      detalle.visibility = View.GONE
      precio.visibility = View.GONE
    }

  }

  fun getDescripcion(index: Int):String{
    return when(index){
      QUESO_MAIZ->"Q M"
      FRIJOLES_MAIZ-> "FQ M"
      REVUELTAS_MAIZ-> "R M"
      AYOTE_MAIZ->"AY M"
      LOROCO_MAIZ->"L M"
      CHIPILIN_MAIZ->"CH M"
      QUESO ->"Q ARR"
      FRIJOLES->"FQ ARR"
      REVUELTAS->"R ARR"
      AYOTE-> "AY ARR"
      LOROCO-> "L ARR"
      CHIPILIN-> "CH ARR"

      else -> throw RuntimeException("Pupusa no soportada")
    }
  }

  companion object {
    const val QUESO_MAIZ = 0//3
    const val FRIJOLES_MAIZ = 1//4
    const val REVUELTAS_MAIZ = 2//5
    const val AYOTE_MAIZ = 3
    const val LOROCO_MAIZ = 4
    const val CHIPILIN_MAIZ = 5
    const val QUESO = 6
    const val FRIJOLES = 7
    const val REVUELTAS = 8
    const val AYOTE =9
    const val LOROCO =10
    const val CHIPILIN =11
    const val CONTADOR_MAIZ = "MAIZ"
    const val CONTADOR_ARROZ = "ARROZ"
    const val VALOR_PUPUSA = 0.5F
    const val FRAGMENT_TAG = "FRAGMENT_TAG"
  }
}
