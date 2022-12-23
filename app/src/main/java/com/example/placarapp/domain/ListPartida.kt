package com.example.placarapp.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//data class: os atributos já vem encapsulados(GETs e SETs)
@Parcelize
data class ListPartida(
    var id: Int, //a difereça de var e val, npara esse caso, seria que com val temos apenas GETs. a variável não pode ser alterada em tempo de execução
    var time1: Time,
    var time2: Time,
    var estado: TipoEstado,
    val colorFundo: Int
): Parcelable //estende da interface Parcelable, padão do android, permite que as informações trafeguem de forma parcelada/fragmentada

