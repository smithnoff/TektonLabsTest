package com.smithnoff.cesarsmith.tektonlabstest.ui.view.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.smithnoff.cesarsmith.tektonlabstest.R
import com.smithnoff.cesarsmith.tektonlabstest.ui.presenter.callbacks.CreateAccountCallback
import com.smithnoff.cesarsmith.tektonlabstest.ui.presenter.interactors.CreateAccountPresenter
import kotlinx.android.synthetic.main.activity_create_account.*

class CreateAccountActivity : AppCompatActivity(),CreateAccountCallback.View {
       lateinit var  presenter:CreateAccountCallback.Presenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)
        presenter=CreateAccountPresenter(this)

        ca_create_bt.setOnClickListener{
            presenter.createAccountStart(this,
                    ca_email_et.text.toString().trim(),
                    ca_password_et.text.toString().trim(),
                    ca_repeat_password_et.text.toString().trim(),
                    ca_user_et.text.toString().trim())
        }


    }


    override fun showErrors(msg: String, action: Int) {

        when(action){
            0->{
             Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
            }
            1->{
                Toast.makeText(this,msg,Toast.LENGTH_LONG).show()

            }
            2->{
                Toast.makeText(this,msg,Toast.LENGTH_LONG).show()

            }
            3->{
                Toast.makeText(this,msg,Toast.LENGTH_LONG).show()

            }
        }

    }

    override fun createAccountSuccess() {
        Toast.makeText(this,"Usuario registrado con exito.",Toast.LENGTH_LONG).show()
        finish()
    }
}
