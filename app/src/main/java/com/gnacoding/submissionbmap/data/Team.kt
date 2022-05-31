package com.gnacoding.submissionbmap.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Team(
    var name: String = "",
    var overview: String = "",
    var homebase: String = "",
    var photo: Int = 0
) : Parcelable
