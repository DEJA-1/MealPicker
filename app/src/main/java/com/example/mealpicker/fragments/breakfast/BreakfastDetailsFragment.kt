package com.example.mealpicker.fragments.breakfast

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mealpicker.databinding.FragmentBreakfastDetailsBinding

class BreakfastDetailsFragment : Fragment() {

    private var _binding: FragmentBreakfastDetailsBinding? = null
    private val binding get() = _binding!!

    private var mBreakfastStringResourceId: Int = 0
    private var mBreakfastImageResourceId: Int = 0
    private var mKcal: Int = 0
    private var mCarbs: Int = 0
    private var mFats: Int = 0
    private var mProtein: Int = 0


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        arguments?.let {
            mBreakfastImageResourceId = it.getInt("breakfastImageResourceId")
            mBreakfastStringResourceId = it.getInt("breakfastStringResourceId")
            mKcal = it.getInt("bKcal")
            mCarbs = it.getInt("bCarbs")
            mFats = it.getInt("bFats")
            mProtein = it.getInt("bProtein")
        }

        _binding = FragmentBreakfastDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updateUI()
    }

    @SuppressLint("SetTextI18n")
    private fun updateUI() {
        binding.breakfastDetailsMealImage.setImageResource(mBreakfastImageResourceId)
        binding.breakfastDetailsMealTitle.text = context?.getText(mBreakfastStringResourceId)
        binding.breakfastDetailsKcalText.text = "Kcal: $mKcal"
        binding.breakfastDetailsCarbsText.text = "C: $mCarbs"
        binding.breakfastDetailsFatsText.text = "F: $mFats"
        binding.breakfastDetailsProteinText.text = "P: $mProtein"
    }
}