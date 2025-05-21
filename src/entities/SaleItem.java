package entities;

public class SaleItem {
    private ElectronicProduct product;
    private Integer quantity;
    private Double price; // Preço no momento da venda

    // Construtores, getters e setters
        public SaleItem () {
        }
        public SaleItem (ElectronicProduct product, Integer quantity, Double price) {
                this.product = product;
                this.quantity = quantity;
                this.price = price;
        }
        

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
	// Método para calcular subtotal
    public Double subTotal() {
        return price * quantity;
    }
}
