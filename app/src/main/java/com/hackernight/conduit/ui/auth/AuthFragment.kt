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
import com.hackernight.conduit.databinding.FragmentAuthBinding

class AuthFragment :Fragment(){

    var _binding : FragmentAuthBinding? = null
    private var navController : NavController? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding  = FragmentAuthBinding.inflate(inflater,container,false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = _binding?.let {
            Navigation.findNavController(it.root.findViewById(R.id.nav_host_fragment_auth))
        }

        _binding?.authTabLayout?.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab?.position){
                    0 -> {
                        navController?.navigate(R.id.goToLoginFragment)
                    }
                    1 -> {
                        navController?.navigate(R.id.goToSignupFragment)
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}