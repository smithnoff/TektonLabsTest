package com.smithnoff.cesarsmith.tektonlabstest.ui.presenter.interactors

import android.content.Context
import com.smithnoff.cesarsmith.tektonlabstest.background.firebase.EventFeed
import com.smithnoff.cesarsmith.tektonlabstest.ui.model.MyEventsModel
import com.smithnoff.cesarsmith.tektonlabstest.ui.presenter.callbacks.MyEventsCallback

/**
 * Created by jesusflores on 11-03-18.
 */
class MyEventsPresenter(val view :MyEventsCallback.View):MyEventsCallback.Presenter {

    val model=MyEventsModel(this)
    override fun showErrors(msg: String, action: Int) {
    }

    override fun callList(context: Context) {
        model.callList(context)
    }

    override fun showMyEvents(list: MutableList<EventFeed>) {
        view.showMyEvents(list)
    }
}