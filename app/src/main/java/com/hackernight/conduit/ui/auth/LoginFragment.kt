package com.hackernight.conduit.ui.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.google.android.material.button.MaterialButton
import com.hackernight.conduit.R

class LoginFragment :Fragment(){

    val authViewModel: AuthViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root  = inflater.inflate(R.layout.fragment_login_signup,container,false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val loginButton :MaterialButton = view.findViewById(R.id.loginButton)
        val emailEditText : EditText = view.findViewById(R.id.emailEditText)
        val passwordEditText : EditText = view.findViewById(R.id.passwordEditText)

        loginButton.setOnClickListener {
            authViewModel.login(
                    emailEditText.text.toString(),
                    passwordEditText.text.toString()
            )
        }

    }

}