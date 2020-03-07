package dog.snow.androidrecruittest.repository.service

import dog.snow.androidrecruittest.repository.model.RawUser
import dog.snow.androidrecruittest.ui.model.UsersListItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface UserService {

    @GET("users")
    fun getAllUsers(@Query("id")id:UsersListItem): Call<List<UsersListItem>>
}