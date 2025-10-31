
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        ArvoreBinariaMorse arvore = new ArvoreBinariaMorse();
        
        // Já começa a árvore com tudo
        arvore.inicializar();
        arvore.popularArvore();

        boolean executando = true;

        while (executando) {
            System.out.println("\n--- Tradutor de Codigo Morse ---");
            System.out.println("1. Decodificar Mensagem (ex: ... --- ...)");
            System.out.println("2. Buscar Caractere (pelo codigo)");
            System.out.println("3. Remover Caractere (pelo codigo)");
            System.out.println("4. Exibir Arvore Hierarquica");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");

            // Sem try-catch ou Integer.parseInt,
            // lemos como String e comparamos a String.
            String opcao = scanner.nextLine();

            if (opcao.equals("1")) {
                // decodificar Mensagem
                System.out.print("Digite a mensagem em Morse (separada por espacos): ");
                String mensagem = scanner.nextLine();
                
                // chama o nosso "split" manual
                decodificarMensagem(arvore, mensagem);

            } else if (opcao.equals("2")) {
                // Buscar Caractere
                System.out.print("Digite o codigo Morse (ex: .-): ");
                String morse = scanner.nextLine();
                char c = arvore.buscar(morse);
                System.out.println("Caractere encontrado: " + c);

            } else if (opcao.equals("3")) {
                // remover Caractere
                System.out.print("Digite o codigo Morse para remover (ex: ...): ");
                String morse = scanner.nextLine();
                arvore.remover(morse);

            } else if (opcao.equals("4")) {
                // Exibe Arvore
                arvore.exibirArvore();

            } else if (opcao.equals("0")) {
                // sai
                executando = false;
                System.out.println("Saindo...");
            
            } else {
              
                System.out.println("Opcao invalida. Digite 1, 2, 3, 4 ou 0.");
            }
        }
        
        scanner.close();
    }


    //Lê caractere por caractere, Acumula em 'codigoAtual', Quando acha um ESPAÇO, busca na árvore e limpa e Repete.
    public static void decodificarMensagem(ArvoreBinariaMorse arvore, String mensagem) {
        
        String codigoAtual = "";
        String resultado = "";

        // Loop pela mensagem (ex: "... --- ...")
        for (int i = 0; i < mensagem.length(); i = i + 1) {
            
            char c = mensagem.charAt(i);

            if (c == ' ') {
                // Achou espaço. Fim do código.
                
                if (codigoAtual.length() > 0) {
                    char decodificado = arvore.buscar(codigoAtual);
                    resultado = resultado + decodificado;
                }
                
                // Limpa pro próximo
                codigoAtual = "";

            } else {
                // Acumula o '.' ou '-'
                codigoAtual = codigoAtual + c;
            }
        }

        // pega o último código (que não tem espaço depois)
        if (codigoAtual.length() > 0) {
            char decodificado = arvore.buscar(codigoAtual);
            resultado = resultado + decodificado;
        }


      
        System.out.println("Mensagem decodificada: " + resultado);
    }
}
