package com.example.personing.ui.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.personing.PersoningApp
import com.example.personing.model.User
import com.example.personing.retrofit.APIClient
import com.example.personing.retrofit.PersonService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel(application: Application): AndroidViewModel(application) {
    private val apiClient = APIClient.getClient().create(PersonService::class.java)

    fun login( email: String, password: String ): Boolean
    {
        var success = false
        val data = mapOf(
            "email" to email,
            "password" to password
        )

        apiClient.login(data).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                PersoningApp.getInstance().loggedInUser = response.body()
                success = true
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                success = false
            }

        })

        return success
    }
}