package entities;

/**
 * Classe que representa um cliente da loja de eletrônicos.
 * Armazena informações básicas de contato do cliente.
 */
public class Customer {

    // Atributos privados (encapsulamento)
    private String name;   // Nome do cliente
    private String email;  // Email para contato
    private String phone;  // Telefone para contato

    // Construtores, getters e setters

    /**
     * Construtor padrão
     */
    public Customer() {
    }

    /**
     * Construtor com parâmetros
     * @param name Nome do cliente
     * @param email Email do cliente
     * @param phone Telefone do cliente
     */
    public Customer(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    // Métodos getters e setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Sobrescreve o método toString para exibir os dados do cliente formatados
     * @return String formatada com os dados do cliente
     */
    @Override
    public String toString() {
        return name + " (" + email + ")";
    }
}
