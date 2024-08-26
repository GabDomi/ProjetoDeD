package com.dnd.model
import com.dnd.model.Personagem

interface Raca {
    val nome: String
    fun aplicarBonusRacial(personagem: Personagem)
}
