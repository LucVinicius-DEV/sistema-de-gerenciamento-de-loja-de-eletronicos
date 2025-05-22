package entities;

/**
 * Classe que representa um item de venda (linha de pedido).
 * Estabelece a relação entre um produto e sua quantidade em uma venda específica.
 */
public class SaleItem {

    // Atributos
    private ElectronicProduct product; // Produto vendido
    private Integer quantity;          // Quantidade vendida
    private Double price;              // Preço no momento da venda (pode diferir do preço atual do produto)

    // Construtores, getters e setters

    /**
     * Construtor padrão
     */
    public SaleItem() {
    }

    /**
     * Construtor com parâmetros
     * @param product Produto vendido
     * @param quantity Quantidade vendida
     * @param price Preço no momento da venda
     */
    public SaleItem(ElectronicProduct product, Integer quantity, Double price) {
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    // Métodos getters e setters

    public ElectronicProduct getProduct() {
        return product;
    }

    public void setProduct(ElectronicProduct product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * Calcula o subtotal do item (preço * quantidade)
     * @return Valor subtotal do item
     */
    public Double subTotal() {
        return price * quantity;
    }
}
