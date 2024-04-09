package com.usermanage.usercrud.utils

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog

object DialogUtils {

    fun showAlertDialog(
        context: Context,
        title: String,
        message: String,
        positiveButtonTitle: String,
        negativeButtonTitle: String? = null,
        positiveAction: () -> Unit,
        negativeAction: (() -> Unit)? = null
    ) {
        val alertDialogBuilder = AlertDialog.Builder(context)
        alertDialogBuilder.setTitle(title)
        alertDialogBuilder.setMessage(message)
        alertDialogBuilder.setPositiveButton(positiveButtonTitle) { dialogInterface: DialogInterface, _: Int ->
            dialogInterface.dismiss()
            positiveAction.invoke()
        }
        negativeButtonTitle?.let {
            alertDialogBuilder.setNegativeButton(it) { dialogInterface: DialogInterface, _: Int ->
                dialogInterface.dismiss()
                negativeAction?.invoke()
            }
        }
        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
}