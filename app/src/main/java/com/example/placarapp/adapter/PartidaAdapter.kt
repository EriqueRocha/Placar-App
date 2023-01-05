package com.example.placarapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.placarapp.databinding.MainItemBinding
import com.example.placarapp.domain.ListPartida

class PartidaAdapter(private val dataSet: List<ListPartida>, val onClickListener: () -> Unit = {}) : RecyclerView.Adapter<PartidaAdapter.ViewHolder>() {

    class ViewHolder(private val binding: MainItemBinding): RecyclerView.ViewHolder(binding.root){

                  //ligação entre a view e a entidade de dominio
        fun bind(item: ListPartida) = with(binding) {  //função que recebe o elemento em tempo de bind - "with" faz com que todos dentro da função tenão acesso ao elemento de bind
            txtNameTime1.text = item.time1.nome //dizendo qual entidade serve para cada modelo
            txtNameTime2.text = item.time2.nome
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = MainItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = dataSet[position] //posição do item
        viewHolder.bind(item) //passo a posição do item para o ViewHolder

        //val card: LinearLayout = viewHolder.itemView.findViewById(R.id.item_color_container)


       viewHolder.itemView.setOnClickListener{
            onClickListener()
       }


    }

    override fun getItemCount()= dataSet.size


}




