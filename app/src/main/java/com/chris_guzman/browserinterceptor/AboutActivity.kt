package com.chris_guzman.browserinterceptor

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.chris_guzman.browserinterceptor.constants.*
import kotlinx.android.synthetic.main.activity_about.*
import org.jetbrains.anko.browse
import org.jetbrains.anko.share

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        title = getString(R.string.about_activity_title)

        github.setOnClickListener{
            browse(SOURCE_CODE)
        }

        chris_site.setOnClickListener{
            browse(PERSONAL_WEBSITE)
        }

        about_pocket.setOnClickListener{
            try {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(POCKET_PLAY_STORE_DEEPLINK)))
            } catch (anfe: android.content.ActivityNotFoundException) {
                browse(POCKET_PLAY_STORE_LINK)
            }
        }

        share_button.setOnClickListener{
            share(getString(R.string.share_app, SHARE_LINK))
        }
    }
}
