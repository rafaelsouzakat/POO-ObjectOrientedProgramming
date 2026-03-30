public class Item{
    String descricao;
    double preco;

    public Item(String descricao, double preco){
        this.descricao = descricao;
        this.preco = preco;
    }

    // Métodos getters
    public String getDesc(){
        return descricao;
    }

    public double getPreco(){
        return preco;
    }
}