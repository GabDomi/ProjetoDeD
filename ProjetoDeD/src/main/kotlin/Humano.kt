package com.dnd.model

class Humano : Raca {
    override val nome: String = "Humano"

    override fun aplicarBonusRacial(personagem: Personagem) {
        personagem.forca += 1
        personagem.destreza += 1
        personagem.constituicao += 1
        personagem.inteligencia += 1
        personagem.sabedoria += 1
        personagem.carisma += 1
    }
}
