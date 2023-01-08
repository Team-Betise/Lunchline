package com.betise_lunchline_client.app.modules

import android.annotation.SuppressLint
import androidx.annotation.Keep
import com.google.firebase.Timestamp
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.local.ReferenceSet
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
    data class Item(
        val dish: Dish,
        val EndTime: Timestamp,
        val Status: String,
    )
    // Order class to use in the app
    data class Order(
        val Status: String,
        val Amount: Long,
        val ItemsRemaining: Long,
        val Items: ArrayList<Item>,
        val TimePlaced: Timestamp,
        val VerificationCode: String,
    )
    // Order class to use to add orders to DB
    data class OrderDB(
        val User: ReferenceSet,
        val Amount: Long,
        val ItemsRemaining: Long,
        val Status: String,
        val TimePlaced: Timestamp,
        val VerificationCode: String,
    )
    companion object{
        @SuppressLint("StaticFieldLeak")
        val db = Firebase.firestore
        val user_email: String = ""
        val menuCollection = db.collection("vendors").document("pqCOEjacUXj6r5KM7fEL").collection("menu")
        val dishes:MutableList<Dish> = mutableListOf<Dish>()
    }

}