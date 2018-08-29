package chris.example.com.volvochallenge.network

import chris.dev.com.volvochallenge.model.WeatherResponse
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RemoteDataSource(private val baseURL: String)
{
    private fun create(): Retrofit
    {

        return Retrofit.Builder().baseUrl(baseURL)
                //add converter to parse the response
                .addConverterFactory(GsonConverterFactory.create())
                //add call adapter to convert the response to RxJava observable
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()
    }

    fun getWeather(id: String): Observable<WeatherResponse>
    {
        val retrofit = create()
        val remoteService = retrofit.create(RemoteService::class.java)
        return remoteService.getWeather(id)
    }
}