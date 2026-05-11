

public class Main{
    public static void main(String[] args) {
        // Criacao de botoes e textos (elementos folha)
        ComponenteGUI botao1 = new BotaoLeaf("Salvar");
        ComponenteGUI texto1 = new TextoLeaf("Bem Vindo!");
        ComponenteGUI botao2 = new BotaoLeaf("Cancelar");
        ComponenteGUI texto2 = new TextoLeaf("Mensagem interna");

        // Criacao de paineis (composite)
        PainelComposite painelPrincipal = new PainelComposite("Principal");
        PainelComposite painelInterno = new PainelComposite("Interno");

        //Montagem da estrutura hierarquica
        painelPrincipal.adicionarComponente(botao1);
        painelPrincipal.adicionarComponente(texto1);
        painelPrincipal.adicionarComponente(painelInterno);

        painelInterno.adicionarComponente(botao2);
        painelInterno.adicionarComponente(texto2);

        // Exibicao da estrutura hierarquica por meio do metodo renderizar do Painel Principal
        painelPrincipal.renderizar("");
    }
}