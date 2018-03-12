package com.smithnoff.cesarsmith.tektonlabstest.ui.model

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.smithnoff.cesarsmith.tektonlabstest.ui.presenter.callbacks.EventsCallback
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.smithnoff.cesarsmith.tektonlabstest.background.firebase.EventFeed


/**
 * Created by jesusflores on 11-03-18.
 */
class EventsModel(val presenter: EventsCallback.Presenter) : EventsCallback.Model {
    override fun callList() {
        var firestore = FirebaseFirestore.getInstance()
        val settings = FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .build()
        firestore.firestoreSettings = settings

        firestore.collection("feed").get().addOnCompleteListener { snapshot ->
            var list: MutableList<EventFeed> = mutableListOf()
            for (document in snapshot.result) {
                var id=document.id
                var event=document.toObject(EventFeed::class.java)
                  event.id=id
                list.add(event)
                Log.e("ID",event.id)


            }
            presenter.showEvents(list)


        }


    }
}