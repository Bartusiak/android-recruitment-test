package dog.snow.androidrecruittest.repository.service

import dog.snow.androidrecruittest.repository.model.RawPhoto
import retrofit2.Call
import retrofit2.http.GET

interface PhotoService {

    @GET("photos")
    fun fetchAllPhotos(): Call<List<RawPhoto>>

}