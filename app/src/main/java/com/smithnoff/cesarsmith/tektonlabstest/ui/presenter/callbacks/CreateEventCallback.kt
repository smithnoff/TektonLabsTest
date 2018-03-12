package com.smithnoff.cesarsmith.tektonlabstest.ui.presenter.callbacks

import android.content.Context

/**
 * Created by jesusflores on 11-03-18.
 */
interface CreateEventCallback {

    interface View{
        fun showErrors(msg:String,action:Int)
        fun onEventCreated()

    }
    interface  Presenter{
        fun showErrors(msg:String,action:Int)
        fun onEventCreated()
        fun onStartCreateEvent(context:Context,title:String,place:String,date:String,hour:String)

    }
    interface Model{
        fun onStartCreateEvent(context:Context,title:String,place:String,date:String,hour:String)

    }


}