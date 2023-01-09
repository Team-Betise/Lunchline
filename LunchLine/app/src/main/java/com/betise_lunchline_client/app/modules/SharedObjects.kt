package com.betise_lunchline_client.app.modules

import android.annotation.SuppressLint
import com.google.firebase.Timestamp
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.local.ReferenceSet
import com.google.firebase.ktx.Firebase
import java.sql.Time

class SharedObjects {
    data class User(
        val name: String,
        val email: String,
        val photo: String,
        val phone: String,
        val profile: String,
        val openID: String,
    )
    data class Dish(
        val itemName: String,
        val itemCost: Long,
        val desc: String,
        val currentAvailability: Boolean,
        val rating: Double,
        val reviewCount: Long,
        val startTime: Timestamp,
        val endTime: Timestamp,
        val days: ArrayList<Boolean>,
        val eta: Timestamp,
    )
    data class Item(
        val dish: Dish,
        var endTime: Timestamp,
        var status: String,
    )
    data class ItemDB(
        val item: DocumentReference,
        var endTime: Timestamp,
        var status: String,
    )
    // Order class to use in the app
    data class Order(
        var status: String,
        val amount: Long,
        var itemsRemaining: Long,
        var items: ArrayList<Item>,
        val timePlaced: Timestamp,
        val verificationCode: String,
    )
    // Order class to use to add orders to DB
    data class OrderDB(
        val user: DocumentReference,
        val amount: Long,
        var itemsRemaining: Long,
        var status: String,
        val timePlaced: Timestamp,
        var verificationCode: String,
    )
    companion object{
        @SuppressLint("StaticFieldLeak")
        val db = Firebase.firestore
        var user_email: String = ""
        val menuCollection = db.collection("vendors").document("pqCOEjacUXj6r5KM7fEL").collection("menu")
        var dishes:MutableList<Dish> = mutableListOf<Dish>()
        var dish_ids:MutableList<String> = mutableListOf<String>()
        var cart:HashMap<Dish, Int> = hashMapOf()
        // var cart:HashMap<Int, Int> = hashMapOf()
        var order: Order? = null
        var orderDB: OrderDB? = null
    }

}