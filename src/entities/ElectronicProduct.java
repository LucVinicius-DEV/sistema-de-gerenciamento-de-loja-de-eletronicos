package entities;

import entities.enums.ProductCategory;

public class ElectronicProduct extends Product {
    private String brand;
    private String model;
    private ProductCategory category;

    // Construtores, getters e setters

    public ElectronicProduct() {
        
    }

    public ElectronicProduct(String name, Double price, Integer quantity, String brand, String model, ProductCategory category) {
        super(name, price, quantity);
        this.brand = brand;
        this.model = model;
        this.category = category;    
    }

    
    
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

	// Método para exibir informações completas do produto
    @Override
    public String toString() {
        return getName() + " - " + getBrand() + " " + getModel() + 
               " - R$ " + String.format("%.2f", getPrice()) +
               " - Estoque: " + getQuantity() + " unidades";
    }
}
