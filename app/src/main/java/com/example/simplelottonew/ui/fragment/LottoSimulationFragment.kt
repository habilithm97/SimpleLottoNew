package com.example.simplelottonew.ui.fragment

import android.os.Bundle
import android.util.Log
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupBtnGenerate()
    }

    private fun setupBtnGenerate() {
        binding.btnGenerate.setOnClickListener {
            val lottoNums = createLottoNumbers()
            Log.d("LottoSimulationFragment", lottoNums.toString())
        }
    }

    // 1~45 범위의 숫자를 섞은 후 6개를 뽑아 오름차순으로 정렬한 로또 번호 생성
    private fun createLottoNumbers(): List<Int> =
        // shuffled() : 내부적으로 새 리스트를 만들어서 섞기 때문에 원본 훼손 안 함 (안전)
        (1..45).shuffled().take(6).sorted()

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}