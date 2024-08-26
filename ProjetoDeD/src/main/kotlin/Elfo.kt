package com.dnd.model

class Elfo : Raca {
    override val nome: String = "Elfo"

    override fun aplicarBonusRacial(personagem: Personagem) {
        personagem.destreza += 2
        personagem.inteligencia += 1
    }
}
