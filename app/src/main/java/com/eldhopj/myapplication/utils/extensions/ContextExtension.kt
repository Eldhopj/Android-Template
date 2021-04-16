package com.eldhopj.myapplication.utils.extensions

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.net.Uri
import android.os.Build
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import com.eldhopj.myapplication.R
import kotlin.math.roundToInt

/**
 * Is online
 *
 * @return
 */
@Suppress("DEPRECATION")
fun Context?.isOnline(): Boolean {
    val connectivityManager = this?.getSystemService(
        Context.CONNECTIVITY_SERVICE
    ) as ConnectivityManager
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        val networks = connectivityManager.allNetworks
        var hasInternet = false
        if (networks.isNotEmpty()) {
            networks.forEach { network ->
                val nc = connectivityManager.getNetworkCapabilities(network)
                if (nc!!.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)) {
                    hasInternet = true
                }
            }
        }
        hasInternet
    } else {
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        activeNetwork?.isConnectedOrConnecting == true
    }
}

/**
 * Get Color from res
 *
 * @param id
 * @return color res
 */
fun Context.color(@ColorRes id: Int): Int {
    return ContextCompat.getColor(this, id)
}

/**
 * Get drawable from res
 *
 * @param id
 * @return [Drawable]
 */
fun Context.drawable(@DrawableRes id: Int): Drawable? {
    return ContextCompat.getDrawable(this, id)
}

/**
 * Shows Toast message
 *
 * @param message Message to display
 */
fun Context?.toast(@StringRes message: Int) {
    if (this == null) return
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

/**
 * Shows Toast message
 *
 * @param message Message to display
 */
fun Context?.toast(message: String) {
    if (this == null) return
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

/**
 *  Hides the keyboard from the user
 * @param view
 */
fun Context?.hideKeyboard(view: View) {
    val imm = this?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
    imm?.hideSoftInputFromWindow(view.windowToken, 0)
}

/**
 * Displays the keyboard to the user
 * @param view
 */
fun Context?.showKeyboard(view: View) {
    val imm = this?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
    imm?.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
}

/**
 * Opens the App in play store.
 */
fun Context?.openAppInPlayStore() {
    if (this == null) return
    try {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$packageName")))
    } catch (e: android.content.ActivityNotFoundException) {
        startActivity(
            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://play.google.com/store/apps/details?id=$packageName")
            )
        )
    }
}

/**
 * Returns the App user-agent which can be used to pass in the API headers or params.
 */
fun Context?.getAppUserAgent(): String {
    if (this == null) return ""
    val versionName = try {
        val packageName = packageName
        val info = packageManager.getPackageInfo(packageName, 0)
        info.versionName
    } catch (e: PackageManager.NameNotFoundException) {
        "?"
    }
    return "${this.getString(R.string.app_name)}/$versionName" +
        " (${Build.MANUFACTURER} ${Build.MODEL};Android ${Build.VERSION.RELEASE})"
}

/**
 * Converts Dp to Pixel
 */
fun Context?.dpToPx(dp: Int): Int {
    if (this == null) return 0
    val density = resources.displayMetrics.density
    return (dp.toFloat() * density).roundToInt()
}
