package com.example.testapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MyCar(val name: String, val mark: String, val desc: String, val fullDesc: String) : Parcelable