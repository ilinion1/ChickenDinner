package com.kyriniy.dinnner.presentation.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.kyriniy.dinnner.R
import com.kyriniy.dinnner.databinding.FragmentSetingsBinding
import com.kyriniy.dinnner.presentation.GameViewModel


class SettingsFragment : Fragment() {
    lateinit var binding: FragmentSetingsBinding
    lateinit var viewModel: GameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSetingsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[GameViewModel::class.java]
        when(viewModel.level){
            "easy" -> {
                binding.rdEasy.isChecked = true
                binding.rdEasy.setTextColor(Color.parseColor("#0077c2"))
            }
            "normal" -> {
                binding.rdNormal.isChecked = true
                binding.rdNormal.setTextColor(Color.parseColor("#0077c2"))
            }
            "hard" -> {
                binding.rdHard.isChecked = true
                binding.rdHard.setTextColor(Color.parseColor("#0077c2"))
            }
        }
        setColorRdButton()
        listener()
    }

    /**
     * Слушатель на нажите назад
     */
    private fun listener(){
        binding.btBack.setOnClickListener {
            findNavController().navigate(R.id.action_setingsFragment_to_menuFragment)
        }
    }

    /**
     * Задаю цвет текста при переключении и записываю во viewModel какое было выбрано значание
     */
    private fun setColorRdButton(){
        binding.rdEasy.setOnClickListener {
            binding.rdEasy.setTextColor(Color.parseColor("#0077c2"))
            binding.rdNormal.setTextColor(ContextCompat.getColor(requireActivity(),R.color.black))
            binding.rdHard.setTextColor(ContextCompat.getColor(requireActivity(),R.color.black))
            viewModel.level = "easy"
        }
        binding.rdNormal.setOnClickListener {
            binding.rdNormal.setTextColor(Color.parseColor("#0077c2"))
            binding.rdEasy.setTextColor(ContextCompat.getColor(requireActivity(),R.color.black))
            binding.rdHard.setTextColor(ContextCompat.getColor(requireActivity(),R.color.black))
            viewModel.level = "normal"
        }
        binding.rdHard.setOnClickListener {
            binding.rdHard.setTextColor(Color.parseColor("#0077c2"))
            binding.rdNormal.setTextColor(ContextCompat.getColor(requireActivity(),R.color.black))
            binding.rdEasy.setTextColor(ContextCompat.getColor(requireActivity(),R.color.black))
            viewModel.level = "hard"
        }
    }

}