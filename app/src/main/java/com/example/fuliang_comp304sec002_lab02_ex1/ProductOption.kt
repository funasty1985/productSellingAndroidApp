package com.example.fuliang_comp304sec002_lab02_ex1

import android.os.Parcel
import android.os.Parcelable

data class ProductOption(
    val title: String,
    val image: Int,
    var isChecked: Boolean,
    val type: String,
    var isSelected: Boolean = false
)