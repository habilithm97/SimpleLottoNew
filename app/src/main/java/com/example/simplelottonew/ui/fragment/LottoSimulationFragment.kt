package com.example.simplelottonew.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.simplelottonew.R
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

        initView()
    }

    private fun initView() {
        binding.btn.setOnClickListener {
            val lottoNums = createLottoNumbers()
            Log.d("LottoSimulationFragment", lottoNums.toString())

            // (ball, num) Pair를 구조 분해 선언으로 받아 순서대로 처리
            ballList.zip(lottoNums).forEach { (ball, num) ->
                ball.text = num.toString()
                setBallColor(ball, num) // 각 ball에 num과 color 적용
            }
        }
    }

    // 1~45 범위의 숫자를 섞은 후 6개를 뽑아 오름차순으로 정렬한 로또 번호 생성
    private fun createLottoNumbers(): List<Int> =
        // shuffled() : 내부적으로 새 리스트를 만들어서 섞기 때문에 원본 훼손 안 함 (안전)
        (1..45).shuffled().take(6).sorted()

    private fun setBallColor(ball: TextView, num: Int) {
        val drawableRes = when (num) {
            in 1..10 -> R.drawable.ball_yellow
            in 11..20 -> R.drawable.ball_blue
            in 21..30 -> R.drawable.ball_red
            in 31..40 -> R.drawable.ball_gray
            else -> R.drawable.ball_green
        }
        ball.background = ContextCompat.getDrawable(requireContext(), drawableRes)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        _binding = null
    }
}