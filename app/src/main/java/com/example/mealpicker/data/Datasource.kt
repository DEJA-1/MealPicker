package com.example.mealpicker.data

import android.annotation.SuppressLint
import com.example.mealpicker.R
import com.example.mealpicker.model.Breakfast

class Datasource {

    @SuppressLint("ResourceType")
    fun loadBreakfasts(): List<Breakfast> {

        return listOf<Breakfast> (
            Breakfast(R.string.breakfast1, R.drawable.breakfast1, 100, 10, 10, 10),
            Breakfast(R.string.breakfast2, R.drawable.breakfast2, 200, 20, 20, 20),
            Breakfast(R.string.breakfast3, R.drawable.breakfast3, 300, 30, 30, 30),
            Breakfast(R.string.breakfast4, R.drawable.breakfast4, 400, 40, 40, 40),
            Breakfast(R.string.breakfast5, R.drawable.breakfast5, 50, 50, 50, 50),
            Breakfast(R.string.breakfast6, R.drawable.breakfast6, 60, 60, 60, 60)
                )
    }

}