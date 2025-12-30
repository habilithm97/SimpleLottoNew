package com.example.simplelottonew.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.simplelottonew.databinding.FragmentLottoSimulationBinding

class LottoSimulationFragment : Fragment() {
    private var _binding: FragmentLottoSimulationBinding? = null
    private val binding get() = _binding!!

    private val ballList: List<TextView>
        get() = with(binding) { // get() : 호출될 때마다 새로 가져옴
            listOf(ball1, ball2, ball3, ball4, ball5, ball6)
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLottoSimulationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}