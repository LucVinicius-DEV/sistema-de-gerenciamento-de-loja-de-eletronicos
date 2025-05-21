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

        // Pré-cadastro de alguns produtos para teste
        ElectronicProduct p1 = new ElectronicProduct();
        p1.setName("Smartphone");
        p1.setBrand("Samsung");
        p1.setModel("Galaxy S21");
        p1.setPrice(3999.99);
        p1.setQuantity(10);
        p1.setCategory(ProductCategory.SMARTPHONE);
        products.add(p1);

        ElectronicProduct p2 = new ElectronicProduct();
        p2.setName("Notebook");
        p2.setBrand("Dell");
        p2.setModel("Inspiron 15");
        p2.setPrice(4500.00);
        p2.setQuantity(5);
        p2.setCategory(ProductCategory.LAPTOP);
        products.add(p2);

        // Pré-cadastro de um cliente para teste
        Customer c1 = new Customer();
        c1.setName("João Silva");
        c1.setEmail("joao@email.com");
        c1.setPhone("(11) 98765-4321");
        customers.add(c1);

        // Menu principal
        int option = 0;
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

                    // Lê os dados da venda
                    System.out.println("Digite o ID do cliente: ");
                    int customerId = sc.nextInt();
                    sc.nextLine();
                    Customer customerSale = customers.get(customerId - 1); // Obtém o cliente pelo ID

                    System.out.println("Digite a data da venda (dd/MM/yyyy HH:mm): ");
                    String dateString = sc.nextLine(); // Lê a data como string
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm"); // Define o formato da data
                    Date moment = sdf.parse(dateString); // Converte a string para Date

                    Sale sale = new Sale((long) (sales.size() + 1), moment, customerSale); // Criação do objeto

                    System.out.println("Digite o número de itens da venda: ");
                    int numItems = sc.nextInt(); // Lê o número de itens da venda
                    sc.nextLine(); // Consumir quebra de linha

                    for (int i = 0; i < numItems; i++) { // Lê os dados de cada item da venda
                        System.out.println("Item #" + (i + 1) + ":");
                        System.out.println("Digite o ID do produto: ");
                        int productId = sc.nextInt(); // Lê o ID do produto
                        sc.nextLine(); // Consumir quebra de linha

                        ElectronicProduct productSale = products.get(productId - 1); // Obtém o produto pelo ID

                        System.out.println("Digite a quantidade vendida: ");
                        int quantitySale = sc.nextInt(); // Lê a quantidade vendida
                        sc.nextLine(); // Consumir quebra de linha

                        // Verifica se há estoque suficiente
                        if (productSale.getQuantity() >= quantitySale) {
                            // Usa o preço atual do produto
                            Double priceSale = productSale.getPrice();

                            // Cria o item de venda
                            SaleItem saleItem = new SaleItem(productSale, quantitySale, priceSale);

                            // Adiciona o item à venda
                            sale.addItem(saleItem);

                            // Atualiza o estoque
                            productSale.removeFromStock(quantitySale);

                            System.out.println("Item adicionado com sucesso!");
                        } else {
                            System.out.println("Estoque insuficiente para este produto!");
                        }
                    }

                    // Adiciona a venda à lista
                    sales.add(sale);

                    System.out.println("Venda registrada com sucesso!");
                    break;

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
