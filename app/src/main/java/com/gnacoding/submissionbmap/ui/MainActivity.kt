package com.gnacoding.submissionbmap.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.gnacoding.submissionbmap.adapter.TeamAdapter
import com.gnacoding.submissionbmap.data.Team
import com.gnacoding.submissionbmap.data.TeamData
import com.gnacoding.submissionbmap.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var teamAdapter: TeamAdapter
    private var teams = ArrayList<Team>()
    private var _mainBinding: ActivityMainBinding? = null
    private val mainBinding get() = _mainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding?.root)

        teams.addAll(TeamData.listData)

        mainBinding?.aboutPage?.setOnClickListener {
            val mIntent = Intent(this, AboutActivity::class.java)
            startActivity(mIntent)
        }

        mainBinding?.rvTeams?.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            teamAdapter = TeamAdapter(teams)
            adapter = teamAdapter
        }
    }
}