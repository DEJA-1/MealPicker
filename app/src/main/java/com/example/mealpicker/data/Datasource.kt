package com.example.mealpicker.data

import android.annotation.SuppressLint
import com.example.mealpicker.R
import com.example.mealpicker.model.Breakfast
import com.example.mealpicker.model.Lunch

class Datasource {

    fun loadBreakfasts(): List<Breakfast> {

        return listOf<Breakfast>(
            Breakfast(R.string.breakfast1, R.drawable.breakfast1, 100, 10, 10, 10),
            Breakfast(R.string.breakfast2, R.drawable.breakfast2, 200, 20, 20, 20),
            Breakfast(R.string.breakfast3, R.drawable.breakfast3, 300, 30, 30, 30),
            Breakfast(R.string.breakfast4, R.drawable.breakfast4, 400, 40, 40, 40),
            Breakfast(R.string.breakfast5, R.drawable.breakfast5, 50, 50, 50, 50),
            Breakfast(R.string.breakfast6, R.drawable.breakfast6, 60, 60, 60, 60)
        )
    }

    fun loadLunches(): List<Lunch> {

        return listOf<Lunch>(
            Lunch(R.string.lunch1, R.drawable.lunch1, 100, 10, 10, 10),
            Lunch(R.string.lunch2, R.drawable.lunch2, 200, 20, 20, 20),
            Lunch(R.string.lunch3, R.drawable.lunch3, 300, 30, 30, 30),
            Lunch(R.string.lunch4, R.drawable.lunch4, 400, 40, 40, 40),
            Lunch(R.string.lunch5, R.drawable.lunch5, 500, 50, 50, 50),
            Lunch(R.string.lunch6, R.drawable.lunch6, 600, 60, 60, 60),
        )
    }

}