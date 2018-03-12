package com.smithnoff.cesarsmith.tektonlabstest.ui.model

import android.content.Context
import com.google.firebase.firestore.FirebaseFirestore
import com.smithnoff.cesarsmith.tektonlabstest.background.firebase.User
import com.smithnoff.cesarsmith.tektonlabstest.ui.presenter.callbacks.CreateAccountCallback

/**
 * Created by jesusflores on 07-03-18.
 */
class CreateAccountModel(val presenter:CreateAccountCallback.Presenter):CreateAccountCallback.Model {

    override fun createAccountStart(context: Context, email: String, pass: String, username: String) {
        var firestore=FirebaseFirestore.getInstance()

        firestore.collection("users").get().addOnCompleteListener {
            snapshot->
            var exist=false
            for (document in snapshot.result){
                if (document["email"]==email)
                {exist=true
                    break

                }

            }
            if (exist){
                presenter.showErrors("Este email ya esta registrado",3)
            }else{
                val user=User(email,pass,"",username)
                firestore.collection("users").document().set(user)
                presenter.createAccountSuccess()
            }
        }



    }
}