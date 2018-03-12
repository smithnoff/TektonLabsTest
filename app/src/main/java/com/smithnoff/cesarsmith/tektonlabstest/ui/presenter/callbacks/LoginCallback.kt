package com.smithnoff.cesarsmith.tektonlabstest.ui.presenter.callbacks

import android.content.Context

/**
 * Created by jesusflores on 07-03-18.
 */
interface LoginCallback {

    interface View{
        fun showError(error:String)
        fun loginSuccess()
        fun invalidEmail()



    }
    interface Presenter{
        fun showLoginStar(context: Context,email:String,pass:String)
        fun showError(error:String)
        fun loginSuccess()

    }
    interface Model{

        fun showLoginStar(context: Context,email:String,pass:String)

    }

}