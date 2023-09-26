package com.example.activityandfragmentconnectiontest

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.activityandfragmentconnectiontest.databinding.ForthFragmentBinding

class ForthFragment : Fragment() {

    private var _binding: ForthFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ForthFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}