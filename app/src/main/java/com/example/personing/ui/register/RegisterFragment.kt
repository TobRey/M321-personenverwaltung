package com.example.personing.ui.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.personing.R
import com.example.personing.databinding.FragmentRegisterBinding
import com.google.android.material.snackbar.Snackbar

class RegisterFragment : Fragment() {

    private val viewModel: RegisterViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentRegisterBinding.inflate(inflater)

        binding.apply {
            buttonRegister.setOnClickListener {
                if( viewModel.register() )
                {
                    Navigation.findNavController(it).navigate(R.id.action_registerFragment_to_loginFragment)
                }
                else
                {
                    Snackbar.make( requireView(), "Fields invalid", Snackbar.LENGTH_SHORT ).show()
                }
            }

            inputEmail.addTextChangedListener {
                viewModel.data["email"] = it.toString()
            }

            inputFirstname.addTextChangedListener {
                viewModel.data["firstname"] = it.toString()
            }

            inputLastname.addTextChangedListener {
                viewModel.data["lastname"] = it.toString()
            }

            inputPassword.addTextChangedListener {
                viewModel.data["password"] = it.toString()
            }

            inputPasswordRepeat.addTextChangedListener {
                viewModel.data["password_repeat"] = it.toString()
            }
        }

        return binding.root
    }

}