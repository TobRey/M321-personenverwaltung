package com.example.personing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.personing.R
import com.example.personing.model.Type
import com.google.android.material.snackbar.Snackbar

class PersonEditFragment : Fragment() {

    private val viewModel: PersonEditViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentPersonEditBinding.inflate(inflater)
        viewModel.loadTypes()

       /* if(personArg != null )
        {
            viewModel.person.value = personArg
        }*/

        viewModel.types.observe(viewLifecycleOwner) {
            val adapter = ArrayAdapter(requireContext(), R.layout.list_item_type, viewModel.types.value!!)
            binding.autocompleteType
        }

        viewModel.saveSuccessful.observe(viewLifecycleOwner) { success ->
            if(success != null)
            {
                val action =
                    PersonEditFragmentDirections.actionPersonEditFragmentToPersonDetailFragment(
                        viewModel.person.value!!
                    )
                Navigation.findNavController(binding.root).navigate(action)
            }
        }
        binding.apply {

        }

        binding.apply {
            autocompleteType.setOnItemClickListener{ _, _, i, _ ->
                viewModel.type= autocompleteType.adapter.getItem( i ) as Type
            }

            editTextFirstname.addTextChangedListener{
                viewModel.data["title"] = it.toString()
            }

            editTextLastname.addTextChangedListener{
                viewModel.data["title"] = it.toString()
            }

            buttonSave.setOnClickListener {
                if(viewModel.person.value == null && !viewModel.save())
                    Snackbar.make(requireView(), "Something went wrong", Snackbar.LENGTH_SHORT)
            }

            viewModel.saveSuccessful.observer(viewLifecycleOwner) { success ->
                if (success != null && success)
                {
                    Snackbar.make(requireView(), "User successfully updated", Snackbar.LENGTH_SHORT ).show()

                }
                else if (success != null && !success ) {
                    Snackbar.make(requireView(), "Something went wrong", Snackbar.LENGTH_SHORT).show()

                }
                viewModel.saveSuccessful.value = null
            }

            binding.apply{
                btnSaveUser.setOnClickListener {
                    viewModel.saveUser()
                }

                btnSavePassword.setOnClickListener {
                    viewModel.updatePassword()
                }

                inputPassword.addTextChangedListener {
                    viewModel.password["password"] = it.toString()
                }

                inputPasswordRepeat.addTextChangedListener [
                    viewModel.password["password_repeat"] = it.toString()
                ]
            }
        }

        return binding.root
    }

}