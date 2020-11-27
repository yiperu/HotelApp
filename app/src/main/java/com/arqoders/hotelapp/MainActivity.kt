package com.arqoders.hotelapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.arqoders.hotelapp.Cache.CacheFragment
import com.arqoders.hotelapp.Details.DetailsFragment
import com.arqoders.hotelapp.Home.HomeFragment
import com.arqoders.hotelapp.Preference.PreferenceFragment
import com.arqoders.hotelapp.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val homeFragment = HomeFragment()
        val detailsFragment = DetailsFragment()
        val cacheFragment = CacheFragment()
        val preferenceFragment = PreferenceFragment()

        makeCurrentFragment(homeFragment)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
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