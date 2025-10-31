
// é o nó da árvore. Guarda a letra e os caminhos (ponto/traço).
public class Nodo {

    char caractere; // a letra (ou '\0' se for nó de caminho)
    Nodo esquerdo; // Caminho do Ponto (.)
    Nodo direito;  // caminho do Traço (-)

    // Construtor
    public Nodo() {
        this.caractere = '\0'; // Começa vazio
        this.esquerdo = null;
        this.direito = null;
    }
}
