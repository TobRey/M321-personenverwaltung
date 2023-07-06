package com.example.personing

import android.app.Application
import android.telecom.Call
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.personing.model.Person
import com.example.personing.model.Type
import com.example.personing.retrofit.PersonService
import okhttp3.Callback
import okhttp3.Response

class PersonEditViewModel(application: Application) : AndroidViewModel(application) {

    private val apiClient = apiCLIENT.getClient().create(PersonService::class.java)
    var types = MutableLiveData<List<Type>>(listOf<Type>())
    var saveSuccessful = MutableLiveData<Boolean?>()
    var person = MutableLiveData<Person?>()
    var data = mutableMapOf<String, String>()
    var type: Type? = null

    fun save(): Boolean {
        if (data.containsKey("firstname") && data.containsKey("lastname") && type != null) {
            val newPerson = Person(
                0,
                data["firstname"]!!,
                data["lastname"]!!,
                false,
                PersoningApp.getInstance().loggedInUser!!, type!!
            )

            apiClient.createPerson(PersoningApp.getInstance().getAuthorization(), newPerson)
                .enqueue(object : Callback<Person?>)
                {
                    override fun onResponse(
                        call: Call<Person?>,
                        response: Response<Person?>
                    ) {
                        if (response.code() == 200) {
                            person.postValue(response.body())
                            saveSuccessful.postValue(true)
                        } else {
                            saveSuccessful.postValue(false)
                        }
                    }
                }
        }
    }


    fun loadTypes()
    {
        apiClient.getTypes(PersoningApp.getInstance().getAuthorization()).enqueue(object:
            Callback<List<Type>> {
               override fun onResponse(call: Call<List<Type>>, response: Response<List<Type>>) {
                   if( response.code() == 200 ){
                       types.postValue(response.body())
                   } else {

                   }
               }
           })
    }


}
