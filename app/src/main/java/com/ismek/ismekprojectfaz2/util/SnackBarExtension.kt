package com.ismek.ismekprojectfaz2.util

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.showSnackBar(message: String){
    Snackbar.make(this, message, Snackbar.LENGTH_LONG)
        .setAction("Action", null)
        .show()
}