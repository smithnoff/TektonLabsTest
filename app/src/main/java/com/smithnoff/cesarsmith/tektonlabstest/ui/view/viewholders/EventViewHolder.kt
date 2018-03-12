package com.smithnoff.cesarsmith.tektonlabstest.ui.view.viewholders

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.View
import com.google.firebase.firestore.FirebaseFirestore
import com.smithnoff.cesarsmith.tektonlabstest.background.firebase.EventFeed
import kotlinx.android.synthetic.main.item_feed.view.*
import android.preference.PreferenceManager
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import com.smithnoff.cesarsmith.tektonlabstest.background.firebase.User
import com.smithnoff.cesarsmith.tektonlabstest.ui.view.activities.DetailsActivity
import com.smithnoff.cesarsmith.tektonlabstest.ui.view.fragments.EventsFragment


/**
 * Created by jesusflores on 11-03-18.
 */
class EventViewHolder(itemView: View?, val suscribed: Boolean) : RecyclerView.ViewHolder(itemView) {


    fun bindView(feed: EventFeed) {

        itemView.item_title.text = feed.title
        itemView.item_place.text = "Lugar: " + feed.place
        itemView.item_date_hour.text = "Fecha y hora: " + feed.date + " " + feed.time
        if (!suscribed) {
            itemView.item_bt_suscribe.setOnClickListener {
                suscribeEvent(feed)
            }
        } else {
            itemView.item_bt_suscribe.text = "Desinscribirse"
            itemView.item_bt_suscribe.setOnClickListener {
                unsuscribeEvent(feed)
            }
        }
        itemView.setOnClickListener {
            itemView.context.startActivity(Intent(itemView.context,DetailsActivity::class.java).putExtra("evento",feed))
        }


    }


    fun suscribeEvent(feed: EventFeed) {

        var dialog = AlertDialog.Builder(itemView.context)
        dialog.setTitle("Atencion!")
        dialog.setMessage("Quieres Inscribirte en este Evento?")
        dialog.setPositiveButton("Incribirse", DialogInterface.OnClickListener { dialogInterface, i ->
            val preferences = (itemView.context as Activity).getSharedPreferences("com.usersession", Context.MODE_PRIVATE)
            var firestore = FirebaseFirestore.getInstance()
            Log.e("ID", preferences.getString("id", "456782"))

            firestore.collection("feed").document(feed.id).collection("suscribers")
                    .document(preferences.getString("id", "456782")).set(User("", "", preferences.getString("id", "456782")
                            , preferences.getString("username", "usuario"))).addOnCompleteListener {

                        firestore.collection("users").document(preferences.getString("id", "456782")).collection("suscribed")
                                .document(feed.id).set(feed)
                    }
        })
        dialog.setNegativeButton("Cancelar", null)
        dialog.create().show()


    }

    private fun unsuscribeEvent(feed: EventFeed) {
        var dialog = AlertDialog.Builder(itemView.context)
        dialog.setTitle("Atencion!")
        dialog.setMessage("Quieres cancelar tu susbcripcion en este Evento?")
        dialog.setPositiveButton("Desinscribirse", DialogInterface.OnClickListener { dialogInterface, i ->
            val preferences = (itemView.context as Activity).getSharedPreferences("com.usersession", Context.MODE_PRIVATE)
            var firestore = FirebaseFirestore.getInstance()
            Log.e("ID", preferences.getString("id", "456782"))

            firestore.collection("users").document(preferences.getString("id", "456782")).collection("suscribed")
                    .document(feed.id).delete().addOnCompleteListener {
                        firestore.collection("feed").document(feed.id).collection("suscribers")
                                .document(preferences.getString("id", "456782")).delete()

                    }
        })
        dialog.setNegativeButton("Cancelar", null)
        dialog.create().show()

    }


}