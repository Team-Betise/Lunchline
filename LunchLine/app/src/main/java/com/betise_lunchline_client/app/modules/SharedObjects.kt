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
        val ReviewCount: Long,
        val StartTime: Timestamp,
        val EndTime: Timestamp,
        val Days: ArrayList<Boolean>,
    )
    data class Item(
        val dish: Dish,
        var EndTime: Timestamp,
        var Status: String,
    )
    // Order class to use in the app
    data class Order(
        var Status: String,
        val Amount: Long,
        var ItemsRemaining: Long,
        var Items: ArrayList<Item>,
        val TimePlaced: Timestamp,
        val VerificationCode: String,
    )
    // Order class to use to add orders to DB
    data class OrderDB(
        val User: ReferenceSet,
        val Amount: Long,
        var ItemsRemaining: Long,
        var Status: String,
        val TimePlaced: Timestamp,
        var VerificationCode: String,
    )
    companion object{
        @SuppressLint("StaticFieldLeak")
        val db = Firebase.firestore
        var user_email: String = ""
        val menuCollection = db.collection("vendors").document("pqCOEjacUXj6r5KM7fEL").collection("menu")
        var dishes:MutableList<Dish> = mutableListOf<Dish>()
    }

}