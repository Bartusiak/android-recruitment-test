package dog.snow.androidrecruittest

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.postDelayed
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dog.snow.androidrecruittest.repository.model.RawPhoto
import dog.snow.androidrecruittest.repository.service.PhotoService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SplashActivity : AppCompatActivity(R.layout.splash_activity) {
    private val SPLASH_TIME_OUT = 1000;

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
/*
        val retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(PhotoService::class.java)

        api.fetchAllPhotos().enqueue(object : Callback<List<RawPhoto>> {
            override fun onResponse(call: Call<List<RawPhoto>>, response: Response<List<RawPhoto>>){

            }

            override fun onFailure(call: Call<List<RawPhoto>>, t: Throwable) {
                showError(t.message)
            }
        })
*/
        Handler().postDelayed(object:Runnable{
            public override fun run(){
                val intent = Intent(this@SplashActivity,MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        },SPLASH_TIME_OUT.toLong())
    }


}