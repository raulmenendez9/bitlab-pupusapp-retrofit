package sv.edu.bitlab.pupusap.Relleno

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

class ApiService {
  companion object{
    fun create(): PupusasApiService {

      val httpClient = OkHttpClient.Builder().readTimeout(30, TimeUnit.SECONDS).connectTimeout(10, TimeUnit.SECONDS)

      val logging = HttpLoggingInterceptor()
      logging.setLevel(HttpLoggingInterceptor.Level.BODY)
      httpClient.addInterceptor(logging)


      val retrofit =Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl("https://pupusapp-api.herokuapp.com/").client(httpClient.build()).build()

      return retrofit.create(PupusasApiService::class.java)
    }
  }
}