package com.elveselimoski.starterapp.util;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public final class DeviceUtil {
    private DeviceUtil() {
    }

    public static void showSoftKeyboard(View view) {
        InputMethodManager keyboard = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        keyboard.toggleSoftInput(0, 0);
    }

    public static void hideSoftKeyboard(Activity activity) {
        hideSoftKeyboard(activity.getWindow().getDecorView());
    }

    public static void hideSoftKeyboard(View view) {
        InputMethodManager keyboard = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        // Not using getCurrentFocus as that sometimes is null, but the keyboard is still up.
        keyboard.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
