
// Controla a árvore. Tem a raiz e os métodos de inserir, buscar, etc.
public class ArvoreBinariaMorse {

    private Nodo raiz;

    // 1. inicializar
    public void inicializar() {
        // raiz vazia
        this.raiz = new Nodo();
    }

    // 2. inserir (privado)
    // Navega na árvore (ponto=esq, traço=dir) e bota a letra lá.
    private void inserir(String morse, char caractere) {
        Nodo atual = this.raiz;

        // Loop pelo código morse (ex: ".-")
        for (int i = 0; i < morse.length(); i = i + 1) {
            
            // Pega o símbolo (charAt() pq não pode array)
            char simbolo = morse.charAt(i); 

            if (simbolo == '.') {
                // PONTO = ESQUERDA
                if (atual.esquerdo == null) {
                    atual.esquerdo = new Nodo(); // Cria o caminho
                }
                atual = atual.esquerdo; // Anda

            } else if (simbolo == '-') {
                // TRAÇO = DIREITA
                if (atual.direito == null) {
                    atual.direito = new Nodo(); // Cria o caminho
                }
                atual = atual.direito; // Anda
            }
        }
        
        // Chegou no fim do caminho, bota a letra
        atual.caractere = caractere;
    }

    // 3. método para popular a árvore
    // Insere tudo de uma vez. A "inserção automática".
    public void popularArvore() {
        // Letras
        inserir(".-", 'A');
        inserir("-...", 'B');
        inserir("-.-.", 'C');
        inserir("-..", 'D');
        inserir(".", 'E');
        inserir("..-.", 'F');
        inserir("--.", 'G');
        inserir("....", 'H');
        inserir("..", 'I');
        inserir(".---", 'J');
        inserir("-.-", 'K');
        inserir(".-..", 'L');
        inserir("--", 'M');
        inserir("-.", 'N');
        inserir("---", 'O');
        inserir(".--.", 'P');
        inserir("--.-", 'Q');
        inserir(".-.", 'R');
        inserir("...", 'S');
        inserir("-", 'T');
        inserir("..-", 'U');
        inserir("...-", 'V');
        inserir(".--", 'W');
        inserir("-..-", 'X');
        inserir("-.--", 'Y');
        inserir("--..", 'Z');

        // Números
        inserir("-----", '0');
        inserir(".----", '1');
        inserir("..---", '2');
        inserir("...--", '3');
        inserir("....-", '4');
        inserir(".....", '5');
        inserir("-....", '6');
        inserir("--...", '7');
        inserir("---..", '8');
        inserir("----.", '9');
    }

    // 4. busca
    // Recebe o morse (ex: "...") e devolve a letra ('S')
    public char buscar(String morse) {
        Nodo atual = this.raiz;

        for (int i = 0; i < morse.length(); i = i + 1) {
            char simbolo = morse.charAt(i);

            if (simbolo == '.') {
                // PONTO -> Esquerda
                if (atual.esquerdo == null) { return '?'; } // Não existe
                atual = atual.esquerdo;
            
            } else if (simbolo == '-') {
                // TRAÇO -> Direita
                if (atual.direito == null) { return '?'; } // Não existe
                atual = atual.direito;
            
            } else {
                return '?'; // Símbolo inválido
            }
        }

        // Se for '\0', é só um caminho, não uma letra
        if (atual.caractere == '\0') {
            return '?';
        }
        
        return atual.caractere;
    }

    // 5. Método remover
    // A gente apaga a letra, mas mantém o nó
    // pros filhos não se perderem.
    public void remover(String morse) {
        Nodo atual = this.raiz;

        for (int i = 0; i < morse.length(); i = i + 1) {
            char simbolo = morse.charAt(i);
            if (simbolo == '.') {
                if (atual.esquerdo == null) { return; } // Não achou
                atual = atual.esquerdo;
            } else if (simbolo == '-') {
                if (atual.direito == null) { return; } // Não achou
                atual = atual.direito;
            }
        }
        
        // Achou. Apaga a letra
        atual.caractere = '\0';
        System.out.println("Caractere do codigo " + morse + " removido.");
    }


    // 6. Método para Exibição da Árvore
    // O método "público" que o Main chama
    public void exibirArvore() {
        System.out.println("--- Exibindo Arvore Morse ---");
        System.out.println("(RAIZ)");
        exibirHierarquia(this.raiz, ""); // Chama o recursivo
    }

    // 7.  Exibir
    // Recursão podia... Ufa.
    private void exibirHierarquia(Nodo nodo, String prefixo) {
        if (nodo == null) {
            return; // Parada
        }

        // mostra a letra (se tiver)
        if (nodo.caractere != '\0') {
            System.out.println(prefixo + " [" + nodo.caractere + "]");
        } else {
            // Mostra ( ) se for só um nó de caminho
            if (prefixo.length() > 0) { // Não mostra o ( ) da raiz
                 System.out.println(prefixo + " ( )");
            }
        }

        // achamada recursiva pra esquerda e direita
        exibirHierarquia(nodo.esquerdo, prefixo + " .");
        exibirHierarquia(nodo.direito, prefixo + " -");
    }
}
