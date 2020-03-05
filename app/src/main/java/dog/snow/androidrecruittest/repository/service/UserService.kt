package dog.snow.androidrecruittest.repository.service

import dog.snow.androidrecruittest.repository.model.RawUser
import retrofit2.Call
import retrofit2.http.GET

interface UserService {

    @GET("users")
    fun fetchAllUsers(): Call<List<RawUser>>
}