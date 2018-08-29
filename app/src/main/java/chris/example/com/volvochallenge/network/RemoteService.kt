package chris.example.com.volvochallenge.network

import chris.dev.com.volvochallenge.model.WeatherResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface RemoteService
{
    @GET("api/location/{id}/")
    fun getWeather(@Path("id") id: String): Observable<WeatherResponse>
}