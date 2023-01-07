package com.betise_lunchline_client.app.modules

import android.annotation.SuppressLint
import androidx.annotation.Keep
import com.google.firebase.Timestamp
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
    data class Dish(
        val ItemName: String,
        val ItemCost: Long,
        val Desc: String,
        val CurrentAvailability: Boolean,
        val Rating: Double,
        val StartTime: Timestamp,
        val EndTime: Timestamp,
        val Days: ArrayList<Boolean>,
    )
    companion object{
        @SuppressLint("StaticFieldLeak")
        val db = Firebase.firestore
        val menuCollection = db.collection("vendors").document("pqCOEjacUXj6r5KM7fEL").collection("menu")
        val dishes:MutableList<Dish> = mutableListOf<Dish>()
    }

}