package com.smithnoff.cesarsmith.tektonlabstest.ui.presenter.callbacks

import com.smithnoff.cesarsmith.tektonlabstest.background.firebase.EventFeed

/**
 * Created by jesusflores on 11-03-18.
 */
interface EventsCallback {

    interface View{
        fun showErrors(msg:String,action:Int)
        fun showEvents(list:MutableList<EventFeed>)
    }
    interface Presenter{
        fun showErrors(msg:String,action:Int)
        fun callList()
        fun showEvents(list:MutableList<EventFeed>)

    }
    interface Model{
        fun callList()

    }


}