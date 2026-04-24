import java.util.Scanner;

public class CaixaRapido {

    public static void main(String[] args) {
        
        Carrinho carrinho = new Carrinho();

        Item item1 = new Item("Café", 8.50);
        Item item2 = new Item("Pão de Queijo", 6.00);
        Item item3 = new Item("Suco", 9.90);

        carrinho.adicionar(item1);
        carrinho.adicionar(item2);
        carrinho.adicionar(item3);

        carrinho.exibirItens();

        Scanner entrada = new Scanner(System.in);
        
        System.out.println("\nSelecione o meio de pagamento [1-Pix, 2-Cartão, 3-Boleto]: ");
        int escolha = entrada.nextInt();
        entrada.nextLine();

        ProcessadorPagamento processador = null;

        switch(escolha) {
            case 1:
                System.out.println("Insira a sua chave Pix: ");
                String chave = entrada.nextLine(); 
                processador = new PagamentoPix(chave);
                break;
                
            case 2:
                System.out.println("Insira o número do cartão: ");
                String numero = entrada.nextLine();
                
                System.out.println("Insira o nome do titular: ");
                String nome = entrada.nextLine();
                
                System.out.println("Insira o CVV: ");
                String cvv = entrada.nextLine();
                
                processador = new PagamentoCartaoCredito(numero, nome, cvv);
                break;
                
            case 3:
                System.out.println("Gerando boleto...");
                processador = new PagamentoBoleto();
                break;
                
            default:
                System.out.println("Opção inválida.");
        }

        if (processador != null) {
            carrinho.finalizarCompra(processador);
        }

        entrada.close();
    }
}