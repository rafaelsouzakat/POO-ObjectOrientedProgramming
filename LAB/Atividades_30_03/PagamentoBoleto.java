import java.util.UUID;

public class PagamentoBoleto implements ProcessadorPagamento {
    @Override
    public boolean pagar(double valor) {
        if(valor <= 0) {
            System.out.println("Valor inválido para pagamento.");
            return false;
        }

        String linhaDigitavel =  UUID.randomUUID().toString();
        System.out.println("Processando pagamento via boleto...");
        System.out.println("Digite as instruções com linha digitável: " + linhaDigitavel);
        emitirRecibo(valor);

        return true; 
    }
}

