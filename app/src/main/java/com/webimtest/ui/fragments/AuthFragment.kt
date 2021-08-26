package com.webimtest.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.webimtest.R
import com.webimtest.databinding.FragmentAuthBinding
import com.webimtest.ui.viewmodel.AuthViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


@AndroidEntryPoint
class AuthFragment : Fragment() {

    private val viewModelAuth: AuthViewModel by viewModels(ownerProducer = ::requireParentFragment)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val binding = FragmentAuthBinding.inflate(inflater, container, false)


        binding.buttonSignIn.setOnClickListener {

            val login = binding.login.text?.trim().toString()
            val pass = binding.password.text?.trim().toString()

            if (binding.login.text?.isEmpty() == true && binding.password.text?.isEmpty() == true) {
                Toast.makeText(this.context, "Введите логин и пароль", Toast.LENGTH_SHORT).show()
            } else {
                viewModelAuth.authentication(login, pass)
            }
        }

        viewModelAuth.stateAuth.observe(viewLifecycleOwner) {
            if (!it) {
                Toast.makeText(
                    this.context,
                    "Введите правильный логин и пароль",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                findNavController().navigate(R.id.action_authFragment_to_feedFragment)
            }
        }

        return binding.root
    }

}