package entities;

import entities.enums.ProductCategory;

/**
 * Classe que representa um produto eletrônico, estendendo a classe Product.
 * Adiciona atributos específicos para produtos eletrônicos.
 */
public class ElectronicProduct extends Product {

    // Atributos específicos de produtos eletrônicos
    private String brand;              // Marca do produto
    private String model;              // Modelo do produto
    private ProductCategory category;  // Categoria do produto (usando enum)

    // Construtores, getters e setters

    /**
     * Construtor padrão
     */
    public ElectronicProduct() {
        super();
    }

    /**
     * Construtor com parâmetros
     * @param name Nome do produto
     * @param price Preço unitário
     * @param quantity Quantidade em estoque
     * @param brand Marca do produto
     * @param model Modelo do produto
     * @param category Categoria do produto
     */
    public ElectronicProduct(String name, Double price, Integer quantity, 
                            String brand, String model, ProductCategory category) {
        super(name, price, quantity);
        this.brand = brand;
        this.model = model;
        this.category = category;
    }

    // Métodos getters e setters

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    /**
     * Sobrescreve o método toString para exibir informações detalhadas do produto
     * @return String formatada com os dados do produto eletrônico
     */
    @Override
    public String toString() {
        return getName() + " - " + getBrand() + " " + getModel() + 
               " - R$ " + String.format("%.2f", getPrice()) +
               " - Estoque: " + getQuantity() + " unidades";
    }
}
