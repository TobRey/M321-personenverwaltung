package com.example.personing.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.personing.R
import com.example.personing.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentLoginBinding.inflate(inflater)

        binding.apply {

            buttonLogin.setOnClickListener {
                viewModel.login( editTextEmail.text.toString(), editTextPassword.text.toString() )
                //Navigation.findNavController(it).navigate( R.id.action_loginFragment_to_ticketOverviewFragment )
            }

            buttonRegister.setOnClickListener {
                Navigation.findNavController(it).navigate(R.id.action_loginFragment_to_registerFragment)
            }
        }

        return binding.root
    }
}