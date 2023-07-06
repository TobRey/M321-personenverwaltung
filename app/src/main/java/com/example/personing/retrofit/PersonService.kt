package com.example.personing.retrofit

import com.example.personing.model.Person
import com.example.personing.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface PersonService {

    @POST("/login")
    fun login(@Body data: Map<String, String>): Call<User>

    @POST("/users")
    fun register(@Body data: Map<String, String>): Call<Boolean>

    @POST("/persons")
    fun createPerson(@Header("Authorization") jwtToken: String): Call<Person<Any?>>

    @GET("/persons")
    fun getPersons(@Header("Authorization") jwtToken: String): Call<List<Person<Any?>>>

    @GET("/persons/{personId}")
    fun getPerson(@Path("personId") ticketId: Long): Call<Person<Any?>>

    @PUT("/persons/{personId}")
    fun updatePerson(@Header("Authorization") jwtToken: String, @Path("personId") personId: Long, @Body person: Person<Any?>): Call<Person<Any?>>

    @DELETE("/persons/{personId}")
    fun deletePerson(@Header("Authorization") jwtToken: String, @Path("personId") personId: Long): Call<Boolean>

}