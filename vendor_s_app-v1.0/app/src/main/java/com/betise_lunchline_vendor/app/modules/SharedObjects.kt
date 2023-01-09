package com.betise_lunchline_vendor.app.modules

import android.annotation.SuppressLint
import com.google.firebase.Timestamp
import com.google.firebase.ktx.Firebase
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.local.ReferenceSet


class SharedObjects {
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
    companion object{
        @SuppressLint("StaticFieldLeak")
        val db = Firebase.firestore
        val menuCollection = db.collection("vendors").document("pqCOEjacUXj6r5KM7fEL").collection("menu")
        var dishes:MutableList<Dish> = mutableListOf<Dish>()
    }
}