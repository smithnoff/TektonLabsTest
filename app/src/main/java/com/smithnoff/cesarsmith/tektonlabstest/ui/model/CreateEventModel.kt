package com.smithnoff.cesarsmith.tektonlabstest.ui.model

import android.content.Context
import com.google.firebase.firestore.FirebaseFirestore
import com.smithnoff.cesarsmith.tektonlabstest.background.firebase.EventFeed
import com.smithnoff.cesarsmith.tektonlabstest.ui.presenter.callbacks.CreateEventCallback

/**
 * Created by jesusflores on 11-03-18.
 */
class CreateEventModel(val presenter: CreateEventCallback.Presenter) : CreateEventCallback.Model {
    override fun onStartCreateEvent(context: Context, title: String, place: String, date: String, hour: String) {
        var firestore = FirebaseFirestore.getInstance()
        var event = EventFeed("", title, place, date, hour)
        firestore.collection("feed").document().set(event).addOnSuccessListener {
            presenter.onEventCreated()
        }.addOnFailureListener {
            presenter.showErrors("Ha ocurrido un error." + it.message, 2)
        }


    }


}