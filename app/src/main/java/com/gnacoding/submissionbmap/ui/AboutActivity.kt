package com.gnacoding.submissionbmap.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gnacoding.submissionbmap.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private var _aboutBinding: ActivityAboutBinding? = null
    private val aboutBinding get() = _aboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _aboutBinding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(aboutBinding?.root)

        aboutBinding?.btnBack?.setOnClickListener { onBackPressed() }
    }
}