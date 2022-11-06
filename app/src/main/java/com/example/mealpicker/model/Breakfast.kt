package com.example.mealpicker.model

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Breakfast(
     val breakfastStringResourceId: Int,
     val breakfastImageResourceId: Int,
     val kcal: Int,
     val carbs: Int,
     val fats: Int,
     val protein: Int
)