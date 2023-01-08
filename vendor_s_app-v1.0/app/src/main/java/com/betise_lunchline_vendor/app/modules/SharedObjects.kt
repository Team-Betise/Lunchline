package com.betise_lunchline_vendor.app.modules

import android.annotation.SuppressLint
import com.google.firebase.Timestamp
import com.google.firebase.ktx.Firebase
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.local.ReferenceSet


class SharedObjects {
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
    companion object{
        @SuppressLint("StaticFieldLeak")
        val db = Firebase.firestore
        val menuCollection = db.collection("vendors").document("pqCOEjacUXj6r5KM7fEL").collection("menu")
        var dishes:MutableList<Dish> = mutableListOf<Dish>()
    }
}