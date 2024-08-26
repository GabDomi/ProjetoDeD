import com.dnd.model.Personagem
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PersonagemTest {

    @Test
    fun testPontosDeVida() {
        val personagem = Personagem()

        personagem.constituicao = 14

        val pontosDeVidaEsperados = 10 + (personagem.constituicao - 10) / 2

        assertEquals(pontosDeVidaEsperados, personagem.pontosDeVida)
    }
}
