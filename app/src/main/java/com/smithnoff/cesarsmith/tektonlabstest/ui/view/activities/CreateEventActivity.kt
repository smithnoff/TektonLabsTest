package com.smithnoff.cesarsmith.tektonlabstest.ui.view.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.smithnoff.cesarsmith.tektonlabstest.R
import com.smithnoff.cesarsmith.tektonlabstest.ui.presenter.callbacks.CreateEventCallback
import com.smithnoff.cesarsmith.tektonlabstest.ui.presenter.interactors.CreateEventPresenter
import com.smithnoff.cesarsmith.tektonlabstest.ui.view.utils.CustomDatePicker
import com.smithnoff.cesarsmith.tektonlabstest.ui.view.utils.CustomTimePicker
import kotlinx.android.synthetic.main.activity_create_event.*
import android.support.v4.app.ShareCompat.IntentBuilder
import com.google.android.gms.location.places.ui.PlacePicker
import android.R.attr.data
import android.app.Activity
import android.app.AlertDialog
import android.app.ProgressDialog
import android.util.Log


class CreateEventActivity : AppCompatActivity(), CreateEventCallback.View {

    lateinit var presenter: CreateEventCallback.Presenter
    lateinit var dialog: ProgressDialog


    private val PLACE_PICKER_REQUEST: Int = 9999

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_event)
        presenter = CreateEventPresenter(this)

        val builder = PlacePicker.IntentBuilder()

        ce_event_place_et.setOnClickListener {
            startActivityForResult(builder.build(this), PLACE_PICKER_REQUEST);

        }

        ce_event_date_et.setOnClickListener {
            CustomDatePicker.eventDatePicker(this, ce_event_date_et)
        }
        ce_event_hour_et.setOnClickListener { CustomTimePicker.eventTimePicker(this, ce_event_hour_et) }

        ce_create_event_bt.setOnClickListener {
            presenter.onStartCreateEvent(this, ce_event_name_et.text.toString()
                    , ce_event_place_et.text.toString()
                    , ce_event_date_et.text.toString()
                    , ce_event_hour_et.text.toString()

            )
            dialog = ProgressDialog.show(this, "",
                    "Creando evento...", true)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Log.e("request",requestCode.toString())
        Log.e("result",resultCode.toString())
        if (requestCode === PLACE_PICKER_REQUEST) {
            if (resultCode === Activity.RESULT_OK) {
                val selectedPlace = PlacePicker.getPlace(data, this)
                ce_event_place_et.setText(selectedPlace.name)
            }else{
                ce_event_place_et.setText("No se ha seleccionado ningun lugar.")
                ce_event_place_et.isFocusable=true
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }


    override fun onEventCreated() {
        dialog.cancel()

        finish()
    }

    override fun showErrors(msg: String, action: Int) {
        dialog.cancel()
        var alert= AlertDialog.Builder(this)
        alert.setTitle("Atencion!")
        when (action) {
            1 -> {
                alert.setMessage(msg)
                alert.setNeutralButton("Aceptar",null)


            }
            2 -> {
            }
        }
        alert.create().show()

    }

}
