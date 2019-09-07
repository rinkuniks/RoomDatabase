package com.technoidentity.roomdatabase

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Build
import android.os.Handler
import android.provider.Settings
import android.util.Log
import androidx.annotation.RequiresApi
import java.util.*

object Constants {

    var TOKEN = "token"
    var PREFERENCE_NAME = "mpi"
    var ID = "userId"
    var PRODUCTID = "productId"
    var CUSTOMERID = "customerId"
    var USERNAME = "username"
    var FIRST_NAME = "firstName"
    var EMAIL = "emailId"
    var PRODUCTIDS = "setOfProductId"
    var ADAPTERPOSITION = "adapterPosition"
    var DESIGNATION = "designation"
    var MOBILE_NUMBER = "mobileNumber"
    var emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
    val IMAGE_STORED_DIRECTORY = "/Digital_Sign"
    val PERMISSIONS_REQUEST_FOR_READ_EXTERNAL_STORAGE = 123

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    fun haveInternet(ctx: Context): Boolean {
        try {
            val info = (Objects.requireNonNull(ctx.getSystemService(Context.CONNECTIVITY_SERVICE))
                as ConnectivityManager).activeNetworkInfo
            if (info == null || !info.isConnected) {
                return false
            }
        } catch (e: Exception) {
            Log.d("err", e.toString())
        }
        return true
    }

    fun InternetSettings(ctx: Context) {

        val alertDialogBuilder = AlertDialog.Builder(ctx)
        alertDialogBuilder
            .setMessage("No internet connection on your device. Would you like to enable it?")
            .setTitle("No Internet Connection")
            .setCancelable(false)
            .setPositiveButton(
                " Enable Internet ")
            { dialog , id ->
                val dialogIntent = Intent(Settings.ACTION_SETTINGS)
                dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                ctx.startActivity(dialogIntent)
            }

        alertDialogBuilder.setNegativeButton(" Cancel ") { dialog , id -> dialog.cancel() }

        val alert = alertDialogBuilder.create()
        alert.show()
    }

    fun showServerConnectionErrorDialog(ctx: Context, email: String, password: String, start: Int, end: Int) {
        val alertDialogBuilder = AlertDialog.Builder(ctx)
        val handler = Handler(ctx.mainLooper)
        handler.post(Runnable {
            alertDialogBuilder
                .setMessage("OOPS!! There is a technical issue, please try again...")
                .setTitle("MPI")
                .setCancelable(false)
                .setPositiveButton(
                    " Retry "
                )
                { dialog, id ->
                    dialog.dismiss()
                }

            alertDialogBuilder.setNegativeButton(" Cancel ") { dialog, id ->
                dialog.cancel()
            }
            val alert = alertDialogBuilder.create()
            if (!alert.isShowing)
                alert.show()
            else
                alert.dismiss()
        })
    }
}
