package com.example.placarapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.placarapp.adapter.PartidaAdapter
import com.example.placarapp.data.State
import com.example.placarapp.databinding.ActivityMainBinding
import com.example.placarapp.domain.ListPartida
import com.google.android.material.snackbar.Snackbar

//tela inicial, listas de partidas
class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    private val viewModel by viewModels<PlacarStatementViewModel>() //gera a instancia dos viewmodels

    private val dataSet = mutableListOf<ListPartida>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.rvMain.layoutManager = LinearLayoutManager(this)

        binding.rvMain.adapter = PartidaAdapter(dataSet){
            Intent(this@MainActivity, ControlarPartida::class.java)
        }

        binding.srlListPartida.setOnRefreshListener { findListPartida() }

        findListPartida()

        cadastrarPartida()
    }

    private fun findListPartida() {
        
        viewModel.findPlacarStatement(binding.rvMain.id).observe(this){state ->
            when(state){
                is State.Error -> {
                    state.message?.let { Snackbar.make(binding.rvMain, it, Snackbar.LENGTH_LONG).show() }
                    binding.srlListPartida.isRefreshing = false
                }
                is State.Success -> {

                    binding.rvMain.adapter = state.data?.let { PartidaAdapter(it) }

                    state.data?.let { dataSet.addAll(it)}

                    binding.rvMain.adapter?.notifyDataSetChanged()

                    binding.srlListPartida.isRefreshing = false

                }

                State.Wait -> binding.srlListPartida.isRefreshing = true
            }

        }
    }


    private fun cadastrarPartida(){
        binding.buttonCadastrarPartida.setOnClickListener{
            val intent = Intent(this, AdicionarPartida::class.java)
            startActivity(intent)
        }
    }
}