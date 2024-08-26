package com.dnd.model
import com.dnd.model.Raca

data class Personagem(
    var nome: String = "",
    var raca: Raca? = null,
    var forca: Int = 8,
    var destreza: Int = 8,
    var constituicao: Int = 8,
    var inteligencia: Int = 8,
    var sabedoria: Int = 8,
    var carisma: Int = 8
) {
    val pontosDeVida: Int
        get() = 10 + modificador(constituicao)

    private fun modificador(valor: Int): Int = (valor - 10) / 2

    fun aplicarBonusRacial() {
        raca?.aplicarBonusRacial(this)
    }

    fun exibirStatus() {
        println("""
            ======= Detalhes do Personagem =======
            Nome: ${nome}
            Raça: ${raca?.nome ?: "Não definida"}
            -------------------------------
            Força: $forca
            Destreza: $destreza
            Constituição: $constituicao
            Inteligência: $inteligencia
            Sabedoria: $sabedoria
            Carisma: $carisma
            -------------------------------
            Pontos de Vida: $pontosDeVida
            ======================================
        """.trimIndent())
    }
}
