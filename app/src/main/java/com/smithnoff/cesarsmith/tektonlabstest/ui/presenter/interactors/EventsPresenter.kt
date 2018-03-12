package com.smithnoff.cesarsmith.tektonlabstest.ui.presenter.interactors

import com.smithnoff.cesarsmith.tektonlabstest.background.firebase.EventFeed
import com.smithnoff.cesarsmith.tektonlabstest.ui.model.EventsModel
import com.smithnoff.cesarsmith.tektonlabstest.ui.presenter.callbacks.EventsCallback

/**
 * Created by jesusflores on 11-03-18.
 */
class EventsPresenter(val view: EventsCallback.View) : EventsCallback.Presenter {
    val model=EventsModel(this)
    override fun showErrors(msg: String, action: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun callList() {
        model.callList()
    }

    override fun showEvents(list: MutableList<EventFeed>) {
        view.showEvents(list)
    }

}