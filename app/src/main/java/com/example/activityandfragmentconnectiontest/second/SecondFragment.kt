package com.example.activityandfragmentconnectiontest.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.activityandfragmentconnectiontest.SharedViewModel
import com.example.activityandfragmentconnectiontest.databinding.SecondFragmentBinding

class SecondFragment : Fragment() {
    private var _binding: SecondFragmentBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel: SharedViewModel by activityViewModels()
    private val secondViewModel: SecondViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = SecondFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn1.setOnClickListener {
            secondViewModel.incrementCounter()
        }

        binding.btn2.setOnClickListener {
            sharedViewModel.showSnackBar("Second fragment snack bar")
        }


        secondViewModel.counter.observe(viewLifecycleOwner) {
            binding.tv2.text = it.toString()
        }

    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}