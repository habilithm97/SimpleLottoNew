package com.example.simplelottonew.ui.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.simplelottonew.R
import com.example.simplelottonew.adapter.ViewPagerAdapter
import com.example.simplelottonew.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        initView()
    }

    private fun initView() {
        setupViewPager()
    }

    private fun setupViewPager() {
        with(binding) {
            val viewPagerAdapter = ViewPagerAdapter(this@MainActivity)
            viewPager.adapter = viewPagerAdapter

            val tabTitles = listOf(
                R.string.tab_title_1,
                R.string.tab_title_2,
                R.string.tab_title_3
            )
            TabLayoutMediator(tabs, viewPager) { tab, position ->
                tab.text = getString(tabTitles[position])
            }.attach()
        }
    }
}