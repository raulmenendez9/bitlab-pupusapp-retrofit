package sv.edu.bitlab.pupusap.Relleno

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import sv.edu.bitlab.pupusap.Models.Orden
import sv.edu.bitlab.pupusap.Models.Relleno
import sv.edu.bitlab.pupusap.Models.TakenOrden

interface PupusasApiService{
  @GET("rellenos/")
  fun getRellenos(): Call<List<Relleno>>

  @GET("ordens/")
  fun getOrdenes(): Call<ArrayList<Orden>>

  @POST("orden/")
  fun submitOrden(@Body params: TakenOrden, @Path("id") id:Int): Call<Orden>
}