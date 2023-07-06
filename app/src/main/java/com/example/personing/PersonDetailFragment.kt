package com.example.personing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.personing.model.Person

class PersonDetailFragment : Fragment() {

    private val viewModel: PersonDetailViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentPersonDetailBinding.inflate(inflater)

        viewModel.person.value = arguments?.get("person") as Person

        viewModel.person.observe(viewLifecycleOwner) { person ->
            binding.apply {
                textViewHeadline.text = "Detail Person #${person.id}"
                textViewType.text = person.type.label
                textViewTitle.text = person.firstname
                textViewDescription.text = person.lastname
                textViewUser.text = "${person.user.firstname} ${person.user.lasatname}"
                checkBoxCompleted.isChecked = person.adult
            }
        }
        return binding.root
    }

}