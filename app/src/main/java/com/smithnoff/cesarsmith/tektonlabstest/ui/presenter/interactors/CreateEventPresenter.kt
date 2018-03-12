package com.smithnoff.cesarsmith.tektonlabstest.ui.presenter.interactors

import android.content.Context
import com.smithnoff.cesarsmith.tektonlabstest.ui.model.CreateAccountModel
import com.smithnoff.cesarsmith.tektonlabstest.ui.model.CreateEventModel
import com.smithnoff.cesarsmith.tektonlabstest.ui.presenter.callbacks.CreateEventCallback

/**
 * Created by jesusflores on 11-03-18.
 */
class CreateEventPresenter(val view: CreateEventCallback.View) : CreateEventCallback.Presenter {

    val model = CreateEventModel(this)


    override fun onEventCreated() {
        view.onEventCreated()
    }

    override fun onStartCreateEvent(context: Context, title: String, place: String, date: String, hour: String) {
        if (title.isEmpty() || place.isEmpty() || date.isEmpty() || hour.isEmpty()) {
            view.showErrors("Ningun campo debe ir vacio.", 1)
        } else {
            model.onStartCreateEvent(context, title, place, date, hour)
        }


    }

    override fun showErrors(msg: String, action: Int) {

    }


}