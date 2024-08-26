import com.dnd.model.Personagem
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PersonagemTest {

    @Test
    fun testPontosDeVida() {
        // Criar uma instância do personagem
        val personagem = Personagem()

        // Definir o valor de constituição
        personagem.constituicao = 14

        // Calcular os pontos de vida esperados
        val pontosDeVidaEsperados = 10 + (personagem.constituicao - 10) / 2

        // Verificar se o cálculo dos pontos de vida está correto
        assertEquals(pontosDeVidaEsperados, personagem.pontosDeVida)
    }
}
