import java.util.ArrayList;

public class Carrinho{
    private ArrayList<Item> itens;

    public Carrinho() {
        itens = new ArrayList<>();
    }

    // Métodos
    public void adicionar(Item item){
        itens.add(item);
    }

    public double total(){
        double total = 0.0;

        for(Item item : itens){

            total += item.getPreco();
        }

        return total;
    }

    public void exibirItens(){
        System.out.println("Carrinho:");

        for(Item item : itens){
            System.out.println("- " + item.getDesc() + ": " + "R$ " + String.format("%.2f", item.getPreco()));
        }

        System.out.println("Total: " + "R$ " + String.format("%.2f", total()));
    }

    public void finalizarCompra(ProcessadorPagamento proc){
        double total = total();

        if(proc.pagar(total)){
            proc.emitirRecibo(total);
        }
        else{
            System.out.println("Pagamento recusado...");
        }
    }
}