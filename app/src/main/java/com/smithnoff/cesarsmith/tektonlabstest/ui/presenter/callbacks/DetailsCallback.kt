package com.smithnoff.cesarsmith.tektonlabstest.ui.presenter.callbacks

import com.smithnoff.cesarsmith.tektonlabstest.background.firebase.User

/**
 * Created by jesusflores on 12-03-18.
 */
interface DetailsCallback {
    interface  View{
        fun showErrors(msg:String,action:Int)
        fun showSuscribers(list:MutableList<User>)

    }
    interface Presenter{
        fun showErrors(msg:String,action:Int)
        fun callSuscribers(eventId:String)
        fun showSuscribers(list:MutableList<User>)

    }
    interface  Model{
        fun callSuscribers(eventId:String)


    }
}