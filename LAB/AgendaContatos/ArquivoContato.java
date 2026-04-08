import java.io.*;

public class ArquivoContato {
    private static final String ARQUIVO = "contatos.txt";

    public static void salvar(Contato contato) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO, true))) {
            writer.write(contato.toString());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao salvar contato.");
        }
    }

    public static void listar() {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler contatos.");
        }
    }
}