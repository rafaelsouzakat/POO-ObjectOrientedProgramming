import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n1 - Adicionar contato");
            System.out.println("2 - Listar contatos");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            if (opcao == 1) {
                System.out.print("Nome: ");
                String nome = sc.nextLine();

                System.out.print("Telefone: ");
                String telefone = sc.nextLine();

                System.out.print("Email: ");
                String email = sc.nextLine();

                Contato contato = new Contato(nome, telefone, email);
                ArquivoContato.salvar(contato);

            } else if (opcao == 2) {
                ArquivoContato.listar();
            }

        } while (opcao != 0);

        sc.close();
    }
}