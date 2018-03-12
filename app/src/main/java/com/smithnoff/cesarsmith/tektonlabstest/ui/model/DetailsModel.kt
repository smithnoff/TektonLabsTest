package com.smithnoff.cesarsmith.tektonlabstest.ui.model

import android.media.midi.MidiManager
import com.google.firebase.firestore.FirebaseFirestore
import com.smithnoff.cesarsmith.tektonlabstest.background.firebase.EventFeed
import com.smithnoff.cesarsmith.tektonlabstest.background.firebase.User
import com.smithnoff.cesarsmith.tektonlabstest.ui.presenter.callbacks.DetailsCallback

/**
 * Created by jesusflores on 12-03-18.
 */
class DetailsModel(val presenter:DetailsCallback.Presenter):DetailsCallback.Model {
    override fun callSuscribers(eventId: String) {
        var firestore=FirebaseFirestore.getInstance()
        firestore.collection("feed").document(eventId).collection("suscribers").get().addOnCompleteListener {
            var list: MutableList<User> = mutableListOf()

            for (documents in it.result){
                list.add(documents.toObject(User::class.java))

            }
            presenter.showSuscribers(list)

        }

    }
}