package com.chris_guzman.browserinterceptor

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast


class BrowserInterceptActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val action = intent.action
        var dataString = ""
        if (Intent.ACTION_VIEW.equals(action)) {
            dataString = intent.dataString

            if (TextUtils.isEmpty(dataString)) {
                showError()
                return
            } else {
                openInPocket(dataString)
            }
        }

        finish()
    }

    private fun openInPocket(dataString: String) {
        val intent = Intent()
        intent.setClassName("com.ideashower.readitlater.pro", "com.ideashower.readitlater.activity.AddActivity")
        intent.putExtra(Intent.EXTRA_TEXT, dataString)

        if (isPocketAvailable(intent)) {
                startActivity(intent)
        } else {
            showError()
        }

        finish()
    }

    private fun isPocketAvailable(intent: Intent): Boolean {
        val packageManager = packageManager ?: return false
        val activities = packageManager.queryIntentActivities(intent, 0)
        val isIntentSafe = activities.size > 0

        return isIntentSafe
    }

    private fun showError() {
        Toast.makeText(this@BrowserInterceptActivity, "Error opening in Pocket", Toast.LENGTH_LONG).show()
    }
}
