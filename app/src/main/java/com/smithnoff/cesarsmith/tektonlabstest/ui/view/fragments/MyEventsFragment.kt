package com.smithnoff.cesarsmith.tektonlabstest.ui.view.fragments

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.DialogInterface
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.smithnoff.cesarsmith.tektonlabstest.R
import com.smithnoff.cesarsmith.tektonlabstest.background.firebase.EventFeed
import com.smithnoff.cesarsmith.tektonlabstest.ui.presenter.callbacks.MyEventsCallback
import com.smithnoff.cesarsmith.tektonlabstest.ui.presenter.interactors.MyEventsPresenter
import com.smithnoff.cesarsmith.tektonlabstest.ui.view.adapters.EventsAdapter
import kotlinx.android.synthetic.main.fragment_events.*
import kotlinx.android.synthetic.main.fragment_my_events.*
import kotlinx.android.synthetic.main.fragment_my_events.view.*


class MyEventsFragment : Fragment(),MyEventsCallback.View {

       lateinit var presenter:MyEventsCallback.Presenter
    lateinit var dialog: ProgressDialog

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
       var view =  inflater!!.inflate(R.layout.fragment_my_events, container, false)

        activity.title="My Events"
        presenter=MyEventsPresenter(this)
        var listEvent = mutableListOf<EventFeed>()
        view.recycler_my_events.layoutManager = LinearLayoutManager(context)
        view.recycler_my_events.adapter = EventsAdapter(context, listEvent,true)
        view.recycler_my_events.adapter.notifyDataSetChanged()
        dialog = ProgressDialog.show(context, "",
                "Cargando Eventos...", true)

        presenter.callList(context)
        return view
    }


    override fun showErrors(msg: String, action: Int) {
        dialog.cancel()
    }

    override fun showMyEvents(list: MutableList<EventFeed>) {
        if (list.size==0)
            tv_no_sus.visibility=View.VISIBLE
        else
            tv_no_sus.visibility=View.INVISIBLE


        this.recycler_my_events.adapter = EventsAdapter(context, list,true)
        this.recycler_my_events.adapter.notifyDataSetChanged()
        dialog.cancel()
    }

    override fun onResume() {
        presenter.callList(context)

        super.onResume()
    }


}// Required empty public constructor
