package com.smithnoff.cesarsmith.tektonlabstest.ui.view.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.smithnoff.cesarsmith.tektonlabstest.R
import com.smithnoff.cesarsmith.tektonlabstest.background.firebase.EventFeed
import com.smithnoff.cesarsmith.tektonlabstest.ui.view.viewholders.EventViewHolder

/**
 * Created by jesusflores on 11-03-18.
 */
class EventsAdapter(val context: Context,var eventList: MutableList<EventFeed>,var suscribed:Boolean):RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        var view=LayoutInflater.from(context).inflate(R.layout.item_feed,parent,false)

        return EventViewHolder(view,suscribed)
    }

    override fun getItemCount(): Int {
        return eventList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        (holder as EventViewHolder).bindView(eventList[position])

    }


}