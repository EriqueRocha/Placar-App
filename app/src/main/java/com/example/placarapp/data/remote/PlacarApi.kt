package com.example.placarapp.data.remote

import com.example.placarapp.domain.ListPartida
import retrofit2.http.GET

import retrofit2.http.Query

interface PlacarApi {
    @GET("partidas/ver-partidas")
    suspend fun findPlacarStatement(@Query("id") partidaHolderId: Int): List<ListPartida>
}