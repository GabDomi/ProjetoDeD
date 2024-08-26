package com.dnd.service

import com.dnd.model.Personagem
import com.dnd.model.Raca
import com.dnd.strategy.DistribuicaoPontosStrategy

class PersonagemService(private val distribuicaoStrategy: DistribuicaoPontosStrategy) {

    fun definirNome(personagem: Personagem, nome: String) {
        personagem.nome = nome
        println("Nome definido como: $nome")
    }

    fun definirRaca(personagem: Personagem, raca: Raca) {
        personagem.raca = raca
        println("Raça definida como: ${raca.nome} e bônus raciais aplicados.")
    }

    fun distribuirPontos(personagem: Personagem) {
        distribuicaoStrategy.distribuirPontos(personagem)
        personagem.aplicarBonusRacial()
    }
}
