package dog.snow.androidrecruittest

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
import android.os.Handler
import android.provider.ContactsContract
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dog.snow.androidrecruittest.repository.service.AlbumService
import dog.snow.androidrecruittest.repository.service.PhotoService
import dog.snow.androidrecruittest.repository.service.UserService
import dog.snow.androidrecruittest.ui.dao.AlbumsDatabase
import dog.snow.androidrecruittest.ui.dao.PhotosDatabase
import dog.snow.androidrecruittest.ui.dao.UsersDatabase
import dog.snow.androidrecruittest.ui.model.AlbumsListItem
import dog.snow.androidrecruittest.ui.model.PhotosListItem
import dog.snow.androidrecruittest.ui.model.UsersListItem
import io.reactivex.CompletableObserver
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.internal.util.HalfSerializer.onError
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.layout_banner.view.*
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class SplashActivity : AppCompatActivity(R.layout.splash_activity){
    private val SPLASH_TIME_OUT = 1000;

    val okHttpClient = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply{
        level=HttpLoggingInterceptor.Level.BODY
    }).build()

    private fun showError(errorMessage: String?) {
        MaterialAlertDialogBuilder(this)
            .setTitle(R.string.cant_download_dialog_title)
            .setMessage(getString(R.string.cant_download_dialog_message, errorMessage))
            .setPositiveButton(R.string.cant_download_dialog_btn_positive) { _, _ -> /*tryAgain()*/ }
            .setNegativeButton(R.string.cant_download_dialog_btn_negative) { _, _ -> finish() }
            .create()
            .apply { setCanceledOnTouchOutside(false) }
            .show()
    }

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState);
        var database_photos= Room
            .databaseBuilder(applicationContext, PhotosDatabase::class.java, "photos")
            .build()

        var database_albums = Room
            .databaseBuilder(applicationContext,AlbumsDatabase::class.java,"albums")
            .build()

        var database_users = Room
            .databaseBuilder(applicationContext,UsersDatabase::class.java,"users")
            .build()


        val retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .client(okHttpClient)
            .build()

        val apiphotos = retrofit.create(PhotoService::class.java)
        val apialbums = retrofit.create(AlbumService::class.java)
        val apiusers = retrofit.create(UserService::class.java)


        apiphotos.getAllPhotos().observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(onNext = {
                database_photos.photosDao().insertAllPhotos(it)
            },onError = {
                showError(it.message);
            })

        apialbums.getAllAlbums().observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(onNext = {
                database_albums.albumsDao().insertAllAlbums(it)
            },onError = {
                showError(it.message)
            })

        apiusers.getAllUsers().observeOn(AndroidSchedulers.mainThread())
            .subscribeBy(onNext = {
                database_users.usersDao().insertAllUsers(it)
            },onError = {
                showError(it.message)
            })



        /*apiphotos.getAllPhotos().observeOn(AndroidSchedulers.mainThread()).subscribeOn(Schedulers.io()).subscribe(
             CompletableObserver() {
                 override fun onSubscribe(Disposable d) {

                 }

             })*/

        /*apiphotos.getAllPhotos().enqueue(object : Callback<List<PhotosListItem>> {
            override fun onResponse(call: Call<List<PhotosListItem>>, response: Response<List<PhotosListItem>>
            ) {
                response.body()?.let { database_photos.photosDao().insertAllPhotos(it) }
            }
            override fun onFailure(call: Call<List<PhotosListItem>>, t: Throwable) {
                val msg = showError(t.message)
                Log.d("Splash: onFail..", msg.toString())
            }
        })

        apialbums.getAllAlbums().enqueue(object : Callback<List<AlbumsListItem>>{
            override fun onResponse(call: Call<List<AlbumsListItem>>, response: Response<List<AlbumsListItem>>
            ) {
                response.body()?.let { database_albums.albumsDao().insertAllAlbums(it) }
            }
            override fun onFailure(call: Call<List<AlbumsListItem>>, t: Throwable) {
                val msg = showError(t.message)
                Log.d("Splash: onFail..",msg.toString())
            }
        })

        apiusers.getAllUsers().enqueue(object : Callback<List<UsersListItem>>{
            override fun onResponse(call: Call<List<UsersListItem>>, response: Response<List<UsersListItem>>
            ) {
                response.body()?.let { database_users.usersDao().insertAllUsers(it) }
            }
            override fun onFailure(call: Call<List<UsersListItem>>, t: Throwable) {
                val msg = showError(t.message)
                Log.d("Splash: onFail...",msg.toString())
            }
        })*/

        Handler().postDelayed(object:Runnable{
            public override fun run(){
                val intent = Intent(this@SplashActivity,MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        },SPLASH_TIME_OUT.toLong())

    }

    /*fun hasNetwork(context: Context): Boolean? {
        var isConnected: Boolean? = false
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        if (activeNetwork != null && activeNetwork.isConnected)
            isConnected=true
        return isConnected
    }*/

}