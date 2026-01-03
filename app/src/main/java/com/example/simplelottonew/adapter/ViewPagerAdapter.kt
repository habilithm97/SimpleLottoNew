package com.example.simplelottonew.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.simplelottonew.ui.fragment.FragmentC
import com.example.simplelottonew.ui.fragment.FragmentB
import com.example.simplelottonew.ui.fragment.LottoSimulationFragment

// FragmentStateAdapter : ViewPager2가 제공하는 어댑터 클래스, 각 화면을 프래그먼트로 구성할 때 사용
class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    private val fragments = listOf(
        LottoSimulationFragment(),
        FragmentB(),
        FragmentC()
    )

    override fun createFragment(position: Int): Fragment {
        return fragments[position] // 해당 위치의 프래그먼트 인스턴스를 반환
    }

    override fun getItemCount(): Int {
        return fragments.size
    }
}