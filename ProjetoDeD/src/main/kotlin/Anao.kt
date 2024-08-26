package com.dnd.model

class Anao : Raca {
    override val nome: String = "Anão"

    override fun aplicarBonusRacial(personagem: Personagem) {
        personagem.constituicao += 2
        personagem.sabedoria += 1
    }
}
