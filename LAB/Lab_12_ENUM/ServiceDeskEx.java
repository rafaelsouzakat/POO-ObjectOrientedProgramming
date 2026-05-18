import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/* ===================== ENUM ===================== */
// Enum representa conjunto fechado de prioridades (tipo seguro)
enum NivelPrioridade {
    BAIXA, MEDIA, ALTA, CRITICA;    // Constantes do enum (valores de prioridade)

    public String getDescricao(){
        switch(this){
            case BAIXA:
                return "Prioridade Baixa. O atendimento será resolvido pelo Suporte Básico.";
            case MEDIA:
                return "Prioridade Média. O atendimento será resolvido pelo Suporte Básico.";
            case ALTA:
                return "Prioridade Alta. O atendimento será resolvido pelo Suporte Avançado.";
            case CRITICA:
                return "Prioridade Crítica. O atendimento será resolvido pelo Suporte Avançado.";
            default:
                return "";
        }
    }
}

/* ===================== INTERFACE ===================== */
// Contrato para serviços de atendimento
interface Atendimento {
    // Método abstrato
    public String resolverChamado(Chamado chamado);  // Deve retornar uma string descrevendo a ação realizada.
}

/* ===================== ENTIDADES (COMPOSIÇÃO) ===================== */
// Representa o cliente que abriu o chamado (nome e email)
class Cliente {
    // Atributos do cliente
    private String nome;
    private String email;

    // Construtor da classe Cliente
    public Cliente(String nome, String email){
        this.nome = nome;
        this.email = email;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}

// Representa o chamado; possui um Cliente (composição)
class Chamado {
    // Atributos da prioridade
    private int id;
    private String descricao;
    private NivelPrioridade prioridade;
    private Cliente cliente;

    // Construtor da classe Chamado
    public Chamado(int id, String descricao, NivelPrioridade prioridade, Cliente cliente){
        this.id = id;
        this.descricao = descricao;
        this.prioridade = prioridade;
        this.cliente = cliente;
    }

    // Métodos do Chamado
    public void validar(){
        if(cliente == null){
            throw new IllegalArgumentException("O cliente não pode ser nulo.");
        }
        if(cliente.getNome() == null || cliente.getNome().isBlank() || cliente.getEmail() == null || cliente.getEmail().isBlank() || descricao == null || descricao.isBlank()){
            throw new IllegalArgumentException("Os atributos nome, email e descrição do cliente não podem ser nulos ou vazios.");
        }
        if(prioridade == null){
            throw new IllegalArgumentException("A prioridade do chamado não pode ser nula.");
        }
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public NivelPrioridade getPrioridade() {
        return prioridade;
    }

    public Cliente getCliente() {
        return cliente;
    }

}

/* ===================== IMPLEMENTAÇÕES DA INTERFACE ===================== */
// Suporte N1: resolve BAIXA e MEDIA
class SuporteBasico implements Atendimento {
    @Override
    public String resolverChamado(Chamado chamado){
        switch(chamado.getPrioridade()){
            case BAIXA:
                return "Suporte Básico: Chamado de prioridade BAIXA resolvido.";
            case MEDIA:
                return "Suporte Básico: Chamado de prioridade MEDIA resolvido.";
            default:
                return "O Suporte Básico não resolve chamadas de prioridade" + chamado.getPrioridade() +  ", Encaminhar ao Suporte Avançado.";
        }
    }
}

// Suporte N2: resolve ALTA e CRITICA
class SuporteAvancado implements Atendimento {
    @Override
    public String resolverChamado(Chamado chamado){
        switch(chamado.getPrioridade()){
            case ALTA:
                return "Suporte Avançado: Chamado de prioridade ALTA resolvido.";
            case CRITICA:
                return "Suporte Avançado: Chamado de prioridade CRITICA resolvido.";
            default:
                return "O Suporte Avançado não resolve chamadas de prioridade" + chamado.getPrioridade() +  ", Encaminhar ao Suporte Básico.";
        }
    }

}

/* ===================== CLASSE PRINCIPAL ===================== */
// Classe principal: orquestra o fluxo, interação e persistência
public class ServiceDeskEx {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            // 1 Exibir prioridades disponíveis
            System.out.println("Prioridades disponíveis:");

            for (NivelPrioridade np : NivelPrioridade.values()) {
                System.out.println("- " + np);
            }

            // 2 Ler dados do usuário
            System.out.print("\nNome do cliente: ");
            String nome = sc.nextLine();

            System.out.print("E-mail: ");
            String email = sc.nextLine();

            System.out.print("Descrição do chamado: ");
            String descricao = sc.nextLine();

            System.out.print("Prioridade (BAIXA, MEDIA, ALTA, CRITICA): ");
            String prioridadeTexto = sc.nextLine().toUpperCase();

            // Converter String -> Enum
            NivelPrioridade prioridade =
                    NivelPrioridade.valueOf(prioridadeTexto);

            // 3 Criar objetos
            Cliente cliente = new Cliente(nome, email);

            Chamado chamado =
                    new Chamado(1, descricao, prioridade, cliente);

            // 4 Validar chamado
            chamado.validar();

            // 5 Escolher suporte correto
            Atendimento atendimento;

            switch (prioridade) {

                case BAIXA:
                case MEDIA:
                    atendimento = new SuporteBasico();
                    break;

                case ALTA:
                case CRITICA:
                    atendimento = new SuporteAvancado();
                    break;

                default:
                    throw new IllegalArgumentException(
                            "Prioridade inválida."
                    );
            }

            // 6 Resolver chamado
            String resolucao =
                    atendimento.resolverChamado(chamado);

            // 7 Montar linha para salvar no arquivo
            String linha = "ID: " + chamado.getId()
                    + " | Cliente: " + chamado.getCliente().getNome()
                    + " | Email: " + chamado.getCliente().getEmail()
                    + " | Prioridade: " + chamado.getPrioridade()
                    + " | Resolução: " + resolucao;

            // Exibir no console
            System.out.println("\n" + linha);

            // 8 Gravar no arquivo
            try (
                    FileWriter fw =
                            new FileWriter("chamados.txt", true);

                    PrintWriter pw =
                            new PrintWriter(fw)
            ) {

                pw.println(linha);

                System.out.println(
                        "\nChamado gravado com sucesso em chamados.txt"
                );

            } catch (IOException e) {

                System.out.println(
                        "Erro ao gravar arquivo: " + e.getMessage()
                );
            }

        } catch (IllegalArgumentException e) {

            System.out.println(
                    "Erro de validação: " + e.getMessage()
            );

        } catch (Exception e) {

            System.out.println(
                    "Erro inesperado: " + e.getMessage()
            );

        } finally {

            sc.close();
        }
    }
}