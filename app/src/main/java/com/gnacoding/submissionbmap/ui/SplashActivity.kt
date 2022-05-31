package com.gnacoding.submissionbmap.ui

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.gnacoding.submissionbmap.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {

    private lateinit var handler: Handler

    private var _splashBinding: ActivitySplashBinding? = null
    private val splashBinding get() = _splashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _splashBinding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(splashBinding?.root)

        val delay = 3000L

        handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            val mIntent = Intent(this, MainActivity::class.java)
            startActivity(mIntent)
            finish()
        }, delay)
    }
}