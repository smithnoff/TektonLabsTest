package com.smithnoff.cesarsmith.tektonlabstest.ui.presenter.interactors

import android.content.Context
import com.smithnoff.cesarsmith.tektonlabstest.ui.model.LoginModel
import com.smithnoff.cesarsmith.tektonlabstest.ui.presenter.callbacks.LoginCallback
import com.smithnoff.cesarsmith.tektonlabstest.ui.view.utils.TextValidator


/**
 * Created by jesusflores on 07-03-18.
 */
class LoginPresenter(val view:LoginCallback.View): LoginCallback.Presenter {

    private val model= LoginModel(this)



    override fun showLoginStar(context: Context, email: String, pass: String) {

        if (TextValidator.emailValidate(email)){
            model.showLoginStar(context,email,pass)
        }else{
            view.invalidEmail()
        }

    }

    override fun showError(error: String) {
        view.showError(error)
    }

    override fun loginSuccess() {
        view.loginSuccess()
    }
}