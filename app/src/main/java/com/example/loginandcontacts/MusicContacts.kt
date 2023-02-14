package com.example.loginandcontacts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.loginandcontact.R
import com.example.loginandcontact.databinding.ActivityMediaContactBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * The Navigation component consists of three key parts that are described below.
 *
 *  1. Navigation graph: An XML resource that contains all navigation-related information in one centralized location.
 *      This includes all of the individual content areas within the application, called destinations, as well as the possible
 *      path that a user can take through the application.
 *
 *  2. NavHost: An empty container that displays destinations from the navigation graph. The navigation component contains a default
 *      NavHost implementation, NavHostFragment, that displays fragment destinations.
 *
 *  3. NavController: An object that manages application navigation within a NavHost. The NavController orchestrates the swapping of
 *      destination content in the NavHost as users move throughout the application.
 *
 */
class MusicContacts : AppCompatActivity() {

    private lateinit var binding: ActivityMediaContactBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMediaContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host)
        /**
         * Passing each menu ID as a set of Id's because each menu should be considered as top level destinations.
         */
        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.nav_music, R.id.nav_contacts)
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}