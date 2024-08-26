package com.dnd.model

class Orc : Raca {
    override val nome: String = "Orc"

    override fun aplicarBonusRacial(personagem: Personagem) {
        personagem.forca += 2
        personagem.constituicao += 1
    }
}
