package com.example.personing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.personing.R
import com.example.personing.databinding.FragmentPersonOverviewBinding
import com.example.personing.ui.PersonAdapter

class PersonOverviewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentPersonOverviewBinding.inflate(inflater)
        val adapter = PersonAdapter()

        binding.apply {
            recyclerViewPersons.adapter = adapter
            recyclerViewPersons.layoutManager = LinearLayoutManager(requireContext())
            recyclerViewPersons.setHasFixedSize(true)

            fabAddPerson.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.action_personOverviewFragment_to_personEditFragment)
            }
        }

        return binding.root
    }

}