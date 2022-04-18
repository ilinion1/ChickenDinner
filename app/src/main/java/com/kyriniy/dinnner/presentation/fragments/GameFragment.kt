package com.kyriniy.dinnner.presentation.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.kyriniy.dinnner.R
import com.kyriniy.dinnner.databinding.FragmentGameBinding
import com.kyriniy.dinnner.presentation.GameViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class GameFragment : Fragment() {
    lateinit var binding: FragmentGameBinding
    private val viewModel by lazy { ViewModelProvider(requireActivity())[GameViewModel::class.java] }
    var slot1 = 0
    var slot2 = 0
    var slot3 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGameBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setImageStart()
        startGame()
        restartGame()
        binding.btBack.setOnClickListener {
            viewModel.recordList.add(viewModel.maxResult.toString())
            viewModel.countList.add(viewModel.count++.toString())
            viewModel.coin = 100
            viewModel.maxResult = 100
            findNavController().navigate(R.id.action_gameFragment_to_menuFragment)
        }
    }


    /**
     * Задаю картинки по умолчанию в слоты
     */
    private fun setImageStart(){
        binding.tvCoinSum.text = viewModel.coin.toString()
        val startList = listOf(R.drawable.slot1, R.drawable.slot2, R.drawable.slot3, R.drawable.slot4)
        binding.imSlot1.setImageResource(startList[(0..3).random()])
        binding.imSlot2.setImageResource(startList[(0..3).random()])
        binding.imSlot3.setImageResource(startList[(0..3).random()])
    }

    /**
     * Слушатель на кнопку начала игры
     */
    private fun startGame(){
        binding.btStrtGame.setOnClickListener {
            when(viewModel.level){
                "easy" -> {
                    if(viewModel.coin > 0) {
                        viewModel.coin -= 10
                        binding.tvCoinSum.text = viewModel.coin.toString()
                        lifecycleScope.launch {
                            setImageGame()
                            delay(200)
                            setImageGame()
                            delay(200)
                            setImageGame()
                            delay(200)
                            setImageGame()
                            delay(200)
                            setImageGame()
                            set50Coin()
                            set100Coin()
                        }
                    } else {
                        binding.tvResult.visibility = View.VISIBLE
                        binding.tvResult.text = resources
                            .getString(R.string.max_result, viewModel.maxResult.toString())
                        binding.btRestart.visibility = View.VISIBLE
                    }
                }
                "normal" -> {
                    if(viewModel.coin > 0) {
                        viewModel.coin -= 25
                        binding.tvCoinSum.text = viewModel.coin.toString()
                        lifecycleScope.launch {
                            setImageGame()
                            delay(200)
                            setImageGame()
                            delay(200)
                            setImageGame()
                            delay(200)
                            setImageGame()
                            delay(200)
                            setImageGame()
                            set50Coin()
                            set100Coin()
                        }
                    } else {
                        binding.tvResult.visibility = View.VISIBLE
                        binding.tvResult.text = resources
                            .getString(R.string.max_result, viewModel.maxResult.toString())
                        binding.btRestart.visibility = View.VISIBLE
                    }
                }
                "hard" -> {
                    if(viewModel.coin > 0) {
                        viewModel.coin -= 50
                        binding.tvCoinSum.text = viewModel.coin.toString()
                        lifecycleScope.launch {
                            setImageGame()
                            delay(200)
                            setImageGame()
                            delay(200)
                            setImageGame()
                            delay(200)
                            setImageGame()
                            delay(200)
                            setImageGame()
                            set50Coin()
                            set100Coin()
                        }
                    } else {
                        binding.tvResult.visibility = View.VISIBLE
                        binding.tvResult.text = resources
                            .getString(R.string.max_result, viewModel.maxResult.toString())
                        binding.btRestart.visibility = View.VISIBLE
                    }
                }
            }
        }
    }

    private fun restartGame(){
        binding.btRestart.setOnClickListener {
            viewModel.coin = 100
            viewModel.maxResult = 100
            binding.tvCoinSum.text = "100"
            binding.tvResult.visibility = View.GONE
            binding.btRestart.visibility = View.GONE
        }
    }

    private fun setImageGame(){
        val startList = listOf(R.drawable.slot1, R.drawable.slot2, R.drawable.slot3, R.drawable.slot4)
        slot1 = startList[(0..3).random()]
        binding.imSlot1.setImageResource(slot1)
        slot2 = startList[(0..3).random()]
        binding.imSlot2.setImageResource(slot2)
        slot3 = startList[(0..3).random()]
        binding.imSlot3.setImageResource(slot3)
    }

    private fun set50Coin(){
        if (slot1 == R.drawable.slot1 && slot2 == R.drawable.slot1
            ||slot1 == R.drawable.slot1 && slot3 == R.drawable.slot1
            ||slot2 == R.drawable.slot1 && slot3 == R.drawable.slot1){
            viewModel.coin += 50
            binding.tvCoinSum.text = viewModel.coin.toString()
            if (viewModel.coin > viewModel.maxResult) viewModel.maxResult = viewModel.coin
        }
        if (slot1 == R.drawable.slot2 && slot2 == R.drawable.slot2
            ||slot1 == R.drawable.slot2 && slot3 == R.drawable.slot2
            ||slot2 == R.drawable.slot2 && slot3 == R.drawable.slot2){
            viewModel.coin += 50
            binding.tvCoinSum.text = viewModel.coin.toString()
            if (viewModel.coin > viewModel.maxResult) viewModel.maxResult = viewModel.coin
        }
        if (slot1 == R.drawable.slot3 && slot2 == R.drawable.slot3
            ||slot1 == R.drawable.slot3 && slot3 == R.drawable.slot3
            ||slot2 == R.drawable.slot3 && slot3 == R.drawable.slot3){
            viewModel.coin += 50
            binding.tvCoinSum.text = viewModel.coin.toString()
            if (viewModel.coin > viewModel.maxResult) viewModel.maxResult = viewModel.coin
        }
        if (slot1 == R.drawable.slot4 && slot2 == R.drawable.slot4
            ||slot1 == R.drawable.slot4 && slot3 == R.drawable.slot4
            ||slot2 == R.drawable.slot4 && slot3 == R.drawable.slot4){
            viewModel.coin += 50
            binding.tvCoinSum.text = viewModel.coin.toString()
            if (viewModel.coin > viewModel.maxResult) viewModel.maxResult = viewModel.coin
        }
    }

    private fun set100Coin(){
        if (slot1 == R.drawable.slot1 && slot2 == R.drawable.slot1 && slot3 == R.drawable.slot1 ){
            viewModel.coin += 50
            binding.tvCoinSum.text = viewModel.coin.toString()
            if (viewModel.coin > viewModel.maxResult) viewModel.maxResult = viewModel.coin
        }
        if (slot1 == R.drawable.slot2 && slot2 == R.drawable.slot2 && slot3 == R.drawable.slot2 ){
            viewModel.coin += 50
            binding.tvCoinSum.text = viewModel.coin.toString()
            if (viewModel.coin > viewModel.maxResult) viewModel.maxResult = viewModel.coin
        }
        if (slot1 == R.drawable.slot3 && slot2 == R.drawable.slot3 && slot3 == R.drawable.slot3 ){
            viewModel.coin += 50
            binding.tvCoinSum.text = viewModel.coin.toString()
            if (viewModel.coin > viewModel.maxResult) viewModel.maxResult = viewModel.coin
        }
        if (slot1 == R.drawable.slot4 && slot2 == R.drawable.slot4 && slot3 == R.drawable.slot4 ){
            viewModel.coin += 50
            binding.tvCoinSum.text = viewModel.coin.toString()
            if (viewModel.coin > viewModel.maxResult) viewModel.maxResult = viewModel.coin
        }
    }
}