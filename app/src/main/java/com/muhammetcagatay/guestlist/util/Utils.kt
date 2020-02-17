package com.muhammetcagatay.guestlist.util

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import com.muhammetcagatay.guestlist.R
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

/**
 * Created by Muhammet ÇAĞATAY on 16,Şubat,2020
 */
class Utils {

    companion object {

        fun showLoadingDialog(context: Context): ProgressDialog {
            var progressDialog: ProgressDialog = ProgressDialog(context)
            if (!(context as Activity).isFinishing) {
                progressDialog.show()
            }
            if (progressDialog.window != null) {
                progressDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            }
            progressDialog.setContentView(R.layout.progress_dialog)
            progressDialog.setCancelable(false)
            progressDialog.setCanceledOnTouchOutside(false)
            return progressDialog
        }


        fun generateTextDate(context: Context,start:String,end:String,timzone:String):String{

            val parser =  SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            val formatter = SimpleDateFormat("dd.MM.yyyy HH:mm")
            val formattedDate = formatter.format(parser.parse("2018-12-14T09:55:00"))

            return  ""
        }

    }

}