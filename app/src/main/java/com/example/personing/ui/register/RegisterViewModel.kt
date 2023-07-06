package com.example.personing.ui.register

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.personing.retrofit.APIClient
import com.example.personing.retrofit.PersonService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterViewModel(application: Application) : AndroidViewModel(application) {

    private val apiClient = APIClient.getClient().create(PersonService::class.java)
    val data = mutableMapOf<String, String>()

    fun register(): Boolean
    {
        var success = false
        apiClient.register(data).enqueue(object : Callback<Boolean> {
            override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
                success = true
            }

            override fun onFailure(call: Call<Boolean>, t: Throwable) {
                success = false
            }
        })

        return success
    }
}