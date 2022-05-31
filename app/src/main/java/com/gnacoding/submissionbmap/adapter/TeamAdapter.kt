package com.gnacoding.submissionbmap.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gnacoding.submissionbmap.data.Team
import com.gnacoding.submissionbmap.databinding.ItemTeamBinding
import com.gnacoding.submissionbmap.ui.DetailActivity
import com.gnacoding.submissionbmap.ui.DetailActivity.Companion.EXTRA_DATA

class TeamAdapter(
    private val listTeam: ArrayList<Team>
) : RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val binding = ItemTeamBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TeamViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bind(listTeam[position])
    }

    override fun getItemCount(): Int = listTeam.size

    inner class TeamViewHolder(private val binding: ItemTeamBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(team: Team) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(team.photo)
                    .into(ivTeam)
                tvName.text = team.name
                tvOverview.text = team.overview
                itemView.setOnClickListener {
                    val mIntent = Intent(itemView.context, DetailActivity::class.java)
                    mIntent.putExtra(EXTRA_DATA, team)
                    itemView.context.startActivity(mIntent)
                }
            }
        }
    }
}