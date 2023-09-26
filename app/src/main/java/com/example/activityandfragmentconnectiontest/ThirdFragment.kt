package com.example.activityandfragmentconnectiontest

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.activityandfragmentconnectiontest.databinding.ThirdFragmentBinding

class ThirdFragment : Fragment() {
    private var _binding: ThirdFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ThirdFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btn1.setOnClickListener {
        }

        binding.btn2.setOnClickListener {
            findNavController().navigate(R.id.ToForthFragment)
        }
    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}