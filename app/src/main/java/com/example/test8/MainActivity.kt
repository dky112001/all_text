package com.example.test8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentGet(Homefragment())

        var bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavBar)

        bottomNav.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.home -> fragmentGet(Homefragment())
                R.id.profile -> fragmentGet(ProfileFragment())
                R.id.setting -> fragmentGet(SettingFragment())
            }

         true
        }


    }

    fun fragmentGet(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.fragmentShow,fragment).commit()

    }

}