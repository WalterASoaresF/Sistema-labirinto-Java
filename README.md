# 🧩 Labirinto em Java

Projeto desenvolvido em **Java** utilizando **matrizes bidimensionais**, lógica de movimentação e interação via terminal.

O objetivo do jogo é conduzir o personagem até a saída do labirinto, desviando de obstáculos e coletando bônus ao longo do caminho.

---

## 🚀 Sobre o projeto

Este projeto foi desenvolvido com foco em praticar conceitos fundamentais de **Programação Orientada a Objetos e lógica de programação**, especialmente:

* uso de **matrizes (`String[][]`)**
* estruturas de repetição
* condicionais
* entrada de dados com `Scanner`
* validação de movimentos
* manipulação de posições em um tabuleiro

O jogo é executado diretamente no terminal e permite ao usuário escolher o tamanho do mapa.

---

## 🎮 Como funciona

Ao iniciar o programa, o usuário escolhe o tamanho do tabuleiro:

* `10x10`
* `20x20`
* `30x30`

O labirinto é gerado aleatoriamente com:

* `@` → personagem
* `#` → obstáculos
* `.` → caminho livre
* `$` → bônus
* `P` → ponto inicial
* `S` → saída

O jogador possui:

* quantidade limitada de movimentos
* quantidade limitada de visualizações do mapa

---

## 🎯 Objetivo

Levar o personagem `@` até a saída `S`.

Durante o percurso, é possível:

* mover-se pelo mapa
* visualizar o labirinto
* coletar bônus
* evitar obstáculos e bordas

---

## 🎮 Controles

| Tecla | Ação                |
| ----- | ------------------- |
| `W`   | mover para cima     |
| `S`   | mover para baixo    |
| `A`   | mover para esquerda |
| `D`   | mover para direita  |
| `L`   | visualizar mapa     |
| `X`   | sair do jogo        |

---

## 🧠 Conceitos aplicados

Este projeto explora conceitos importantes para formação em engenharia de software:

### Matrizes

O tabuleiro do jogo é representado por uma matriz:

```java
String[][] tabuleiro
```

Cada posição representa uma célula do labirinto.

---

### Lógica de movimentação

O personagem possui posição controlada por linha e coluna:

```java
static int linha = 2;
static int coluna = 1;
```

Cada comando altera sua posição no mapa.

---

### Geração aleatória

O labirinto é criado dinamicamente usando:

```java
Math.random()
```

Isso faz com que cada partida seja diferente.

---

### Tratamento de erros

O sistema impede:

* sair do mapa
* atravessar obstáculos
* movimentos inválidos

---

## 💰 Sistema de pontuação

O jogador recebe pontuação com base em:

* quantidade de movimentos usados
* visualizações do mapa
* bônus coletados

---

## 🛠️ Tecnologias utilizadas

* **Java**
* **Scanner**
* **Matrizes**
* **Lógica procedural**

---

## 📚 Aprendizados

Com este projeto foi possível desenvolver habilidades como:

* raciocínio lógico
* manipulação de matrizes
* validação de entradas
* modelagem de jogo simples
* estruturação de código em métodos

---

## 🚀 Melhorias futuras

Ideias para evolução do projeto:

* [ ] interface gráfica com Java Swing
* [ ] níveis de dificuldade
* [ ] cronômetro
* [ ] sistema de ranking
* [ ] geração garantida de caminho até a saída
* [ ] versão orientada a objetos com classes `Jogador`, `Tabuleiro` e `Jogo`

---

## 👨‍💻 Autor

Desenvolvido por **Walter**
Estudante de Engenharia de Software
