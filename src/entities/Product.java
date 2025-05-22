package entities;

/**
 * Classe base que representa um produto genérico.
 * Contém atributos e métodos comuns a todos os tipos de produtos.
 */
public class Product {

    // Atributos básicos de um produto
    private String name;       // Nome do produto
    private Double price;      // Preço unitário
    private Integer quantity;  // Quantidade em estoque

    // Construtores, getters e setters

    /**
     * Construtor padrão
     */
    public Product() {
    }

    /**
     * Construtor com parâmetros
     * @param name Nome do produto
     * @param price Preço unitário
     * @param quantity Quantidade em estoque
     */
    public Product(String name, Double price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    // Métodos getters e setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Calcula o valor total do produto em estoque
     * @return Valor total (preço * quantidade)
     */
    public Double totalValueInStock() {
        return price * quantity;
    }

    /**
     * Remove uma quantidade específica do estoque após uma venda
     * @param quantity Quantidade a ser removida
     * @return true se a operação foi bem-sucedida, false se não há estoque suficiente
     */
    public boolean removeFromStock(int quantity) {
        if (this.quantity >= quantity) {
            this.quantity -= quantity;
            return true;
        }
        return false;
    }

    /**
     * Adiciona uma quantidade específica ao estoque (para reposição)
     * @param quantity Quantidade a ser adicionada
     */
    public void addToStock(int quantity) {
        this.quantity += quantity;
    }
}
