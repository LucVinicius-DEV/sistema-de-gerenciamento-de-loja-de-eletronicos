![Banner](https://github.com/LucVinicius-DEV/sistema-de-gerenciamento-de-loja-de-eletronicos/blob/main/banner.png)

# 🛍️ Sistema de Gerenciamento de Loja de Eletrônicos

Este projeto simula um **sistema de gerenciamento de uma loja de eletrônicos**, utilizando **Programação Orientada a Objetos (POO)** com conceitos como **composição**, **encapsulamento** e **regras de negócio básicas**, como cálculo de valor total de um pedido e controle de estoque.

## 📚 Projeto disponível

- [`Cliente.java`](./src/Cliente.java) — Representa um cliente com nome e CPF.
- [`Loja.java`](./src/Loja.java) — Representa a loja com listas de clientes, produtos e pedidos.
- [`Pedido.java`](./src/Pedido.java) — Representa um pedido com cliente e produtos associados.
- [`Produto.java`](./src/Produto.java) — Representa um produto eletrônico com nome, preço e estoque.
- [`ProdutoPedido.java`](./src/ProdutoPedido.java) — Representa a associação entre um produto e a quantidade vendida em um pedido.
- [`Main.java`](./src/Main.java) — Classe de execução com simulações de cadastro e vendas.

## ⚙️ Tecnologias Utilizadas

- Java
- Git & GitHub
- Replit (IDE online)

## 🧩 Conceitos Aplicados

- Composição entre objetos (`Pedido`, `Produto`, `Cliente`, `Loja`)
- Encapsulamento com `getters` e `setters`
- Controle de estoque e valor total de pedidos
- Separação de responsabilidades e modelagem de entidades

## ▶️ Como Executar

1. Clone o repositório ou acesse via Replit.
2. Abra o arquivo `Main.java`.
3. Execute e acompanhe as simulações no console: cadastro de clientes, produtos e realização de pedidos.

## ✨ Exemplo de Saída

```
Produto cadastrado: Smartphone - R$ 2500.00 - Estoque: 10
Cliente cadastrado: Maria Silva - CPF: 111.222.333-44

Pedido criado:
Cliente: Maria Silva
Itens:
- Smartphone x2 - Total: R$ 5000.00

Estoque atualizado: Smartphone - 8 unidades restantes.
```

## 👨‍💻 Autor

Desenvolvido por Lucas Vinícius com apoio da Luna durante os estudos práticos de Programação Orientada a Objetos em Java.

[LinkedIn](https://www.linkedin.com/in/lucas-vin%C3%ADcius-05b41a35b/) | [GitHub](https://github.com/LucVinicius-DEV)

Se esse projeto te ajudou, deixe uma ⭐ no repositório e acompanhe minha evolução!
