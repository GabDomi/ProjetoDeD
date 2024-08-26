package com.dnd.model

class Halfling : Raca {
    override val nome: String = "Halfling"

    override fun aplicarBonusRacial(personagem: Personagem) {
        personagem.destreza += 2
        personagem.carisma += 1
    }
}
