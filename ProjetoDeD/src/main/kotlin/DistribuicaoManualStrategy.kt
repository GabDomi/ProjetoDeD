package com.dnd.strategy

import com.dnd.model.Personagem
import java.util.Scanner

class DistribuicaoManualStrategy : DistribuicaoPontosStrategy {
    private val custoPorValor = mapOf(
        8 to 0,
        9 to 1,
        10 to 2,
        11 to 3,
        12 to 4,
        13 to 5,
        14 to 7,
        15 to 9
    )

    private fun calcularModificador(valor: Int): Int {
        return (valor - 10) / 2
    }

    override fun distribuirPontos(personagem: Personagem) {
        val scanner = Scanner(System.`in`)
        var pontosDisponiveis = 27
        val atributos = mutableMapOf(
            "Força" to 8,
            "Destreza" to 8,
            "Constituição" to 8,
            "Inteligência" to 8,
            "Sabedoria" to 8,
            "Carisma" to 8
        )

        println("Você tem $pontosDisponiveis pontos para distribuir entre os atributos.")
        atributos.forEach { (atributo, valorAtual) ->
            var valorValido = false
            while (!valorValido) {
                println("$atributo (Atual: $valorAtual). Insira um valor entre 8 e 15:")
                val input = scanner.nextLine().toIntOrNull()
                if (input != null && input in 8..15) {
                    val custo = custoPorValor[input]!!
                    val custoAtual = custoPorValor[valorAtual]!!
                    val custoTotal = custo - custoAtual

                    if (pontosDisponiveis - custoTotal >= 0) {
                        atributos[atributo] = input
                        pontosDisponiveis -= custoTotal
                        println("Atributo $atributo definido como $input. Pontos restantes: $pontosDisponiveis\n")
                        valorValido = true
                    } else {
                        println("Pontos insuficientes. Você tem apenas $pontosDisponiveis pontos restantes.")
                    }
                } else {
                    println("Entrada inválida. Por favor, insira um número entre 8 e 15.")
                }
            }
        }

        personagem.forca = atributos["Força"]!!
        personagem.destreza = atributos["Destreza"]!!
        personagem.constituicao = atributos["Constituição"]!!
        personagem.inteligencia = atributos["Inteligência"]!!
        personagem.sabedoria = atributos["Sabedoria"]!!
        personagem.carisma = atributos["Carisma"]!!

        val modificadores = mapOf(
            "Força" to calcularModificador(personagem.forca),
            "Destreza" to calcularModificador(personagem.destreza),
            "Constituição" to calcularModificador(personagem.constituicao),
            "Inteligência" to calcularModificador(personagem.inteligencia),
            "Sabedoria" to calcularModificador(personagem.sabedoria),
            "Carisma" to calcularModificador(personagem.carisma)
        )

        println("Distribuição de pontos concluída!")
        println("Modificadores aplicados:")
        modificadores.forEach { (atributo, modificador) ->
            println("$atributo: $modificador")
        }
    }
}
