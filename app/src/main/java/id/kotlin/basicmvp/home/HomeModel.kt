package id.kotlin.basicmvp.home

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HomeModel(
    val title: String,
    val description: String
) : Parcelable