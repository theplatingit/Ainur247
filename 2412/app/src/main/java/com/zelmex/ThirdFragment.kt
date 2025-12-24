package com.zelmex

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zelmex.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnConvert.setOnClickListener {
            convert()
        }
    }

    private fun convert() {
        val fahrenheit = binding.editFahrenheit.text.toString().toDoubleOrNull()

        if (fahrenheit == null) {
            binding.tvResult.text = "Введите температуру"
            return
        }

        val celsius = (fahrenheit - 32) * 5 / 9
        binding.tvResult.text = "${String.format("%.2f", fahrenheit)} °F = ${String.format("%.2f", celsius)} °C"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}