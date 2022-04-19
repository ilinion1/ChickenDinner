package com.kyriniy.dinnner.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.findNavController
import com.kyriniy.dinnner.R
import com.kyriniy.dinnner.databinding.FragmentMenuBinding
import com.kyriniy.dinnner.presentation.GameViewModel


class MenuFragment : Fragment() {
    lateinit var binding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listenersClick()
    }

    /**
     * Слушатели нажатий
     */
    private fun listenersClick() = with(binding){
        btStartGame.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_gameFragment)
        }
        btInstruction.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_descriptionsFragment)
        }
        btSettings.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_setingsFragment)
        }
        btRecord.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_recordFragment)
        }
    }
}