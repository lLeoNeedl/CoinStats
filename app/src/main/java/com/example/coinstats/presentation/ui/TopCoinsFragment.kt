package com.example.coinstats.presentation.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.coinstats.R
import com.example.coinstats.databinding.FragmentTopCoinsBinding
import com.example.coinstats.presentation.viewmodel.CoinStatsViewModel

class TopCoinsFragment : Fragment() {

    private var _binding: FragmentTopCoinsBinding? = null
    private val binding: FragmentTopCoinsBinding
        get() = _binding ?: throw RuntimeException("FragmentTopCoinsBinding == null")
    private val viewModel by lazy {
        ViewModelProvider(this)[CoinStatsViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTopCoinsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.textViewCoin.setOnClickListener {
            viewModel.loadData()
        }
//        viewModel.list.observe(viewLifecycleOwner) {
//            Log.d("MyTopCoinsFragment", it.toString())
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}