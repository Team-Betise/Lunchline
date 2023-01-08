package com.betise_lunchline_client.app.modules

import android.annotation.SuppressLint
import com.google.firebase.Timestamp
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FieldValue
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
        val ETA: Timestamp,
    )
    data class Item(
        val dish: Dish,
        var EndTime: Timestamp,
        var Status: String,
    )
    data class ItemDB(
        val Item: DocumentReference,
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
        val User: DocumentReference,
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
        var dish_ids:MutableList<String> = mutableListOf<String>()
        var cart:HashMap<Int, Int> = hashMapOf()
        var order: Order? = null
        var orderDB: OrderDB? = null
    }

}