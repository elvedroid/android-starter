package com.elveselimoski.starterapp.util

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

object DeviceUtil {

    fun showSoftKeyboard(view: View) {
        val keyboard = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        keyboard.toggleSoftInput(0, 0)
    }

    fun hideSoftKeyboard(activity: Activity) {
        hideSoftKeyboard(activity.window.decorView)
    }

    fun hideSoftKeyboard(view: View) {
        val keyboard = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        // Not using getCurrentFocus as that sometimes is null, but the keyboard is still up.
        keyboard.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
