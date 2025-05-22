package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe que representa uma venda completa.
 * Implementa o conceito de composição com SaleItem.
 */
public class Sale {

    // Formatador de data estático para padronizar exibição
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    // Atributos
    private Long id;                        // Identificador único da venda
    private Date moment;                    // Data e hora da venda
    private Customer customer;              // Cliente que realizou a compra
    private List<SaleItem> items = new ArrayList<>(); // Lista de itens da venda (composição)

    // Construtores, getters e setters

    /**
     * Construtor padrão
     */
    public Sale() {
    }

    /**
     * Construtor com parâmetros
     * @param id Identificador da venda
     * @param moment Data e hora da venda
     * @param customer Cliente que realizou a compra
     */
    public Sale(Long id, Date moment, Customer customer) {
        this.id = id;
        this.moment = moment;
        this.customer = customer;
    }

    // Métodos getters e setters (sem setter para items)

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

    /**
     * Adiciona um item à venda (implementa composição)
     * @param item Item a ser adicionado
     */
    public void addItem(SaleItem item) {
        items.add(item);
    }

    /**
     * Remove um item da venda (implementa composição)
     * @param item Item a ser removido
     */
    public void removeItem(SaleItem item) {
        items.remove(item);
    }

    /**
     * Calcula o valor total da venda somando os subtotais de cada item
     * @return Valor total da venda
     */
    public Double total() {
        double sum = 0.0;
        for (SaleItem item : items) {
            sum += item.subTotal();
        }
        return sum;
    }

    /**
     * Gera uma representação textual detalhada da venda (nota fiscal)
     * @return String formatada com todos os detalhes da venda
     */
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
