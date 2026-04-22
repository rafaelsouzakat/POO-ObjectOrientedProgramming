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
        // assertAll permite executar varios assertEquals simultaneamente
        assertAll(
            ()->assertEquals(3, qtd1),
            ()->assertEquals(0, qtd2),
            ()->assertThrows(IllegalArgumentException.class,()->conversor.contarVogais(null)) //assertThrows pede 2 argumentos
        );
    }
    
    //Exercício de sala: criar um método de teste para o metodo ehPalindromo
    @Test
    void ehPalindromoTest(){
        // Valores de teste (String)
        String entrada1 = "arara";
        String entrada2 = "java";
        // Ação
        boolean resultado1 = conversor.ehPalindromo(entrada1) // deve retornar true
        boolean resultado2 = conversor.ehPalindromo(entrada2) // deve retornar false
        // Assert
        assertAll(
            ()->assertTrue(resultado1),
            ()->assertFalse(resultado2),
            ()->assertFalse(conversor.ehPalindromo(null)),
            ()->assertFalse(conversor.ehPalindromo("    ")))
        );
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
        assertEquals("hoje lindo dia" , resultado);
        assertThrows(IllegalArgumentException.class, () -> conversor.removerPalavrasCurtas(null, tamanhoMinimo));
    }
}