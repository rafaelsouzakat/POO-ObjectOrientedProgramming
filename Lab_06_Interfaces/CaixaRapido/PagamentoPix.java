public class PagamentoPix implements ProcessadorPagamento {
    private String chavePix;

    public PagamentoPix(String chavePix) {
        this.chavePix = chavePix;
    }

    @Override
    public boolean pagar(double valor) {
        if(valor <= 0) {
            System.out.println("Valor inválido para pagamento.");
            return false;
        }
        
        System.out.println("Processando PIX...");
        emitirRecibo(valor);
        
        return true;
    }
}