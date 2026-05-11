import java.util.ArrayList;

public class PainelComposite implements ComponenteGUI{
    private String nome;
    private static final String indentacaoPainel = "";
    private ArrayList<ComponenteGUI> componentes;

    // Construtor do Painel
    public PainelComposite(String nome){
        this.nome = nome;
        this.componentes = new ArrayList<>();
    }

    // Metodos do Painel (é um elemento composto, pode conter outros paineis ou elementos simples)
    // Adiciona um componente (botao, texto ou outro painel) 
    public void adicionarComponente(ComponenteGUI componente){
        componentes.add(componente);
    }

    // Implementacao do metodo renderizar
    // Exibe os detalhes do painel e todos os seus "filhos"
    @Override
    public void renderizar(String indentacaoPainel){
        System.out.println(indentacaoPainel + "Painel " + nome);
        for(ComponenteGUI componente : componentes){
            componente.renderizar(indentacaoPainel + "    ");    // é uma chamada recursiva que exibe os detalhes dos "filhos" até chegar ao elemento folha 
        }
    }
}