package com.betise_lunchline_client.app.modules

import android.annotation.SuppressLint
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SharedObjects {
    data class User(
        val Name: String,
        val Email: String,
        val Photo: String,
        val Phone: String,
        val Profile: String,
        val OpenID: String,
    )
    companion object{
        @SuppressLint("StaticFieldLeak")
        val db = Firebase.firestore
    }

}