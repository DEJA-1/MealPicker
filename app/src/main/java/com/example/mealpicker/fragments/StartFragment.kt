package com.example.mealpicker.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mealpicker.R
import com.example.mealpicker.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //breakfast
        binding.buttonBreakfast.setOnClickListener { onButtonBreakfastClicked() }

        //lunch
        binding.buttonLunch.setOnClickListener { onButtonLunchClicked() }

        //dinner
        binding.buttonDinner.setOnClickListener { onButtonDinnerClicked() }
    }

    private fun onButtonBreakfastClicked() {
        findNavController().navigate(R.id.action_startFragment_to_breakfastFragment)
    }

    private fun onButtonLunchClicked() {
        findNavController().navigate(R.id.action_startFragment_to_lunchFragment)
    }

    private fun onButtonDinnerClicked() {
        findNavController().navigate(R.id.action_startFragment_to_dinnerFragment)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}