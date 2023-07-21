package com.example.activityandfragmentconnectiontest.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.activityandfragmentconnectiontest.R
import com.example.activityandfragmentconnectiontest.second.SecondFragment
import com.example.activityandfragmentconnectiontest.SharedViewModel
import com.example.activityandfragmentconnectiontest.databinding.FirstFragmentBinding

class FirstFragment : Fragment() {
    private var _binding: FirstFragmentBinding? = null
    private val binding get() = _binding!!

    private val sharedViewModel : SharedViewModel by activityViewModels()
    private val firstViewModel : FirstViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FirstFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn1.setOnClickListener {
            firstViewModel.incrementCounter()
        }

        binding.btn2.setOnClickListener {
            findNavController().navigate(R.id.ToSecondFragment)
        }

        binding.btn3.setOnClickListener {
            sharedViewModel.showSnackBar("First fragment snack bar")
        }

        firstViewModel.counter.observe(viewLifecycleOwner) {
            binding.tv2.text = it.toString()
        }
    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}