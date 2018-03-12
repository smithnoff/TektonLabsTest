package com.smithnoff.cesarsmith.tektonlabstest.ui.presenter.callbacks

import android.content.Context

/**
 * Created by jesusflores on 07-03-18.
 */
interface CreateAccountCallback {

    interface View{
        fun showErrors(msg:String,action:Int)
        fun createAccountSuccess()


    }
    interface Presenter{
        fun showErrors(msg:String,action:Int)
        fun createAccountStart(context: Context,email:String,pass:String,passRep:String,username:String)
        fun createAccountSuccess()


    }
    interface  Model{
        fun createAccountStart(context: Context,email:String,pass:String,username:String)

    }
}