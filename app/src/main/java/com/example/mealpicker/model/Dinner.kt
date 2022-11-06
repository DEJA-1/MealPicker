package com.example.mealpicker.model

data class Dinner(
    val dinnerStringResourceId: Int,
    val dinnerImageResourceId: Int,
    val kcal: Int,
    val carbs: Int,
    val fats: Int,
    val protein: Int,
)