package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Customer;
import entities.ElectronicProduct;
import entities.Product;
import entities.Sale;
import entities.SaleItem;
import entities.enums.ProductCategory;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // Listas para armazenar dados
        List<ElectronicProduct> products = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();
        List<Sale> sales = new ArrayList<>();
        List<SaleItem> saleItems = new ArrayList<>();
        List<Product> productList = new ArrayList<>();

        // Menu principal

        int option = 0;
        // Loop principal do menu
        do {
            System.out.println("\n===== SISTEMA DE GERENCIAMENTO DE LOJA =====");
            System.out.println("1. Cadastrar novo produto");
            System.out.println("2. Cadastrar novo cliente");
            System.out.println("3. Registrar venda");
            System.out.println("4. Listar produtos");
            System.out.println("5. Listar clientes");
            System.out.println("6. Relatório de vendas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            option = sc.nextInt();
            sc.nextLine(); // Consumir quebra de linha

            switch (option) {
                case 1:
                    // Cadastrar produto
                    // Implementar lógica

                    // Le os dados do produto
                    System.out.println("Digite o nome do produto: ");
                    String name = sc.nextLine();
                    System.out.println("Digite a marca do produto: ");
                    String brand = sc.nextLine();
                    System.out.println("Digite o modelo do produto: ");
                    String model = sc.nextLine();
                    System.out.println("Digite o preço do produto: ");
                    Double price = sc.nextDouble();
                    System.out.println("Digite a quantidade em estoque: ");
                    Integer quantity = sc.nextInt();

                    System.out.println(
                            "Digite a categoria do produto (SMARTPHONE, LAPTOP, TV, ACCESSORY, GAMING, OTHER): ");
                    ProductCategory category = ProductCategory.valueOf(sc.next().toUpperCase()); // Converte a string
                                                                                                 // para o enum
                                                                                                 // correspondente

                    ElectronicProduct product = new ElectronicProduct(name, price, quantity, brand, model, category); // Criação
                                                                                                                      // do
                                                                                                                      // objeto
                    products.add(product); // Adiciona o produto à lista
                    System.out.println("Produto cadastrado com sucesso!");
                    break;
                case 2:
                    // Cadastrar cliente
                    // Implementar lógica

                    // Le os dados do cliente
                    System.out.println("Digite o nome do cliente: ");
                    String nameCustomer = sc.nextLine();
                    System.out.println("Digite o email do cliente: ");
                    String email = sc.nextLine();
                    System.out.println("Digite o telefone do cliente: ");
                    String phone = sc.nextLine();

                    // Criação do objeto e adição à lista
                    Customer customer = new Customer(nameCustomer, email, phone);
                    customers.add(customer);

                    System.out.println("Cliente cadastrado com sucesso!");

                    break;
                case 3:
                    // Registrar venda
                    // implementar a logica

                    // Le os dados da venda
                    System.out.println("Digite o ID da venda: ");
                    Long id = sc.nextLong();
                    sc.nextLine(); // Consumir quebra de linha

                    // Le a data e hora da venda
                    System.out.println("Digite a data e hora da venda (dd/MM/yyyy HH:mm): ");
                    String momentStr = sc.nextLine();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    Date moment = sdf.parse(momentStr);

                    // Le o nome do cliente
                    System.out.println("Digite o nome do cliente: ");
                    String customerName = sc.nextLine();
                    Customer customerSale = null;
                    for (Customer c : customers) {
                        if (c.getName().equalsIgnoreCase(customerName)) {
                            customerSale = c;
                            break;
                        }

                        // Se o cliente não for encontrado, exibe uma mensagem de erro e volta ao menu
                        if (customerSale == null) {
                            System.out.println("Cliente não encontrado!");
                            break;
                        }
                        // Criação do objeto Sale
                        Sale sale = new Sale(id, moment, customerSale);

                        // Le os itens da venda
                        System.out.println("Digite o número de itens da venda: ");
                        int n = sc.nextInt();
                        sc.nextLine();

                        for (int i = 1; i <= n; i++) {
                            System.out.println("Digite o nome do produto #" + i + ": ");
                            String productName = sc.nextLine();
                            ElectronicProduct productSale = null;
                            for (ElectronicProduct p : products) {
                                if (p.getName().equalsIgnoreCase(productName)) {
                                    productSale = p;
                                    break;
                                }
                            }
                            // Se o produto não for encontrado, exibe uma mensagem de erro e volta ao menu
                            if (productSale == null) {
                                System.out.println("Produto não encontrado!");
                                break;
                            }
                            // Le a quantidade e o preço do item
                            System.out.println("Digite a quantidade do produto #" + i + ": ");
                            int quantitySale = sc.nextInt();
                            System.out.println("Digite o preço do produto #" + i + ": ");
                            Double priceSale = sc.nextDouble();
                            sc.nextLine();
                            // Atualiza o estoque do produto
                            productSale.removeFromStock(quantitySale);
                            // Atualiza a lista de produtos
                            products.set(products.indexOf(productSale), productSale);
                            // Atualiza a lista de itens da venda
                            saleItems.add(new SaleItem(productSale, quantitySale, priceSale));
                            // Atualiza a lista de vendas
                            sales.add(sale);
                            System.out.println("Venda registrada com sucesso!");

                            break;

                        }
                    }

                case 4:
                    // Listar produtos
                    System.out.println("\n===== PRODUTOS DISPONÍVEIS =====");
                    for (int i = 0; i < products.size(); i++) {
                        System.out.println((i + 1) + ". " + products.get(i));
                    }
                    break;
                case 5:
                    // Listar clientes
                    // Implementar lógica
                    System.out.println("\n===== CLIENTES CADASTRADOS =====");
                    for (int i = 0; i < customers.size(); i++) {
                        System.out.println((i + 1) + ". " + customers.get(i));
                    }
                    break;
                case 6:
                    // Relatório de vendas
                    // Implementar lógica
                    System.out.println("\n===== RELATÓRIO DE VENDAS =====");
                    for (int i = 0; i < sales.size(); i++) {
                        System.out.println(sales.get(i));
                        System.out.println("----------------------------------");
                    }
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

        } while (option != 0);

        sc.close();
    }
}