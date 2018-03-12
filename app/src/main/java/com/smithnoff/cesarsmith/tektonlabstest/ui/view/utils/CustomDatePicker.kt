package com.smithnoff.cesarsmith.tektonlabstest.ui.view.utils

import android.app.Activity
import android.app.DatePickerDialog
import android.content.Context
import android.support.design.widget.TextInputEditText
import java.util.*

/**
 * Created by jesusflores on 11-03-18.
 */
class CustomDatePicker {


    companion object {

        fun eventDatePicker( context: Context, edittext:TextInputEditText){
            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)


            val dpd = DatePickerDialog(context as Activity, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                // Display Selected date in textbox
                edittext.setText("$dayOfMonth /$monthOfYear/ $year")
            }, year, month, day)
            dpd.datePicker.minDate=System.currentTimeMillis()
            dpd.show()
        }
    }


}