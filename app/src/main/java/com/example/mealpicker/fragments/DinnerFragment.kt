package com.example.mealpicker.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mealpicker.R
import com.example.mealpicker.databinding.FragmentDinnerBinding

class DinnerFragment : Fragment() {

    private var _binding: FragmentDinnerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentDinnerBinding.inflate(inflater, container, false)
        return binding.root
    }

}