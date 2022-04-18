package com.kyriniy.dinnner.presentation

import androidx.lifecycle.ViewModel

class GameViewModel: ViewModel() {
    var level = "normal"
    var coin = 100
    var maxResult= 100
    var count = 1
    var recordList = arrayListOf<String>()
    var countList = arrayListOf<String>()
}