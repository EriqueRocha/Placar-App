package com.example.placarapp.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Time(
       val id: Int,
       val nome: String
) : Parcelable

