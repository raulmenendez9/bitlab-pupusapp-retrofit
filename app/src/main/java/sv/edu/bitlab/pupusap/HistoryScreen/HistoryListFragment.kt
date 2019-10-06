package sv.edu.bitlab.pupusap.HistoryScreen

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import sv.edu.bitlab.pupusap.HistoryScreen.HistoryRecyclerView.HistoryItemViewHolder
import sv.edu.bitlab.pupusap.HistoryScreen.HistoryRecyclerView.OrdenAdapter
import sv.edu.bitlab.pupusap.Models.Orden
import sv.edu.bitlab.pupusap.Models.OrdenPupusas
import sv.edu.bitlab.pupusap.Models.TakenOrden

import sv.edu.bitlab.pupusap.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ORDERS_LIST = "ORDERS_LIST"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [HistoryListFragment.HistoryListFragmentListener] interface
 * to handle interaction events.
 * Use the [HistoryListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HistoryListFragment : Fragment(), HistoryItemViewHolder.OrdenItemListener {

  // TODO: Rename and change types of parameters
  private var orderLists = ArrayList<Orden>()
  private var listener: HistoryListFragmentListener? = null
  private var listView: RecyclerView? = null
  private var inflater: LayoutInflater? = null
 val detalle= ArrayList<Orden>()
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    orderLists = arguments!!.getParcelableArrayList<Orden>(ORDERS_LIST)!!

    arguments?.let {
      orderLists = it.getParcelableArrayList<Orden>(ORDERS_LIST)!!
    }
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    this.inflater = inflater
    return inflater.inflate(R.layout.fragment_history_list, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    listView = view.findViewById(R.id.ordersListView)
    listView!!.layoutManager = LinearLayoutManager(this.context)
    listView!!.adapter = OrdenAdapter(orderLists, listener = this)

  }

  // TODO: Rename method, update argument and hook method into UI event
  fun onButtonPressed(uri: Uri) {
    listener?.onFragmentInteraction(uri)
  }

  override fun onAttach(context: Context) {
    super.onAttach(context)
    if (context is HistoryListFragmentListener) {
      listener = context
    } else {
      throw RuntimeException(context.toString() + " must implement HistoryListFragmentListener")
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
  interface HistoryListFragmentListener {
    fun onItemClicked(detalle: ArrayList<Orden>,position: Int)
    fun onFragmentInteraction(uri: Uri)
  }

  //region OrdenAdapter.OrdenItemListener methods

  override fun onOrdenarDenuevoClick(orden: TakenOrden) {
    Log.d("HISTORY_FRGAMENT", "Click para agregar nueva orden")
  }

  override fun onItemClick(position: Int) {
    listener!!.onItemClicked(detalle,position)
  }


  override fun onTextInput(input: String, position: Int) {
   // orderLists[position].textInput = input
    listView!!.adapter!!.notifyDataSetChanged()
  }

  //endregion


  companion object {
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HistoryListFragment.
     */
    // TODO: Rename and change types and number of parameters

    // Equivalencia en programacion estructurada
  /*  val params = Bundle()
    params.putParcelableArrayList(ORDERS_LIST, orderList)
    val fragment = HistoryListFragment()
    fragment.arguments = params
    return fragment*/
    @JvmStatic
    fun newInstance(orderList: ArrayList<Orden>) : HistoryListFragment {
      val params = Bundle()
      params.putParcelableArrayList(ORDERS_LIST,orderList)
      val fragment = HistoryListFragment()
      fragment.arguments = params
      return fragment
    }
  }
}
