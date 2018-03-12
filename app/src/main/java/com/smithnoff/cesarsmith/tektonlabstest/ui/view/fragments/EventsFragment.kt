package com.smithnoff.cesarsmith.tektonlabstest.ui.view.fragments


import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.smithnoff.cesarsmith.tektonlabstest.R
import com.smithnoff.cesarsmith.tektonlabstest.background.firebase.EventFeed
import com.smithnoff.cesarsmith.tektonlabstest.ui.presenter.callbacks.EventsCallback
import com.smithnoff.cesarsmith.tektonlabstest.ui.presenter.interactors.EventsPresenter
import com.smithnoff.cesarsmith.tektonlabstest.ui.view.activities.CreateEventActivity
import com.smithnoff.cesarsmith.tektonlabstest.ui.view.adapters.EventsAdapter
import kotlinx.android.synthetic.main.fragment_events.*
import kotlinx.android.synthetic.main.fragment_events.view.*
import android.app.ProgressDialog


/**
 * A simple [Fragment] subclass.
 */
class EventsFragment : Fragment(), EventsCallback.View {

    lateinit var presenter: EventsCallback.Presenter
    lateinit var dialog: ProgressDialog

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_events, container, false)
        presenter = EventsPresenter(this)
        activity.title = "Events"
        var listEvent = mutableListOf<EventFeed>()
        view.recycler_events.layoutManager = LinearLayoutManager(context)
        view.recycler_events.adapter = EventsAdapter(context, listEvent, false)
        view.recycler_events.adapter.notifyDataSetChanged()
        presenter.callList()
        view.create_event_fab.setOnClickListener {
            startActivity(Intent(context, CreateEventActivity::class.java))
        }
        dialog = ProgressDialog.show(context, "",
                "Cargando Eventos...", true)

        return view
    }

    override fun showErrors(msg: String, action: Int) {
        dialog.cancel()
        when (action) {
            1 -> {
            }
        }
    }

    override fun showEvents(list: MutableList<EventFeed>) {
        if (list.size==0)
            tv_no.visibility=View.VISIBLE
        else
            tv_no.visibility=View.INVISIBLE

        this.recycler_events.adapter = EventsAdapter(context, list, false)
        this.recycler_events.adapter.notifyDataSetChanged()
        dialog.cancel()
    }

    override fun onResume() {
        presenter.callList()
        super.onResume()
    }

    fun createEventDialog() {

    }


}// Required empty public constructor
