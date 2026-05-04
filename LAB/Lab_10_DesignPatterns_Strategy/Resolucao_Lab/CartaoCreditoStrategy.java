public class CartaoCreditoStrategy implements FormaPagamentoStrategy{
    //Implementação do método abstrato processarPagamento() da interface
    @Override
    public String processarPagamento(double valor){
        return "Pagamento de R$ " + valor + " realizado com Cartão de Crédito.";
    }
}