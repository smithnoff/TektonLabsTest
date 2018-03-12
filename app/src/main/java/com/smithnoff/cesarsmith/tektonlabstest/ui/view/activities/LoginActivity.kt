package com.smithnoff.cesarsmith.tektonlabstest.ui.view.activities

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.smithnoff.cesarsmith.tektonlabstest.R
import com.smithnoff.cesarsmith.tektonlabstest.ui.presenter.callbacks.LoginCallback
import com.smithnoff.cesarsmith.tektonlabstest.ui.presenter.interactors.LoginPresenter
import kotlinx.android.synthetic.main.activity_create_account.*
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(),LoginCallback.View {
       lateinit var presenter:LoginCallback.Presenter
    lateinit var dialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter=LoginPresenter(this)

        la_login_bt.setOnClickListener {
            dialog = ProgressDialog.show(this, "",
                    "Iniciando sesion...", true)
            presenter.showLoginStar(this,
                                     la_user_et.text.toString().trim(),
                                    la_password_et.text.toString().trim())
        }
        bt_create_account.setOnClickListener {
            startActivity(Intent(this,CreateAccountActivity::class.java))
        }



    }
    override fun showError(error: String) {
        dialog.cancel()
        showErrorDialog(error)

    }

    override fun loginSuccess() {
        dialog.cancel()
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }

    override fun invalidEmail() {
        dialog.cancel()
        ca_email_et.error = "Email invalido"

    }

    fun showErrorDialog( msg:String){
        var dialog=AlertDialog.Builder(this)
        dialog.setTitle("Atencion!")
        dialog.setMessage(msg)
        dialog.setNeutralButton("Aceptar",null)
        dialog.create().show()
    }


}
