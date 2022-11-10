package com.example.mealpicker.fragments.dinner

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mealpicker.R
import com.example.mealpicker.databinding.FragmentDinnerDetailsBinding

class DinnerDetailsFragment : Fragment() {

    private var _binding: FragmentDinnerDetailsBinding? = null
    private val binding get() = _binding!!

    private var mDinnerImageResourceId: Int = 0
    private var mDinnerStringResourceId: Int = 0
    private var mKcal: Int = 0
    private var mCarbs: Int = 0
    private var mFats: Int = 0
    private var mProtein: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? { arguments?.let {
        mDinnerImageResourceId = it.getInt("dinnerImageResourceId")
        mDinnerStringResourceId = it.getInt("dinnerStringResourceId")
        mKcal = it.getInt("dKcal")
        mCarbs = it.getInt("dCarbs")
        mFats = it.getInt("dFats")
        mProtein = it.getInt("dProtein")
    }
        _binding = FragmentDinnerDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updateUI()
    }

    @SuppressLint("SetTextI18n")
    private fun updateUI() {
        binding.dinnerDetailsMealImage.setImageResource(mDinnerImageResourceId)
        binding.dinnerDetailsMealTitle.text = context?.getText(mDinnerStringResourceId)
        binding.dinnerDetailsKcalText.text = "Kcal: $mKcal"
        binding.dinnerDetailsCarbsText.text = "C: $mCarbs"
        binding.dinnerDetailsFatsText.text = "F: $mFats"
        binding.dinnerDetailsProteinText.text = "P: $mProtein"
    }
}