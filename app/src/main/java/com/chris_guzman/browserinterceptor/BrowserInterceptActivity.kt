package com.chris_guzman.browserinterceptor

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import org.jetbrains.anko.longToast


class BrowserInterceptActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (Intent.ACTION_VIEW == intent.action && intent.dataString.isNotEmpty()) {
            openInPocket(intent.dataString)
        } else {
            showError()
        }

        finishAffinity()
    }

    private fun openInPocket(dataString: String) {
        val pocketIntent = Intent().apply {
            setClassName("com.ideashower.readitlater.pro", "com.ideashower.readitlater.activity.AddActivity")
            putExtra(Intent.EXTRA_TEXT, dataString)
        }

        if (pocketIsAvailable(pocketIntent)) startActivity(pocketIntent) else showError()

        finish()
    }

    private fun pocketIsAvailable(pocketIntent: Intent) =
            packageManager?.queryIntentActivities(pocketIntent, 0)?.isNotEmpty() == true

    private fun showError() {
        longToast("Error opening in Pocket")
    }
}
