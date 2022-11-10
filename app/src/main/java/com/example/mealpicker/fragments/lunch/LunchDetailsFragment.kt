package com.example.mealpicker.fragments.lunch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mealpicker.R
import com.example.mealpicker.databinding.FragmentBreakfastDetailsBinding
import com.example.mealpicker.databinding.FragmentLunchDetailsBinding

class LunchDetailsFragment : Fragment() {

    private var _binding: FragmentLunchDetailsBinding? = null
    private val binding get() = _binding!!

    private var mLunchImageResourceId: Int = 0
    private var mLunchStringResourceId: Int = 0
    private var mKcal: Int = 0
    private var mCarbs: Int = 0
    private var mFats: Int = 0
    private var mProtein: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { arguments?.let {
        mLunchImageResourceId = it.getInt("lunchImageResourceId")
        mLunchStringResourceId = it.getInt("lunchStringResourceId")
        mKcal = it.getInt("lKcal")
        mCarbs = it.getInt("lCarbs")
        mFats = it.getInt("lFats")
        mProtein = it.getInt("lProtein")
    }
        _binding = FragmentLunchDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updateUI()
    }

    private fun updateUI() {
        binding.lunchDetailsMealImage.setImageResource(mLunchImageResourceId)
        binding.lunchDetailsMealTitle.text = context?.getText(mLunchStringResourceId)
        binding.lunchDetailsKcalText.text = "Kcal: $mKcal"
        binding.lunchDetailsCarbsText.text = "C: $mCarbs"
        binding.lunchDetailsFatsText.text = "F: $mFats"
        binding.lunchDetailsProteinText.text = "P: $mProtein"
    }

}