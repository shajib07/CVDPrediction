package com.atahar.cvdprediction.utils

import android.view.View
import androidx.core.content.ContextCompat
import com.atahar.cvdprediction.R
import com.google.android.material.snackbar.Snackbar

object HelperFunction {

    fun showErrorMessage(view: View, msg: String) {
        val snackBar = Snackbar.make(view, msg, Snackbar.LENGTH_SHORT)
        val snackBarView: View = snackBar.view
        snackBarView.setBackgroundColor(ContextCompat.getColor(view.context, R.color.web_sfe))
        snackBar.show()
    }
}