package com.chris_guzman.browserinterceptor

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        title = "How to use Browser Interceptor"

        github.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/ChrisGuzman/BrowserInterceptor"))
            startActivity(intent)
        }

        chris_site.setOnClickListener{
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://chris-guzman.com/"))
            startActivity(intent)
        }

        about_pocket.setOnClickListener{
            val appPackageName = "com.ideashower.readitlater.pro"
            try {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)))
            } catch (anfe: android.content.ActivityNotFoundException) {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + appPackageName)))
            }
        }

        share_button.setOnClickListener{
            val sendIntent = Intent()
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Check out Browser Interceptor on the Play Store. chris-guzman.com/browser_intercept.html")
            sendIntent.type = "text/plain"
            startActivity(sendIntent)
        }
    }
}
