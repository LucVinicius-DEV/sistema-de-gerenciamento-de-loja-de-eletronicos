

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

        // Adicionar produtos e clientes iniciais (opcional)
        // Implementar lógica
        
        ElectronicProduct product1 = new ElectronicProduct("Smartphone", 1500.0, 10, "Samsung", "Galaxy S21", ProductCategory.SMARTPHONE);
        products.add(product1);
        
        ElectronicProduct product2 = new ElectronicProduct("Notebook", 3000.0, 5, "Dell", "XPS 13", ProductCategory.LAPTOP);
        products.add(product2);
        
        Customer customer1 = new Customer("João Silva", "joao.silva@example.com", "123456789");
        customers.add(customer1);
        
        Customer customer2 = new Customer("Maria Souza", "maria.souza@example.com", "987654321");
        customers.add(customer2);
        
        Customer customer3 = new Customer("Pedro Santos", "pedro.santos@example.com", "123456789");
        customers.add(customer3);
        

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

                    // atribui data e hora do sistema a venda
                    Date moment = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                    

                    // Seleciona o cliente 
                    System.out.println("Selecione o cliente (digite o número correspondente): ");
                    for (int i = 0; i < customers.size(); i++) {
                        System.out.println((i + 1) + ". " + customers.get(i));
                    }
                    int customerIndex = sc.nextInt() - 1;
                    Customer selectedCustomer = customers.get(customerIndex);
                    sc.nextLine();
                   
                    
                    // Criação do objeto venda
                    
                    Sale sale = new Sale(id, moment, selectedCustomer);

                    

                    // Adiciona itens à venda 
                    System.out.println("Selecione o produto (digite o número correspondente): ");
                    for (int i = 0; i < products.size(); i++) {
                        System.out.println((i + 1) + ". " + products.get(i));
                    }
                    int productIndex = sc.nextInt() - 1;
                    ElectronicProduct selectedProduct = products.get(productIndex);
                    sc.nextLine();
                    System.out.println("Digite a quantidade vendida: ");
                    int quantitySale = sc.nextInt();
                    
                    // Removendo produto do estoque apos a venda
                    
                    
                    selectedProduct.removeFromStock(quantitySale);
                    sc.nextLine();
                    

                    // Criação do objeto item de venda
                    SaleItem saleItem = new SaleItem(selectedProduct, quantitySale, selectedProduct.getPrice());
                    
                    // Adiciona o item à venda
                    sale.addItem(saleItem);

                    // Adiciona a venda à lista
                    sales.add(sale);

                    // imprime relatorio da venda
                    System.out.println(sale);
                    System.out.println("----------------------------------");
                    
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
