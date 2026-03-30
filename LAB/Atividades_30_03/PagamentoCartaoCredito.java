public class PagamentoCartaoCredito implements ProcessadorPagamento {
    private String numero;
    private String nomeTitular;
    private String cvv;
    private double limiteSimulado = 5000.0;
    
    public PagamentoCartaoCredito(String numero, String nomeTitular, String cvv) {
        this.numero = numero;
        this.nomeTitular = nomeTitular;
        this.cvv = cvv;
    }

    @Override
    public boolean pagar(double valor) {
        if(valor <= 0 || valor > limiteSimulado || numero.isBlank() || nomeTitular.isBlank() || cvv.isBlank()) {
            System.out.println("Pagamento no cartão recusado");
            return false;
        }

        System.out.println("Processando pagamento no cartão de crédito...");
        emitirRecibo(valor);

        return true; 
    }
}