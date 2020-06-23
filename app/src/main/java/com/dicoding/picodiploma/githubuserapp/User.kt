package com.dicoding.picodiploma.githubuserapp

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var name: String = "",
    var username: String = "",
    var company: String = "",
    var location: String = "",
    var avatar: Int = 0,
    var repository: String = "",
    var follower: String = "",
    var following: String = ""
) : Parcelable