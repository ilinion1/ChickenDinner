package com.kyriniy.dinnner.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.kyriniy.dinnner.R
import com.kyriniy.dinnner.databinding.FragmentDescriptionsBinding


class DescriptionsFragment : Fragment() {
    lateinit var binding: FragmentDescriptionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDescriptionsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listener()
    }

    private fun listener(){
        binding.btBack.setOnClickListener {
            findNavController().navigate(R.id.action_descriptionsFragment_to_menuFragment)
        }
    }

}