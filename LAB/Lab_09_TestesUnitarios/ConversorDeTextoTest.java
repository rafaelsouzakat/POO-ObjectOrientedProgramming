import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConversorDeTextoTest {

    private ConversorDeTexto conversor;

    @BeforeEach
    void setup() {
        // Instancia a classe sob teste antes de cada caso
        conversor = new ConversorDeTexto();
    }

    // -------------------------
    // capitalizarPalavras
    // -------------------------

    @Test
    void capitalizarPalavrasTest() {
        // String
        String entrada = "java é divertido";
        //ação
        String resultado = conversor.capitalizarPalavras(entrada);
        // Assert
        assertEquals("Java É Divertido", resultado); //Testa com o valor errado
    }

    @Test
    void capitalizarPalavrasExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> conversor.capitalizarPalavras(null));
        assertThrows(IllegalArgumentException.class, () -> conversor.capitalizarPalavras("   "));
    }

    // -------------------------
    // inverterPalavras
    // -------------------------

    @Test
    void inverterPalavrasTest() {
        // String
        String entrada = "ola mundo bonito";
        //ação
        String resultado = conversor.inverterPalavras(entrada);
        // Assert
        assertEquals("bonito mundo ola", resultado);
    }

    @Test
    void inverterPalavrasExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> conversor.inverterPalavras(null));
        assertThrows(IllegalArgumentException.class, () -> conversor.inverterPalavras("   "));
    }

    // -------------------------
    // contarVogais
    // -------------------------

    @Test
    void contarVogaisTest() {
        // String
        String entrada1 = "BanAna";
        String entrada2 = "rhythms";
        //ação
        int qtd1 = conversor.contarVogais(entrada1); //deve retornar 3 vogais
        int qtd2 = conversor.contarVogais(entrada2);  // deve retornar 0 vogais
        // Assert
        assertEquals(3, qtd1);
        assertEquals(0, qtd2);
    }

    @Test
    void contarVogaisExceptionTest(){
        assertThrows(IllegalArgumentException.class, () -> conversor.contarVogais(null));
    }
    
    //Exercício de sala: criar um método de teste para o metodo ehPalindromo
    @Test
    void ehPalindromoTest(){
        // Valores de teste (String)
        String entrada1 = "arara";
        String entrada2 = "java";
        // Ação
        boolean resultado1 = conversor.ehPalindromo(entrada1); // deve retornar true
        boolean resultado2 = conversor.ehPalindromo(entrada2); // deve retornar false
        // Assert
        assertTrue(resultado1);
        assertFalse(resultado2);
    }

    @Test
    void ehPalindromoExceptionTest(){
        assertFalse(conversor.ehPalindromo(null));
        assertFalse(conversor.ehPalindromo("   "));
    }

    // Nota: estou criando o método de teste para o método removerPalavrasCurtas
    @Test
    void removerPalavrasCurtasTest(){
        // Valores de teste (String texto, int tamanhoMinimo)
        String texto = "hoje é um lindo dia";
        int tamanhoMinimo = 3;
        // Ação
        String resultado = conversor.removerPalavrasCurtas(texto, tamanhoMinimo); // deve retornar "hoje lindo dia"
        // Assert
        assertEquals("hoje lindo dia", resultado);
    }

    @Test
    void removerPalavrasCurtasExceptionTest(){
        assertThrows(IllegalArgumentException.class, () -> conversor.removerPalavrasCurtas(null, 3));
    }

    // A partir daqui vou criar todos os métodos de teste restantes para cada método da classe ConversorDeTexto
    // -------------------------
    // substituirPalavra
    // -------------------------
    @Test
    void substituirPalavraTest(){
        // Valores de teste (String texto, String alvo, String nova)
        String texto = "java é legal";
        String alvo = "java";
        String nova = "python";
        // Ação
        String resultado = conversor.substituirPalavra(texto, alvo, nova); // deve retornar "python é legal"
        // Assert
        assertEquals("python é legal", resultado);
    }

    @Test
    void substituirPalavraExceptionTest(){
        assertThrows(IllegalArgumentException.class, () -> conversor.substituirPalavra(null, "java", "python"));
        assertThrows(IllegalArgumentException.class, () -> conversor.substituirPalavra("java é legal", null, "python"));
        assertThrows(IllegalArgumentException.class, () -> conversor.substituirPalavra("java é legal", "java", null));
    }

    // -------------------------
    // contarPalavras
    // -------------------------
    @Test 
    void contarPalavrasTest(){
        // Valores de teste (String)
        String texto = "Java é muito legal";
        // Ação
        int resultado = conversor.contarPalavras(texto); // deve retornar 4
        // Assert
        assertEquals(4, resultado);
    }

    @Test 
    void contarPalavrasExceptionTest(){
        assertEquals(0, conversor.contarPalavras(null));
        assertEquals(0, conversor.contarPalavras("   "));
    }

    // -------------------------
    // inverterLetrasPorPalavra
    // -------------------------
    @Test 
    void inverterLetrasPorPalavraTest(){
        //Valores de teste (String)
        String texto = "java é Legal";
        // Ação
        String resultado = conversor.inverterLetrasPorPalavra(texto); // deve retornar "avaj é lageL"
        // Assert
        assertEquals("avaj é lageL", resultado);
    }

    @Test 
    void inverterLetrasPorPalavraExceptionTest(){
        assertThrows(IllegalArgumentException.class, () -> conversor.inverterLetrasPorPalavra(null));
        assertThrows(IllegalArgumentException.class, () -> conversor.inverterLetrasPorPalavra("   "));
    }
}