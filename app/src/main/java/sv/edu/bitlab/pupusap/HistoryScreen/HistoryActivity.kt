package sv.edu.bitlab.pupusap.HistoryScreen

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import sv.edu.bitlab.pupusap.Models.TakenOrden
import sv.edu.bitlab.pupusap.R

class HistoryActivity : AppCompatActivity(), HistoryListFragment.HistoryListFragmentListener {
  override fun onFragmentInteraction(uri: Uri) {
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_history)
    val ordenes = TakenOrden.randomOrders()
    val fragment = HistoryListFragment.newInstance(ordenes)
    val builder = supportFragmentManager
      .beginTransaction()
      .add(R.id.listContainer, fragment, FRAGMENT_TAG)
      .addToBackStack(FRAGMENT_TAG)
    builder.commitAllowingStateLoss()
  }

  companion object{
    const val FRAGMENT_TAG = "ORDENES_HISTORY"
  }
}
