package com.smithnoff.cesarsmith.tektonlabstest.ui.model

import android.content.Context
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore
import com.smithnoff.cesarsmith.tektonlabstest.background.firebase.User
import com.smithnoff.cesarsmith.tektonlabstest.ui.presenter.callbacks.LoginCallback
import android.R.attr.key
import android.R.id.edit
import android.app.Activity
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences




/**
 * Created by jesusflores on 07-03-18.
 */
class LoginModel(val presenter: LoginCallback.Presenter) :LoginCallback.Model{


    override fun showLoginStar(context: Context, email: String, pass: String) {
       val  firestore=FirebaseFirestore.getInstance()

        firestore.collection("users").get().addOnCompleteListener {snapshot->
           if (snapshot.isSuccessful) {

               for (document in snapshot.result) {
                   if (document["email"] == email) {
                       if (document["password"] == pass) {
                           val sharedPref = (context as Activity).getSharedPreferences("com.usersession",Context.MODE_PRIVATE)

                         var  toEdit = sharedPref.edit()
                           toEdit.putString("id", document.id)
                           toEdit.putString("username", document["username"].toString())
                           toEdit.putString("password", document["password"].toString())
                           toEdit.apply()

                           presenter.loginSuccess()
                       }else{
                           presenter.showError("La contrasena no coincide..")

                       }
                   }else{
                       presenter.showError("El usuario no existe.")
                   }
               }
           }else{
               presenter.showError("Error de conexion.")

           }
        }


    }


}