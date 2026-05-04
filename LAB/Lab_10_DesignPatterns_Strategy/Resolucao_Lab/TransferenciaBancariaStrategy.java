public class TransferenciaBancariaStrategy implements FormaPagamentoStrategy{
    //Implementação do método abstrato processarPagamento() da interface
    @Override
    public String processarPagamento(double valor){
        return "Pagamento de R$ " + valor + " realizado por meio de transferência bancária.";
    }
}