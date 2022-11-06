package com.example.mealpicker.model

data class Lunch(
        val lunchStringResourceId: Int,
        val lunchImageResourceId: Int,
        val kcal: Int,
        val carbs: Int,
        val fats: Int,
        val protein: Int,
)