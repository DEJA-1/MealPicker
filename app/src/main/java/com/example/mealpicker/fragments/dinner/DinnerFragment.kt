package com.example.mealpicker.fragments.dinner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mealpicker.R
import com.example.mealpicker.adapter.DinnerAdapter
import com.example.mealpicker.data.Datasource
import com.example.mealpicker.databinding.FragmentDinnerBinding
import com.example.mealpicker.model.Dinner

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //recyclerView
        val dinnerList = Datasource().loadDinners()
        val adapter = DinnerAdapter(requireContext(), dinnerList)
        val recyclerView = binding.dinnerRecyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //random meal navigation
        binding.dinnerFab.setOnClickListener { onFabClicked(dinnerList) }
    }

    private fun onFabClicked(dinnerList: List<Dinner>) {
//        findNavController().navigate(R.id.action_dinnerFragment_to_DetailsFragment)
        val randomDinner = getRandomDinner(dinnerList)
        Toast.makeText(context, "Draw: ${randomDinner.carbs}", Toast.LENGTH_SHORT)
            .show()
    }

    private fun getRandomDinner(dinnerList: List<Dinner>) : Dinner {
        return dinnerList.random()
    }
}