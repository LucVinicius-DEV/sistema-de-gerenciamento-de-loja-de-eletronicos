package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Customer;
import entities.ElectronicProduct;
import entities.Sale;
import entities.SaleItem;
import entities.enums.ProductCategory;

/**
 * Classe principal que contém o método main e implementa a interface com o usuário.
 * Gerencia o fluxo do sistema de loja de eletrônicos.
 */
public class Main {

    public static void main(String[] args) throws ParseException {
        // Configura localização para usar ponto como separador decimal
        Locale.setDefault(Locale.US);

        // Cria scanner para leitura de dados
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

            try {
                option = sc.nextInt();
                sc.nextLine(); // Consumir quebra de linha

                switch (option) {
                    case 1:
                        // Cadastrar produto
                        cadastrarProduto(sc, products);
                        break;
                    case 2:
                        // Cadastrar cliente
                        cadastrarCliente(sc, customers);
                        break;
                    case 3:
                        // Registrar venda
                        registrarVenda(sc, customers, products, sales);
                        break;
                    case 4:
                        // Listar produtos
                        listarProdutos(products);
                        break;
                    case 5:
                        // Listar clientes
                        listarClientes(customers);
                        break;
                    case 6:
                        // Relatório de vendas
                        relatorioVendas(sales);
                        break;
                    case 0:
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida! Por favor, escolha uma opção entre 0 e 6.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, digite um número válido!");
                sc.nextLine(); // Limpa o buffer do scanner
                option = -1; // Define um valor inválido para continuar o loop
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
                option = -1; // Define um valor inválido para continuar o loop
            }

        } while (option != 0);

        sc.close();
    }

    /**
     * Cadastra um novo produto no sistema
     * @param sc Scanner para leitura de dados
     * @param products Lista de produtos
     */
    private static void cadastrarProduto(Scanner sc, List<ElectronicProduct> products) {
        try {
            // Lê os dados do produto
            System.out.println("\n===== CADASTRO DE PRODUTO =====");
            System.out.print("Digite o nome do produto: ");
            String name = sc.nextLine();

            System.out.print("Digite a marca do produto: ");
            String brand = sc.nextLine();

            System.out.print("Digite o modelo do produto: ");
            String model = sc.nextLine();

            System.out.print("Digite o preço do produto: ");
            Double price = sc.nextDouble();

            if (price <= 0) {
                System.out.println("Erro: O preço deve ser maior que zero!");
                return;
            }

            System.out.print("Digite a quantidade em estoque: ");
            Integer quantity = sc.nextInt();

            if (quantity < 0) {
                System.out.println("Erro: A quantidade não pode ser negativa!");
                return;
            }

            sc.nextLine(); // Consumir quebra de linha

            System.out.println("Categorias disponíveis:");
            for (ProductCategory category : ProductCategory.values()) {
                System.out.println("- " + category);
            }

            System.out.print("Digite a categoria do produto: ");
            String categoryStr = sc.next().toUpperCase();

            ProductCategory category;
            try {
                category = ProductCategory.valueOf(categoryStr);
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: Categoria inválida!");
                return;
            }

            // Cria o objeto e adiciona à lista
            ElectronicProduct product = new ElectronicProduct(name, price, quantity, brand, model, category);
            products.add(product);

            System.out.println("Produto cadastrado com sucesso!");

        } catch (InputMismatchException e) {
            System.out.println("Erro: Formato de entrada inválido!");
            sc.nextLine(); // Limpa o buffer do scanner
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar produto: " + e.getMessage());
        }
    }

    /**
     * Cadastra um novo cliente no sistema
     * @param sc Scanner para leitura de dados
     * @param customers Lista de clientes
     */
    private static void cadastrarCliente(Scanner sc, List<Customer> customers) {
        try {
            // Lê os dados do cliente
            System.out.println("\n===== CADASTRO DE CLIENTE =====");
            System.out.print("Digite o nome do cliente: ");
            String name = sc.nextLine();

            System.out.print("Digite o email do cliente: ");
            String email = sc.nextLine();

            System.out.print("Digite o telefone do cliente: ");
            String phone = sc.nextLine();

            // Criação do objeto e adição à lista
            Customer customer = new Customer(name, email, phone);
            customers.add(customer);

            System.out.println("Cliente cadastrado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    /**
     * Registra uma nova venda no sistema
     * @param sc Scanner para leitura de dados
     * @param customers Lista de clientes
     * @param products Lista de produtos
     * @param sales Lista de vendas
     */
    private static void registrarVenda(Scanner sc, List<Customer> customers, 
                                      List<ElectronicProduct> products, List<Sale> sales) {
        try {
            // Verifica se existem clientes e produtos cadastrados
            if (customers.isEmpty()) {
                System.out.println("Erro: Não há clientes cadastrados!");
                return;
            }

            if (products.isEmpty()) {
                System.out.println("Erro: Não há produtos cadastrados!");
                return;
            }

            // Lê os dados da venda
            System.out.println("\n===== REGISTRO DE VENDA =====");

            // Lista os clientes disponíveis
            System.out.println("Clientes disponíveis:");
            for (int i = 0; i < customers.size(); i++) {
                System.out.println((i+1) + ". " + customers.get(i));
            }

            // Seleciona o cliente
            System.out.print("Digite o ID do cliente: ");
            int customerId = sc.nextInt();
            sc.nextLine(); // Consumir quebra de linha

            if (customerId < 1 || customerId > customers.size()) {
                System.out.println("Erro: ID de cliente inválido!");
                return;
            }

            Customer customerSale = customers.get(customerId - 1);

            // Lê a data da venda
            System.out.print("Digite a data da venda (dd/MM/yyyy HH:mm): ");
            String dateString = sc.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            Date moment;

            try {
                moment = sdf.parse(dateString);
            } catch (ParseException e) {
                System.out.println("Erro: Formato de data inválido!");
                return;
            }

            // Cria o objeto venda
            Sale sale = new Sale((long) (sales.size() + 1), moment, customerSale);

            // Lê os itens da venda
            System.out.print("Digite o número de itens da venda: ");
            int numItems = sc.nextInt();
            sc.nextLine(); // Consumir quebra de linha

            if (numItems <= 0) {
                System.out.println("Erro: O número de itens deve ser maior que zero!");
                return;
            }

            // Loop para ler cada item
            for (int i = 0; i < numItems; i++) {
                System.out.println("\nItem #" + (i+1) + ":");

                // Lista os produtos disponíveis
                System.out.println("Produtos disponíveis:");
                for (int j = 0; j < products.size(); j++) {
                    System.out.println((j+1) + ". " + products.get(j));
                }

                // Seleciona o produto
                System.out.print("Digite o ID do produto: ");
                int productId = sc.nextInt();
                sc.nextLine(); // Consumir quebra de linha

                if (productId < 1 || productId > products.size()) {
                    System.out.println("Erro: ID de produto inválido!");
                    i--; // Repete a iteração
                    continue;
                }

                ElectronicProduct productSale = products.get(productId - 1);

                // Lê a quantidade
                System.out.print("Digite a quantidade vendida: ");
                int quantitySale = sc.nextInt();
                sc.nextLine(); // Consumir quebra de linha

                if (quantitySale <= 0) {
                    System.out.println("Erro: A quantidade deve ser maior que zero!");
                    i--; // Repete a iteração
                    continue;
                }

                // Verifica se há estoque suficiente
                if (productSale.getQuantity() < quantitySale) {
                    System.out.println("Erro: Estoque insuficiente! Disponível: " + 
                                      productSale.getQuantity());
                    i--; // Repete a iteração
                    continue;
                }

                // Usa o preço atual do produto
                Double priceSale = productSale.getPrice();

                // Cria o item de venda
                SaleItem saleItem = new SaleItem(productSale, quantitySale, priceSale);

                // Adiciona o item à venda
                sale.addItem(saleItem);

                // Atualiza o estoque
                productSale.removeFromStock(quantitySale);

                System.out.println("Item adicionado com sucesso!");
            }

            // Adiciona a venda à lista
            sales.add(sale);

            System.out.println("\nVenda registrada com sucesso!");
            System.out.println("Valor total: R$ " + String.format("%.2f", sale.total()));

        } catch (InputMismatchException e) {
            System.out.println("Erro: Formato de entrada inválido!");
            sc.nextLine(); // Limpa o buffer do scanner
        } catch (Exception e) {
            System.out.println("Erro ao registrar venda: " + e.getMessage());
        }
    }

    /**
     * Lista todos os produtos cadastrados
     * @param products Lista de produtos
     */
    private static void listarProdutos(List<ElectronicProduct> products) {
        System.out.println("\n===== PRODUTOS DISPONÍVEIS =====");

        if (products.isEmpty()) {
            System.out.println("Não há produtos cadastrados!");
            return;
        }

        for (int i = 0; i < products.size(); i++) {
            System.out.println((i+1) + ". " + products.get(i));
        }
    }

    /**
     * Lista todos os clientes cadastrados
     * @param customers Lista de clientes
     */
    private static void listarClientes(List<Customer> customers) {
        System.out.println("\n===== CLIENTES CADASTRADOS =====");

        if (customers.isEmpty()) {
            System.out.println("Não há clientes cadastrados!");
            return;
        }

        for (int i = 0; i < customers.size(); i++) {
            System.out.println((i+1) + ". " + customers.get(i));
        }
    }

    /**
     * Exibe o relatório de todas as vendas realizadas
     * @param sales Lista de vendas
     */
    private static void relatorioVendas(List<Sale> sales) {
        System.out.println("\n===== RELATÓRIO DE VENDAS =====");

        if (sales.isEmpty()) {
            System.out.println("Não há vendas registradas!");
            return;
        }

        double totalGeral = 0.0;

        for (Sale sale : sales) {
            System.out.println(sale);
            System.out.println("-------------------------");
            totalGeral += sale.total();
        }

        System.out.println("\nTotal Geral: R$ " + String.format("%.2f", totalGeral));
        System.out.println("Total de Vendas: " + sales.size());
    }
}
