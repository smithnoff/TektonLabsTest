package com.smithnoff.cesarsmith.tektonlabstest.ui.presenter.interactors

import com.smithnoff.cesarsmith.tektonlabstest.background.firebase.User
import com.smithnoff.cesarsmith.tektonlabstest.ui.model.DetailsModel
import com.smithnoff.cesarsmith.tektonlabstest.ui.presenter.callbacks.DetailsCallback

/**
 * Created by jesusflores on 12-03-18.
 */
class DetailsPresenter(val view: DetailsCallback.View) : DetailsCallback.Presenter {

    val model = DetailsModel(this)

    override fun showErrors(msg: String, action: Int) {
    }

    override fun callSuscribers(eventId: String) {
        model.callSuscribers(eventId)
    }

    override fun showSuscribers(list: MutableList<User>) {
        view.showSuscribers(list)

    }
}