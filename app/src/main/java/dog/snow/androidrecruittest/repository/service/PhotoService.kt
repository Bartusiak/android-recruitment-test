package dog.snow.androidrecruittest.repository.service

import dog.snow.androidrecruittest.repository.model.RawPhoto
import dog.snow.androidrecruittest.ui.model.PhotosListItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PhotoService {

    @GET("photos")
    fun getAllPhotos(@Query("limit") limit:Int=100): Call<List<PhotosListItem>>


}