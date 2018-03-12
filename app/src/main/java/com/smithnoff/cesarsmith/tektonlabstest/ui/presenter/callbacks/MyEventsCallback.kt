package com.smithnoff.cesarsmith.tektonlabstest.ui.presenter.callbacks

import android.content.Context
import com.smithnoff.cesarsmith.tektonlabstest.background.firebase.EventFeed

/**
 * Created by jesusflores on 11-03-18.
 */
interface MyEventsCallback {

    interface View{
        fun showErrors(msg:String,action:Int)
        fun showMyEvents(list:MutableList<EventFeed>)
    }
    interface Presenter{
        fun showErrors(msg:String,action:Int)
        fun callList(context: Context)
        fun showMyEvents(list:MutableList<EventFeed>)

    }
    interface Model{
        fun callList(context: Context)

    }
}