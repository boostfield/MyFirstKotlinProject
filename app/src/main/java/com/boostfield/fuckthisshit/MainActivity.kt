package com.boostfield.fuckthisshit

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var fragmentManager: FragmentManager? = null
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                supportActionBar?.title = "home"
                val fragment = HomeFragment.newInstance()
                val transaction = fragmentManager?.beginTransaction()
                transaction?.replace(R.id.frame, fragment)
                transaction?.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                supportActionBar?.title = "timeline"
                val fragment = TimeLineFragment.newInstance()
                val transaction = fragmentManager?.beginTransaction()
                transaction?.replace(R.id.frame, fragment)
                transaction?.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                supportActionBar?.title = "profile"
                val fragment = ProfileFragment.newInstance()
                val transaction = fragmentManager?.beginTransaction()
                transaction?.replace(R.id.frame, fragment)
                transaction?.commit()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentManager = supportFragmentManager
        val fragment = HomeFragment.newInstance()
        val transaction = fragmentManager?.beginTransaction()
        transaction?.replace(R.id.frame, fragment)
        transaction?.commit()
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

}
