package com.hackernight.conduit.ui.auth

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayout
import com.hackernight.conduit.R

class AuthFragment :Fragment(){

    private var navController : NavController? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root  = inflater.inflate(R.layout.fragment_auth,container,false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //authtablayout listener setup
        val authTabLayout : TabLayout = view.findViewById(R.id.authTabLayout)

        navController = Navigation.findNavController(view)

        authTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab?.position){
                    0 -> {
                        navController?.navigate(R.id.goToLoginFragment)
                        Log.d("ITEM","Item 1 Clicked")
                    }
                    1 -> {
                        navController?.navigate(R.id.goToSignupFragment)
                        Log.d("ITEM","Item 2 Clicked")
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

    }

}