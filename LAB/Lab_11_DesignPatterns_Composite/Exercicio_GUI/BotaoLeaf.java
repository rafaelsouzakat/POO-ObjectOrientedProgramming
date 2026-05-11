public class BotaoLeaf implements ComponenteGUI{
    private String mensagem;
    private static final String indentacaoBotao = "    ";

    //Construtor do Botao
    public BotaoLeaf(String mensagem){
        this.mensagem = mensagem;
    }
    
    // Implementacao do metodo renderizar
    @Override
    public void renderizar(String indentacao){
        System.out.println(indentacao + "Botão: " + mensagem);
    }
}