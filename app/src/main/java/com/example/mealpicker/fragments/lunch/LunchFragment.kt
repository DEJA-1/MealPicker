package com.example.mealpicker.fragments.lunch

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealpicker.R
import com.example.mealpicker.adapter.LunchAdapter
import com.example.mealpicker.data.Datasource
import com.example.mealpicker.databinding.FragmentLunchBinding
import com.example.mealpicker.model.Lunch

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //recyclerView
        val lunchList = Datasource().loadLunches()
        val adapter = LunchAdapter(requireContext(), lunchList)
        val recyclerView = binding.lunchRecyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //random meal navigation
        binding.lunchFab.setOnClickListener { onFabClicked(lunchList) }
    }

    private fun onFabClicked(lunchList: List<Lunch>) {
        findNavController().navigate(R.id.action_lunchFragment_to_lunchDetailsFragment)
        val randomLunch = getRandomLunch(lunchList)
        Toast.makeText(context, "Drawed: ${randomLunch.kcal}", Toast.LENGTH_SHORT)
            .show()
    }

    private fun getRandomLunch(lunchList: List<Lunch>) : Lunch {
        return lunchList.random()
    }
}