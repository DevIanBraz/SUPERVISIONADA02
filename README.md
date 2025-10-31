# Atividade Supervisionada 02: Árvore Binária com Código Morse

Trabalho da disciplina de Resolução de Problemas Estruturados sobre a implementação de Árvores Binárias.

## Academicos

* Ian Carlo Araújo Braz

## Objetivo

O objetivo foi implementar uma Árvore Binária para representar e decodificar o Código Morse. O desafio principal foi seguir as regras estritas de não usar quase nada pronto do Java (sem Array, sem List, sem try-catch, etc.).

A árvore segue a lógica do Código Morse:
* Caminho da Esquerda = Ponto (.)
* Caminho da Direita = Traço (-)

## Estrutura do Código

O projeto foi dividido em 3 arquivos pra ficar mais fácil de entender:

* **`Nodo.java`**: É como se fosse o tijolo da nossa árvore. Ele guarda o caractere (a letra ou número) e tem os dois filhos (o `esquerdo` pro ponto e o `direito` pro traço).

* **`ArvoreBinariaMorse.java`**: É a classe que controla a árvore. Ela tem a `raiz` e os métodos principais:
    * `popularArvore()`: Método que já insere o alfabeto e os números sozinhos quando o programa começa.
    * `inserir()`: O método que navega na árvore (esq/dir) e coloca a letra no lugar certo.
    * `buscar()`: Faz o caminho inverso, recebe o morse (ex: ...) e devolve a letra (S).
    * `remover()`: Acha a letra e limpa ela (coloca \0), mas mantém o nó lá pra não quebrar os caminhos dos filhos.
    * `exibirArvore()`: Mostra a árvore toda no console.

* **`Main.java`**: É o menu pra testar tudo. Ele tem as opções de buscar, remover, mostrar e a de decodificar mensagem.

## Como Funciona (A nossa lógica)

### A Árvore (Inserir/Buscar)

A lógica aqui foi a mais direta. A gente sempre começa pela `raiz`.
* Para inserir S (...):
    1.  Começa na `raiz`.
    2.  Primeiro `.`: vai pra `raiz.esquerdo`.
    3.  Segundo `.`: vai pra `raiz.esquerdo.esquerdo`.
    4.  Terceiro `.`: vai pra `raiz.esquerdo.esquerdo.esquerdo`.
    5.  Bota a letra S nesse nó.
* A busca faz o mesmo caminho e só lê a letra que tá lá.

### O Desafio: Decodificar SOS (O Split manual)

Como a gente não podia usar `split()` nem `array` (`String[]`) pra quebrar a mensagem (tipo ... --- ...), essa foi a parte que deu mais trabalho.

O jeito que a gente achou foi:

1.  Criar uma função `decodificarMensagem` lá no `Main.java`.
2.  Ela lê a String da mensagem (tipo ... --- ...) caractere por caractere.
3.  Ela usa uma String `codigoAtual` (que começa vazia) pra ir juntando os pontos e traços.
4.  Quando o `for` acha um ESPAÇO, ele para. Isso significa que um código (ex: ...) acabou.
5.  Nessa hora, o programa chama o `arvore.buscar(codigoAtual)` (vai buscar ... e achar S).
6.  O resultado (S) é guardado. O `codigoAtual` é limpo (fica vazio) e o `for` continua, fazendo a mesma coisa pro ---.
7.  No final do `for`, a gente tem que buscar o último código (o ... final), porque ele não tem um espaço depois.

Foi o único jeito que a gente pensou pra quebrar a string sem usar as funções proibidas.

## Como Rodar

1.  Suba os codigos no INTELIJ e seja feliz! (obvio, veja se o JDK ta instalado).
