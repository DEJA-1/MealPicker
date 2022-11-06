package com.example.mealpicker.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mealpicker.R
import com.example.mealpicker.databinding.FragmentLunchBinding
import com.example.mealpicker.databinding.FragmentStartBinding

class LunchFragment : Fragment() {

    private var _binding: FragmentLunchBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentLunchBinding.inflate(inflater, container, false)
        return binding.root
    }

}