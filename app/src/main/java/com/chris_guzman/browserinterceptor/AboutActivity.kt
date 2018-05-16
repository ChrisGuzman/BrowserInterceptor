package com.chris_guzman.browserinterceptor

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_about.*
import org.jetbrains.anko.browse
import org.jetbrains.anko.share

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        title = "How to use Browser Interceptor"

        github.setOnClickListener{
            browse("https://github.com/ChrisGuzman/BrowserInterceptor")
        }

        chris_site.setOnClickListener{
            browse("http://chris-guzman.com/")
        }

        about_pocket.setOnClickListener{
            val appPackageName = "com.ideashower.readitlater.pro"
            try {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$appPackageName")))
            } catch (anfe: android.content.ActivityNotFoundException) {
                browse("http://play.google.com/store/apps/details?id=$appPackageName")
            }
        }

        share_button.setOnClickListener{
            share("Check out Browser Interceptor on the Play Store. chris-guzman.com/browser_intercept.html")
        }
    }
}
