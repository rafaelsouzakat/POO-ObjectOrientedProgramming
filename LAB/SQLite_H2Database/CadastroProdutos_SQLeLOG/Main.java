import java.util.Scanner;
import java.util.List;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // Nome do arquivo de log definido no exercício
        String logPath = "loja.log";
        
        // Instancia o gerenciador com o nome do banco
        GerenciarBD db = new GerenciarBD("loja.db");
        Scanner scanner = new Scanner(System.in);

        // Ao iniciar, verifica se a tabela existe (Requisito 4)
        try {
            db.criarTabelaSeNaoExistir();
            FileTools.appendLog(logPath, "INFO", "Sistema iniciado: Tabela verificada/criada.");
        } catch (SQLException e) {
            FileTools.appendLog(logPath, "ERRO", "Falha ao inicializar banco de dados.", e);
            System.out.println("Erro crítico ao conectar ao banco. Verifique o arquivo de log.");
            return; 
        }

        int opcao = -1;

        // Menu principal (Requisito 3 e 5)
        while (opcao != 0) {
            System.out.println("\n--- SISTEMA DE GESTÃO DE PRODUTOS ---");
            System.out.println("1 - Adicionar produto");
            System.out.println("2 - Listar todos os produtos");
            System.out.println("3 - Listar estoque baixo");
            System.out.println("4 - Atualizar quantidade em estoque");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();
                    System.out.print("Quantidade: ");
                    int qtde = scanner.nextInt();

                    try {
                        db.adicionarProduto(nome, preco, qtde);
                        System.out.println("Produto cadastrado!");
                        FileTools.appendLog(logPath, "INFO", "Produto cadastrado: " + nome);
                    } catch (SQLException e) {
                        System.out.println("Erro ao cadastrar produto.");
                        FileTools.appendLog(logPath, "ERRO", "Erro ao inserir produto: " + nome, e);
                    }
                    break;

                case 2:
                    try {
                        List<GerenciarBD.ProdutoDTO> produtos = db.listarTodosProdutos();
                        System.out.println("\n--- ESTOQUE ATUAL ---");
                        for (GerenciarBD.ProdutoDTO p : produtos) {
                            System.out.println("ID: " + p.id + " | " + p.nome + " | R$ " + p.preco + " | Qtd: " + p.quantidade);
                        }
                        FileTools.appendLog(logPath, "INFO", "Consulta de estoque realizada.");
                    } catch (SQLException e) {
                        System.out.println("Erro ao listar produtos.");
                        FileTools.appendLog(logPath, "ERRO", "Falha na consulta de estoque.", e);
                    }
                    break;

                case 3:
                    System.out.print("Defina o limite para estoque baixo: ");
                    int limite = scanner.nextInt();
                    try {
                        List<GerenciarBD.ProdutoDTO> baixo = db.listarEstoqueBaixo(limite);
                        System.out.println("\n--- ALERTA DE ESTOQUE BAIXO ---");
                        for (GerenciarBD.ProdutoDTO p : baixo) {
                            System.out.println(p.nome + " (Qtd: " + p.quantidade + ")");
                        }
                        FileTools.appendLog(logPath, "INFO", "Consulta de estoque baixo (Limite: " + limite + ").");
                    } catch (SQLException e) {
                        FileTools.appendLog(logPath, "ERRO", "Falha na consulta de alerta.", e);
                    }
                    break;

                case 4:
                    System.out.print("ID do produto: ");
                    int id = scanner.nextInt();
                    System.out.print("Nova quantidade: ");
                    int novaQtd = scanner.nextInt();

                    try {
                        int resultado = db.atualizarQuantidade(id, novaQtd);
                        if (resultado > 0) {
                            System.out.println("Estoque atualizado!");
                            FileTools.appendLog(logPath, "INFO", "Estoque atualizado para ID: " + id);
                        } else {
                            System.out.println("Produto não encontrado.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Erro na atualização.");
                        FileTools.appendLog(logPath, "ERRO", "Falha ao atualizar ID: " + id, e);
                    }
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    FileTools.appendLog(logPath, "INFO", "Sistema encerrado pelo usuário.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }
}