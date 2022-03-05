package com.escalondev.deeplink_nav.util

import android.net.Uri
import androidx.navigation.NavController

fun NavController.navigateThroughDeepLink(destination: String) {
    this.navigate(Uri.parse(destination))
}
