package com.zelmex

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zelmex.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSwap.setOnClickListener {
            swapValues()
        }
    }

    private fun swapValues() {
        val a = binding.editA.text.toString()
        val b = binding.editB.text.toString()

        if (a.isEmpty() || b.isEmpty()) {
            binding.tvResult.text = "Введите оба значения"
            return
        }

        binding.editA.setText(b)
        binding.editB.setText(a)

        binding.tvResult.text = "A = $b, B = $a (значения поменялись местами)"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}