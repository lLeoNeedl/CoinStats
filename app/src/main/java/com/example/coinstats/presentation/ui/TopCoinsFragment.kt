package com.example.coinstats.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.coinstats.R
import com.example.coinstats.databinding.FragmentTopCoinsBinding

class TopCoinsFragment : Fragment() {

    private var _binding: FragmentTopCoinsBinding? = null
    private val binding: FragmentTopCoinsBinding
        get() = _binding ?: throw RuntimeException("FragmentTopCoinsBinding == null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTopCoinsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}