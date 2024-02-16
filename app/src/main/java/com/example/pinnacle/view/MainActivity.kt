package com.example.pinnacle.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.pinnacle.fragments.FlightFragment
import com.example.pinnacle.fragments.HomeFragment
import com.example.pinnacle.fragments.SettingsFragment
import com.example.pinnacle.fragments.TrainFragment
import com.example.pinnacle.R
import com.example.pinnacle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

//        Method call for base fragment
        replaceFragment(HomeFragment())

//        Bottom Nav Bar Item Selection
        mainBinding.MainActivityBNV.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.Home_tab -> replaceFragment(HomeFragment())
                R.id.Flight_tab -> replaceFragment(FlightFragment())
                R.id.Train_tab -> replaceFragment(TrainFragment())
                R.id.Settings_tab -> replaceFragment(SettingsFragment())
            }
            true
        }
    }

    /**
     * @param fragment
     * Method for change fragment from Bottom Nav bar
     */
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(mainBinding.MainActivityNavHostFragment.id, fragment)
        fragmentTransaction.commit()
    }
}