public class TextoLeaf implements ComponenteGUI{
    private String texto;
    private  static final String indentacaoTexto = "    ";

    //Construtor da classe texto
    public TextoLeaf(String texto){
        this.texto = texto;
    }

    // Implementacao do metodo renderizar
    @Override
    public void renderizar(String indentacao){
        System.out.println(indentacao + "Texto: " + texto); 
    }
}