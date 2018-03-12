package com.smithnoff.cesarsmith.tektonlabstest.ui.presenter.interactors

import android.content.Context
import com.smithnoff.cesarsmith.tektonlabstest.ui.model.CreateAccountModel
import com.smithnoff.cesarsmith.tektonlabstest.ui.presenter.callbacks.CreateAccountCallback
import com.smithnoff.cesarsmith.tektonlabstest.ui.view.utils.TextValidator

/**
 * Created by jesusflores on 07-03-18.
 */
class CreateAccountPresenter(val view: CreateAccountCallback.View) : CreateAccountCallback.Presenter {

    val model = CreateAccountModel(this)

    override fun showErrors(msg: String, action: Int) {

    }

    override fun createAccountStart(context: Context, email: String, pass: String, passRep: String, username: String) {


        if (username != "") {
            if (TextValidator.emailValidate(email)) {
                if (pass != "" && pass == passRep) {
                    model.createAccountStart(context, email, pass, username)

                } else {
                    view.showErrors("Las contrasenas no coinciden", 2)

                }

            } else {
                view.showErrors("Email invalido", 1)
            }
        }else{
            view.showErrors("El nombre de usuario no puede estar vacio", 0)

        }


    }

    override fun createAccountSuccess() {
        view.createAccountSuccess()
    }
}