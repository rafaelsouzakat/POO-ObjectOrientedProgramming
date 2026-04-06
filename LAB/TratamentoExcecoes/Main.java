import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        Menu menu = new Menu();
        int opcao = 0;

        do {
            System.out.println("\n1 - Adicionar produto");
            System.out.println("2 - Exibir produtos");
            System.out.println("3 - Calcular média");
            System.out.println("4 - Consultar por posição");
            System.out.println("0 - Sair");

            try {
                System.out.print("Escolha: ");
                opcao = entrada.nextInt();
                entrada.nextLine();

                switch (opcao) {
                    case 1:
                        try {
                            System.out.print("Nome: ");
                            String nome = entrada.nextLine();

                            System.out.print("Preço: ");
                            double preco = entrada.nextDouble();

                            Produto p = new Produto(nome, preco);
                            menu.adicionarProduto(p);

                        } catch (InputMismatchException e) {
                            System.out.println("Erro: preço inválido!");
                            entrada.nextLine();
                        } catch (IllegalArgumentException | NullPointerException e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 2:
                        menu.exibirProdutos();
                        break;

                    case 3:
                        menu.calcularMediaPreco();
                        break;

                    case 4:
                        try {
                            System.out.print("Escolha a posição: ");
                            int pos = entrada.nextInt();
                            menu.consultarPorPosicao(pos);
                        } catch (InputMismatchException e) {
                            System.out.println("Erro: digite um número inteiro!");
                            entrada.nextLine();
                        }
                        break;

                    case 0:
                        System.out.println("Saindo...");
                        break;

                    default:
                        System.out.println("Opção inválida!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Erro: entrada inválida!");
                entrada.nextLine();
            }

        } while (opcao != 0);

        entrada.close();
    }
}