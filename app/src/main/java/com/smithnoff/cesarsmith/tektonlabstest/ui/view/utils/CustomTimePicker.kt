package com.smithnoff.cesarsmith.tektonlabstest.ui.view.utils

import android.app.TimePickerDialog
import android.content.Context
import android.support.design.widget.TextInputEditText
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by jesusflores on 11-03-18.
 */
class CustomTimePicker {



    companion object {

        fun eventTimePicker(context: Context, editText: TextInputEditText) {


            val cal = Calendar.getInstance()

            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                editText.setText("$hour:$minute")
            }

            editText.setOnClickListener {
                TimePickerDialog(context, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
            }

        }
    }
}