package com.kyriniy.dinnner.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.kyriniy.dinnner.R
import com.kyriniy.dinnner.databinding.FragmentRecordBinding
import com.kyriniy.dinnner.presentation.GameViewModel
import com.kyriniy.dinnner.presentation.RecordAdapter
import javax.inject.Inject


class RecordFragment : Fragment() {
    lateinit var binding: FragmentRecordBinding
    private val viewModel by lazy{ ViewModelProvider(requireActivity())[GameViewModel::class.java] }
  lateinit var adapter: RecordAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecordBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = RecordAdapter()
        binding.rcView.adapter = adapter
        adapter.gameList.clear()
        adapter.countList.clear()
        adapter.gameList.addAll(viewModel.recordList)
        adapter.countList.addAll(viewModel.countList)
        listener()
    }

    private fun listener(){
        binding.btBack.setOnClickListener {
            findNavController().navigate(R.id.action_recordFragment_to_menuFragment)
        }
    }

}