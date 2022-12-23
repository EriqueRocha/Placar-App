package com.example.placarapp.ui

import androidx.lifecycle.ViewModel
import com.example.placarapp.data.PlacarRepository

class PlacarStatementViewModel: ViewModel() {

    fun findPlacarStatement(partidaHolderId: Int) =
        PlacarRepository.findPlacarStatement(partidaHolderId)
}