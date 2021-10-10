package ru.myprojects.melnikov.memory.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.myprojects.melnikov.memory.R
import ru.myprojects.melnikov.memory.databinding.ActivityMainBinding
import ru.myprojects.melnikov.memory.ui.event.EventsFragment
import ru.myprojects.melnikov.memory.ui.holiday.HolidaysFragment
import ru.myprojects.melnikov.memory.ui.profile.ProfileFragment


class MainActivity:AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, EventsFragment())
            .commit()
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.events_bar -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container, EventsFragment())
                        .commit()
                    true
                }
                R.id.holidays_bar -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container, HolidaysFragment())
                        .commit()
                    true
                }
                R.id.profile_bar -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.container, ProfileFragment())
                        .commit()
                    true
                }
                else -> false
            }
        }
    }
}