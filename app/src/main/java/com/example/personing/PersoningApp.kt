package com.example.personing

import com.example.personing.model.User

class PersoningApp {
    fun getAuthorization() {

    }

    var loggedInUser: User? = null

    companion object {
        @Volatile private var instance: PersoningApp? = null

        fun getInstance(): PersoningApp {
            if( instance == null )
            {
                instance = PersoningApp()
            }

            return instance as PersoningApp
        }
    }

}