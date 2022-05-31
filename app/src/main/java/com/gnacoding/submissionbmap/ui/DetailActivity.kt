package com.gnacoding.submissionbmap.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gnacoding.submissionbmap.R
import com.gnacoding.submissionbmap.data.Team
import com.gnacoding.submissionbmap.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private var favorite = false
    private var _detailBinding: ActivityDetailBinding? = null
    private val detailBinding get() = _detailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _detailBinding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(detailBinding?.root)

        val dataTeam = intent.getParcelableExtra<Team>(EXTRA_DATA) as Team
        detailBinding?.apply {
            ivTeam.let { ivTeam ->
                Glide.with(this@DetailActivity)
                    .load(dataTeam.photo)
                    .into(ivTeam)
            }
            tvTeamName.text = dataTeam.name
            tvOverview.text = dataTeam.overview
            tvHomebase.text = dataTeam.homebase
        }

        setSupportActionBar(detailBinding?.teamToolbar)
        detailBinding?.teamToolbarTitle?.text = dataTeam.name
        supportActionBar?.setDisplayShowTitleEnabled(false)

        detailBinding?.btnBack?.setOnClickListener { onBackPressed() }

        detailBinding?.btnShare?.setOnClickListener {
            val share = Intent()
            share.action = Intent.ACTION_SEND
            share.type = "text/plain"
            share.putExtra(Intent.EXTRA_TEXT, "Look at this Team: ${detailBinding?.tvTeamName?.text}")
            startActivity(Intent.createChooser(share, "Share via"))
        }

        detailBinding?.btnFavorite?.setOnClickListener {
            favorite = if (!favorite) {
                Toast.makeText(this, "Added to Favorite", Toast.LENGTH_SHORT).show()
                detailBinding?.btnFavorite?.setImageResource(R.drawable.ic_favorite)
                true
            } else {
                Toast.makeText(this, "Removed to Favorite", Toast.LENGTH_SHORT).show()
                detailBinding?.btnFavorite?.setImageResource(R.drawable.ic_favorite_border)
                false
            }
        }
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}