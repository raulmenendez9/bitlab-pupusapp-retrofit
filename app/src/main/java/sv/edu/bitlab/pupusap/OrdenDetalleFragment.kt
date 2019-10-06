package sv.edu.bitlab.pupusap

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import sv.edu.bitlab.pupusap.DetalleOrden.DetalleOrdeAdapter
import sv.edu.bitlab.pupusap.DetalleOrden.DetalleOrdeViewHolder
//import sv.edu.bitlab.pupusap.HistoryScreen.VARIABLE
import sv.edu.bitlab.pupusap.Models.Orden
import sv.edu.bitlab.pupusap.Models.OrdenPupusas


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [OrdenDetalleFragment.OrdenDetalleFragmentListener] interface
 * to handle interaction events.
 * Use the [OrdenDetalleFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class OrdenDetalleFragment : Fragment(), DetalleOrdeViewHolder.DetalleListener {
  override fun displayDetalle(detalle: TextView, precio: TextView, contador: Int, index: Int) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  // TODO: Rename and change types of parameters
   private lateinit var maiz: ArrayList<OrdenPupusas>
  private lateinit var arroz: ArrayList<OrdenPupusas>
  private var reorder:Boolean = false
  private var orderLists = arrayListOf<OrdenPupusas>()

  private var listener: OrdenDetalleFragmentListener? = null
  private var listView: RecyclerView? = null
  private lateinit var detalle:List<Orden>
  private lateinit var rellenoMaiz: String
  private lateinit var rellenoArroz: String

  override fun onCreate(savedInstanceState: Bundle?) {
   // VARIABLE
    super.onCreate(savedInstanceState)
    /*orderLists = arguments!!.getParcelableArrayList<OrdenPupusas>(ORDEN)!!
    arguments?.let {
      maiz = it.getParcelableArrayList<OrdenPupusas>(ORDEN)!!
      //arroz=it.getParcelableArrayList<OrdenPupusas>("ARROZ")!!
     orderLists = maiz
     // reorder = it.getBoolean(REORDER, false)
    }*/
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.detalle_orden_activity, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    listView = view.findViewById(R.id.recyclerDetalle)
    listView!!.layoutManager = LinearLayoutManager(this.context)
    listView!!.adapter = DetalleOrdeAdapter(detalle,rellenoMaiz,rellenoArroz, listener = this)
  }

  override fun onAttach(context: Context) {
    super.onAttach(context)
    if (context is OrdenDetalleFragmentListener) {
      listener = context
    } else {
      throw RuntimeException(context.toString() + " must implement OrdenDetalleFragmentListener")
    }
  }

  override fun onDetach() {
    super.onDetach()
    listener = null
  }

  /**
   * This interface must be implemented by activities that contain this
   * fragment to allow an interaction in this fragment to be communicated
   * to the activity and potentially other fragments contained in that
   * activity.
   *
   *
   * See the Android Training lesson [Communicating with Other Fragments]
   * (http://developer.android.com/training/basics/fragments/communicating.html)
   * for more information.
   */
  interface OrdenDetalleFragmentListener {
    // TODO: Update argument type and name
    fun onFragmentInteraction(uri: Uri)
    //fun funcionConDevulicion() : Int
  }

  companion object {
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param orden Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OrdenDetalleFragment.
     */
    // TODO: Rename and change types and number of parameters

    @JvmStatic
    fun newInstance(detalle:List<Orden>, rellenoMaiz:String, rellenoArroz:String): OrdenDetalleFragment {
      val params =Bundle()
      val fragment = OrdenDetalleFragment()
      fragment.detalle=detalle
      fragment.rellenoMaiz=rellenoMaiz
      fragment.rellenoArroz=rellenoArroz
      return fragment
      }
  }
}
