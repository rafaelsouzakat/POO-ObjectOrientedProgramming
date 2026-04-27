import java.util.ArrayList;

public class Menu {
    private ArrayList<Produto> produtos;

    //Construtor
    public Menu() {
        produtos = new ArrayList<>();
    }

    //Metodos
    public void adicionarProduto(Produto produto) {
        if(produto == null) {
            throw new NullPointerException("Produto não pode ser nulo.");
        }

        if(produtos.size() >= 5) {
            throw new IllegalArgumentException("Limite de 5 produtos atingido.");
        }
        
        produtos.add(produto);
    }

    public void exibirProdutos() {
        System.out.println("Produtos no menu:");

        for(Produto produto : produtos) {
            System.out.println("- " + produto.getNome() + ": R$ " + produto.getPreco());
        }
    }

    public void calcularMediaPreco() {
        try{
            double soma = 0.0;

            for(Produto produto : produtos) {
                soma += produto.getPreco();
            }

            double media = soma / produtos.size();
            System.out.println("Preço médio dos produtos: R$ " + media);
        }
        catch(ArithmeticException e){
            System.out.println("Erro: divisão por zero!");
        }
        catch(NullPointerException e){
            System.out.println("Erro: produto nulo encontrado!");
        }
    }

    public void consultarPorPosicao(int posicao){
        try {
            Produto p = produtos.get(posicao);
            System.out.println("Produto encontrado:");
            System.out.println(p.getNome() + " - R$ " + p.getPreco());
        } 
        catch (IndexOutOfBoundsException e) {
            System.out.println("Posição inválida!");
        }
    }
}