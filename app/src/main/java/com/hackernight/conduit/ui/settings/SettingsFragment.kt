package com.hackernight.conduit.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.hackernight.conduit.databinding.FragmentSettingsBinding
import com.hackernight.conduit.AuthViewModel

class SettingsFragment : Fragment() {

    private var _binding : FragmentSettingsBinding? = null
    private val authViewModel by activityViewModels<AuthViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentSettingsBinding.inflate(inflater,container,false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        authViewModel.user.observe(viewLifecycleOwner, Observer {
            _binding?.apply {
                imageEditText.setText(it?.image ?: "")
                userNameEditText.setText(it?.username ?: "")
                bioEditText.setText(it?.bio ?: "")
                emailEditText.setText(it?.email ?: "")
            }
        })

        _binding?.apply {
            updateButton.setOnClickListener {
                authViewModel.updateUser(
                        bioEditText.text.toString(),
                        userNameEditText.text.toString(),
                        imageEditText.text.toString(),
                        emailEditText.text.toString(),
                        passwordEditText.text.toString()
                        )
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}