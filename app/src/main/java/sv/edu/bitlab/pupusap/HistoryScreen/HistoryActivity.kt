package sv.edu.bitlab.pupusap.HistoryScreen

import android.content.Context
import android.content.res.Configuration
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import sv.edu.bitlab.pupusap.Models.Orden
import sv.edu.bitlab.pupusap.Models.OrdenPupusas
import sv.edu.bitlab.pupusap.OrdenDetalleFragment
import sv.edu.bitlab.pupusap.R
import sv.edu.bitlab.pupusap.Relleno.ApiService

class HistoryActivity : AppCompatActivity(), HistoryListFragment.HistoryListFragmentListener,
  OrdenDetalleFragment.OrdenDetalleFragmentListener {

  private var page =0

  private lateinit var ordenes: ArrayList<Orden>
  override fun onFragmentInteraction(uri: Uri) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
//    ordenes =savedInstanceState!!.getParcelableArrayList("HISTORIAL_DE_ORDENES")!!

    if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
      setContentView(R.layout.activity_history_landscape)
      initLandsacpe()
    } else {
      setContentView(R.layout.activity_history_portrait)
      initPortrait()
    }
  }
    fun initLandsacpe(){
      loadListFragment(R.id.listContainer)
    }

    fun initPortrait(){
      loadListFragment(R.id.fragmentContainer)
    }

    fun loadListFragment(containerID: Int) {
      ApiService.create().getOrdenes().enqueue(object : Callback<ArrayList<Orden>> {
        override fun onFailure(call: Call<ArrayList<Orden>>, t: Throwable) {
          AlertDialog.Builder(getContent())
            .setTitle("ERROR")
            .setMessage("Error con el servidor lo sentimos")
            .setNeutralButton("ok", null)
            .create()
            .show()
        }

        override fun onResponse(call: Call<ArrayList<Orden>>, response: Response<ArrayList<Orden>>) {
          val ordenes = response.body()!!
          val fragment = HistoryListFragment.newInstance(ordenes)
          val builder = supportFragmentManager
            .beginTransaction()
            .replace(containerID, fragment, "ORDENES_HISTORY")
            .addToBackStack("ORDENES_HISTORY")
          builder.commitAllowingStateLoss()
          // val adapter = recyclerDetalle.adapter as DetalleOrdeAdapter
          //adapter.orden = ordenes
          //adapter.notifyDataSetChanged()

        }

      })


    }

   fun loadDetailFragment(containerID: Int, orden: ArrayList<OrdenPupusas>) {
         val fragment = OrdenDetalleFragment.newInstance(orden)
         val builder = supportFragmentManager
           .beginTransaction()
           .replace(containerID, fragment, "DETAIL_FRAGMENT_TAG")
           .addToBackStack("DETAIL_FRAGMENT_TAG")
         builder.commitAllowingStateLoss()
    }
  override fun onSaveInstanceState(outState: Bundle) {
    super.onSaveInstanceState(outState)
    outState.putParcelableArrayList("HISTORIAL_DE_ORDENES", ordenes)
  }

  override fun onItemClicked(position: Int) {
    ApiService.create().getOrdenes().enqueue(object : Callback<ArrayList<Orden>> {
      override fun onFailure(call: Call<ArrayList<Orden>>, t: Throwable) {
        AlertDialog.Builder(getContent())
          .setTitle("ERROR")
          .setMessage("Error con el servidor lo sentimos")
          .setNeutralButton("ok", null)
          .create()
          .show()
      }

      override fun onResponse(call: Call<ArrayList<Orden>>, response: Response<ArrayList<Orden>>) {
        val ordens = response.body()!!
        var orden = ordens[position].arroz + ordens[position].maiz
        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
          loadDetailFragment(R.id.detailContainer, orden as ArrayList<OrdenPupusas>)
        } else {
          loadDetailFragment(R.id.fragmentContainer, orden as ArrayList<OrdenPupusas>)
          page ++
        }

      }

    })

  }

   /* setContentView(R.layout.activity_history)
    val ordenes = TakenOrden.randomOrders()
    val fragment = HistoryListFragment.newInstance(ordenes)
    val builder = supportFragmentManager
      .beginTransaction()
      .add(R.id.listContainer, fragment, "ORDENES_HISTORY")
      .addToBackStack("ORDENES_HISTORY")
    builder.commitAllowingStateLoss()*/
   fun getContent(): Context {
     return this
   }

  override fun onBackPressed() {
    if (page > 0){
      page --
      super.onBackPressed()
    }else{
      finish()

    }
  }
  companion object {
    const val LIST_FRAGMENT_TAG = "ORDENES_HISTORY"
    const val DETAIL_FRAGMENT_TAG = "DETAIL_FRAGMENT_TAG"
    const val FRAGMENT_TAG = "ORDENES_HISTORY"
  }
  }


