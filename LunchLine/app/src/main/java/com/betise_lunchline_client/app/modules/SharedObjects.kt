package com.betise_lunchline_client.app.modules

import android.annotation.SuppressLint
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SharedObjects {
    companion object{
        @SuppressLint("StaticFieldLeak")
        val db = Firebase.firestore
    }

}