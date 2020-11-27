package com.arqoders.hotelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.arqoders.hotelapp.Cache.CacheFragment
import com.arqoders.hotelapp.Details.DetailsFragment
import com.arqoders.hotelapp.Home.HomeFragment
import com.arqoders.hotelapp.Preference.PreferenceFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val detailsFragment = DetailsFragment()
        val cacheFragment = CacheFragment()
        val preferenceFragment = PreferenceFragment()

        makeCurrentFragment(homeFragment)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.ic_home -> makeCurrentFragment(homeFragment)
                R.id.ic_favo -> makeCurrentFragment(detailsFragment)
                R.id.ic_prof -> makeCurrentFragment(cacheFragment)
                R.id.ic_sett -> makeCurrentFragment(preferenceFragment)
            }
            true
        }

    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.containerFrameLayout, fragment)
            commit()
        }


}