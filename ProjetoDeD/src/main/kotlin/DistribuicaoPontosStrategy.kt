package com.dnd.strategy

import com.dnd.model.Personagem

interface DistribuicaoPontosStrategy {
    fun distribuirPontos(personagem: Personagem)
}
