package com.smithnoff.cesarsmith.tektonlabstest.ui.model

import android.app.Activity
import android.content.Context
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.smithnoff.cesarsmith.tektonlabstest.background.firebase.EventFeed
import com.smithnoff.cesarsmith.tektonlabstest.ui.presenter.callbacks.MyEventsCallback

/**
 * Created by jesusflores on 11-03-18.
 */
class MyEventsModel(val presenter:MyEventsCallback.Presenter):MyEventsCallback.Model {




    override fun callList(context: Context) {
        var firestore = FirebaseFirestore.getInstance()
        val settings = FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .build()
        firestore.firestoreSettings = settings
        val preferences = ( context as Activity).getSharedPreferences("com.usersession", Context.MODE_PRIVATE)

        firestore.collection("users").document(preferences.getString("id","4567893")).collection("suscribed")
                .get().addOnCompleteListener {
                    var list: MutableList<EventFeed> = mutableListOf()
                    for (document in it.result){
                        var id=document.id
                        var event=document.toObject(EventFeed::class.java)
                        event.id=id
                        list.add(event)
                    }
                    presenter.showMyEvents(list)
                }


    }
}