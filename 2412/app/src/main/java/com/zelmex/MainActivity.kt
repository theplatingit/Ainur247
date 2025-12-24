package com.zelmex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.zelmex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // По умолчанию открываем первый фрагмент
        setNewFragment(FirstFragment())

        binding.btnFragment1.setOnClickListener {
            setNewFragment(FirstFragment())
        }

        binding.btnFragment2.setOnClickListener {
            setNewFragment(SecondFragment())
        }

        binding.btnFragment3.setOnClickListener {
            setNewFragment(ThirdFragment())
        }
    }

    private fun setNewFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout, fragment)
            .commit()
    }
}