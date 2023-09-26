package com.example.activityandfragmentconnectiontest.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.example.activityandfragmentconnectiontest.R
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

        val localNavController =
            (childFragmentManager.findFragmentById(R.id.nested_nav_host) as NavHostFragment).navController
        sharedViewModel.updateNavController(localNavController)

    }


    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}