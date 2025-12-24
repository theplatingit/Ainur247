package com.zelmex

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zelmex.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCalculate.setOnClickListener {
            calculate()
        }
    }

    private fun calculate() {
        val num1 = binding.editNum1.text.toString().toDoubleOrNull()
        val num2 = binding.editNum2.text.toString().toDoubleOrNull()

        if (num1 == null || num2 == null || num1 == 0.0 || num2 == 0.0) {
            binding.tvResult.text = "Введите два ненулевых числа"
            return
        }

        val square1 = num1 * num1
        val square2 = num2 * num2

        val sum = square1 + square2
        val diff = square1 - square2
        val product = square1 * square2
        val quotient = square1 / square2

        val result = """
            Сумма квадратов: $sum
            Разность квадратов: $diff
            Произведение квадратов: $product
            Частное квадратов: ${String.format("%.2f", quotient)}
        """.trimIndent()

        binding.tvResult.text = result
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}