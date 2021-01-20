package com.hackernight.conduit

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.hackernight.api.model.entities.User

class MainActivity : AppCompatActivity() {

    companion object{
        const val PREF_FILE_NAME = "pref_auth"
        const val PREF_KEY_TOKEN = "token"
    }

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var authViewModel: AuthViewModel
    private lateinit var navView : NavigationView
    private lateinit var sharedPreferences : SharedPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //sharedpreference
        sharedPreferences = getSharedPreferences(PREF_FILE_NAME,Context.MODE_PRIVATE);

        authViewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        sharedPreferences.getString(PREF_KEY_TOKEN,null)?.let {token->
            authViewModel.getCurrrentUser(token)
        }

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        navView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_feed,
                R.id.nav_my_feed,
                R.id.nav_auth
        ), drawerLayout)

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        authViewModel.user.observe(this, Observer {
            updateMenu(it)
            navController.navigateUp()

            it?.token.let { t->
                sharedPreferences.edit().apply {
                    putString(PREF_KEY_TOKEN,t).apply()
                }
            }
        })

    }

    private fun updateMenu(it: User?) {
        when(it){
            is User -> {
                navView.menu.clear()
                navView.inflateMenu(R.menu.activity_main)
            }else -> {

            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

}