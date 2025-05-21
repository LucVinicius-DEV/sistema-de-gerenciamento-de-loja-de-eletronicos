package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Sale {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    private Long id;
    private Date moment;
    private Customer customer;
    private List<SaleItem> items = new ArrayList<>();

    // Construtores, getters e setters (sem setter para items)

        public Sale () {
        }
        public Sale (Long id, Date moment, Customer customer) {
                this.id = id;
                this.moment = moment;
                this.customer = customer;
        }


    public static SimpleDateFormat getSdf() {
			return sdf;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Date getMoment() {
			return moment;
		}
		public void setMoment(Date moment) {
			this.moment = moment;
		}
		public Customer getCustomer() {
			return customer;
		}
		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
		public List<SaleItem> getItems() {
			return items;
		}
		
	// Métodos para adicionar e remover itens (composição)
    public void addItem(SaleItem item) {
        items.add(item);
    }

    public void removeItem(SaleItem item) {
        items.remove(item);
    }

    // Método para calcular valor total da venda
    public Double total() {
        double sum = 0.0;
        for (SaleItem item : items) {
            sum += item.subTotal();
        }
        return sum;
    }

    // Método para gerar nota da venda
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Venda #" + id + "\n");
        sb.append("Data: " + sdf.format(moment) + "\n");
        sb.append("Cliente: " + customer + "\n");
        sb.append("Itens:\n");
        for (SaleItem item : items) {
            sb.append(item.getProduct().getName() + ", ");
            sb.append("R$ " + String.format("%.2f", item.getPrice()) + ", ");
            sb.append("Quantidade: " + item.getQuantity() + ", ");
            sb.append("Subtotal: R$ " + String.format("%.2f", item.subTotal()) + "\n");
        }
        sb.append("Valor Total: R$ " + String.format("%.2f", total()));
        return sb.toString();
    }
}
