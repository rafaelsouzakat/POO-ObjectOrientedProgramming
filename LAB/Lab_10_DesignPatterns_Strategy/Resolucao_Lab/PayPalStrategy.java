public class PayPalStrategy implements FormaPagamentoStrategy{
    //Implementação do método abstrato processarPagamento() da interface
    @Override
    public String processarPagamento(double valor){
        return "Pagamento de R$ " + valor + " realizado com Pay Pal.";
    }
}