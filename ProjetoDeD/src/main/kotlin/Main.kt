package com.dnd

import com.dnd.model.*
import com.dnd.service.PersonagemService
import com.dnd.strategy.DistribuicaoManualStrategy
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    val personagem = Personagem()
    val distribuicaoStrategy = DistribuicaoManualStrategy()
    val personagemService = PersonagemService(distribuicaoStrategy)
    var executando = true

    while (executando) {
        println(
            """
            ======= Menu de Criação de Personagem =======
            1. Definir Nome
            2. Escolher Raça
            3. Distribuir Pontos de Atributos
            4. Exibir Detalhes do Personagem
            5. Sair
            =============================================
            Selecione uma opção:
            """.trimIndent()
        )

        when (scanner.nextLine()) {
            "1" -> {
                print("Digite o nome do personagem: ")
                val nome = scanner.nextLine()
                personagemService.definirNome(personagem, nome)
            }
            "2" -> {
                val racas = listOf(Humano(), Elfo(), Anao(), Orc(), Halfling())
                println("Escolha uma raça:")
                racas.forEachIndexed { index, raca ->
                    println("${index + 1}. ${raca.nome}")
                }
                print("Digite o número correspondente à raça desejada: ")
                val escolha = scanner.nextLine().toIntOrNull()
                if (escolha != null && escolha in 1..racas.size) {
                    personagemService.definirRaca(personagem, racas[escolha - 1])
                } else {
                    println("Opção inválida. Tente novamente.")
                }
            }
            "3" -> {
                personagemService.distribuirPontos(personagem)
            }
            "4" -> {
                personagem.exibirStatus()
            }
            "5" -> {
                println("Encerrando o programa. Até mais!")
                executando = false
            }
            else -> {
                println("Opção inválida. Por favor, selecione uma opção válida.")
            }
        }
        println()
    }
}
