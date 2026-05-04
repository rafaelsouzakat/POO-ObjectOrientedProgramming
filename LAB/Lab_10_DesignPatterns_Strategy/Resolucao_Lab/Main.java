public class Main{
    public static void main(String[] args){
        //Criando uma instância de teste para LojaOnline com Cartão de Crédito
        LojaOnline loja1 = new LojaOnline(new CartaoCreditoStrategy());
        loja1.finalizarCompra(49.99);

        //Criando uma instância de teste para LojaOnline com PayPal
        LojaOnline loja2 = new LojaOnline(new PayPalStrategy());
        loja2.finalizarCompra(25.00);

        //Criando uma instância de teste para LojaOnline com Transferência Bancária
        LojaOnline loja3 = new LojaOnline(new TransferenciaBancariaStrategy());
        loja3.finalizarCompra(99.99);
    }
}