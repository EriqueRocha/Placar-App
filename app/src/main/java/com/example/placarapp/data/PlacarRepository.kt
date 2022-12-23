package com.example.placarapp.data

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.liveData
import com.example.placarapp.data.remote.PlacarApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PlacarRepository {

    private val TAG = javaClass.simpleName

    private val restApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PlacarApi::class.java)

    }

    fun findPlacarStatement(partidaId: Int) = liveData{
        emit(State.Wait)
        try {
            emit(State.Success(data = restApi.findPlacarStatement(partidaId)))
        }catch (e: Exception){
            Log.e(TAG, e.message, e)
            emit(State.Error(e.message))
        }
    }
}