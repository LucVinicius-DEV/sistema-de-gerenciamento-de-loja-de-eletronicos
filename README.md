![Banner](https://github.com/LucVinicius-DEV/sistema-de-gerenciamento-de-loja-de-eletronicos/blob/main/banner.png)

# 🛍️ Sistema de Gerenciamento de Loja de Eletrônicos

Este projeto simula um **sistema de gerenciamento de uma loja de eletrônicos**, utilizando **Programação Orientada a Objetos (POO)** com conceitos como **composição**, **encapsulamento** e **regras de negócio básicas**, como cálculo de valor total de um pedido e controle de estoque.

---

## 📚 Projeto disponível

- [`Cliente.java`](./src/entities/Cliente.java) — Representa um cliente com nome e CPF.
- [`Funcionario.java`](./src/entities/Funcionario.java) — Representa um funcionário com nome, CPF e cargo.
- [`Loja.java`](./src/entities/Loja.java) — Representa a loja com listas de clientes, funcionários, produtos e pedidos.
- [`Pedido.java`](./src/entities/Pedido.java) — Representa um pedido com cliente, funcionário e produtos associados.
- [`Produto.java`](./src/entities/Produto.java) — Representa um produto eletrônico com nome, preço e estoque.
- [`ProdutoPedido.java`](./src/entities/ProdutoPedido.java) — Representa a associação entre um produto e a quantidade vendida em um pedido.
- [`Main.java`](./src/application/Main.java) — Classe de execução com simulações de cadastro e vendas.

---

## ⚙️ Tecnologias Utilizadas

- Java
- Git & GitHub
- Replit (IDE online)

---

## 🧩 Conceitos Aplicados

- Composição entre objetos (`Pedido`, `Produto`, `Cliente`, `Funcionario`, `Loja`)
- Encapsulamento com `getters` e `setters`
- Controle de estoque e valor total de pedidos
- Separação de responsabilidades e modelagem de entidades

---

## ▶️ Como Executar

1. Clone o repositório ou acesse via Replit.
2. Abra o arquivo `Main.java`.
3. Execute e acompanhe as simulações no console: cadastro de clientes, funcionários, produtos e realização de pedidos.

---

## ✨ Exemplo de Saída

```
Produto cadastrado: Smartphone - R$ 2500.00 - Estoque: 10
Cliente cadastrado: Maria Silva - CPF: 111.222.333-44
Funcionário cadastrado: Carlos Souza - Cargo: Gerente

Pedido criado:
Cliente: Maria Silva
Funcionário: Carlos Souza
Itens:
- Smartphone x2 - Total: R$ 5000.00

Estoque atualizado: Smartphone - 8 unidades restantes.
```

---

## 👨‍💻 Autor

Desenvolvido por Lucas Vinícius com apoio da Luna durante os estudos práticos de Programação Orientada a Objetos em Java.

[![LinkedIn](https://img.shields.io/badge/LinkedIn-Lucas%20Vinícius-blue?style=flat&logo=linkedin)](https://www.linkedin.com/in/lucas-vin%C3%ADcius-05b41a35b/)  
[![GitHub](https://img.shields.io/badge/GitHub-LucVinicius--DEV-black?style=flat&logo=github)](https://github.com/LucVinicius-DEV)

---

Se esse projeto te ajudou, deixe uma ⭐ no repositório e acompanhe minha evolução!
