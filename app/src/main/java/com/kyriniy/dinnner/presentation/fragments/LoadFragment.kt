package com.kyriniy.dinnner.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.kyriniy.dinnner.R
import com.kyriniy.dinnner.databinding.FragmentLoadBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class LoadFragment : Fragment() {
    lateinit var binding: FragmentLoadBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoadBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            delay(3000)
            findNavController().navigate(R.id.action_loadFragment_to_menuFragment)
        }
    }
}