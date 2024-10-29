package main;

import java.util.Scanner;

class Pilha {
    private int[] elementos;
    private int topo;
    private int capacidade;

    public Pilha(int tamanho) {
        elementos = new int[tamanho];
        capacidade = tamanho;
        topo = -1;
    }

    public void push(int elemento) {
        if (topo == capacidade - 1) {
            System.out.println("Pilha cheia. Não é possível empilhar mais elementos.");
        } else {
            topo++;
            elementos[topo] = elemento;
            System.out.println("Elemento " + elemento + " empilhado.");
        }
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Pilha vazia. Não é possível desempilhar.");
            return -1;
        } else {
            int elementoRemovido = elementos[topo];
            topo--;
            System.out.println("Elemento " + elementoRemovido + " desempilhado.");
            return elementoRemovido;
        }
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Pilha vazia.");
            return -1;
        } else {
            return elementos[topo];
        }
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public int size() {
        return topo + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o tamanho da pilha: ");
        int tamanho = scanner.nextInt();

        Pilha pilhaPrincipal = new Pilha(tamanho);
        Pilha pilhaAuxiliar = new Pilha(tamanho); // Pilha temporária para armazenar elementos desempilhados

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Empilhar");
            System.out.println("2 - Desempilhar e mover para pilha auxiliar");
            System.out.println("3 - Ver o topo");
            System.out.println("4 - Verificar se está vazia");
            System.out.println("5 - Ver tamanho da pilha");
            System.out.println("6 - Retornar elemento da pilha auxiliar para a pilha principal");
            System.out.println("7 - Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Informe o valor a ser empilhado:");
                    int valor = scanner.nextInt();
                    pilhaPrincipal.push(valor);
                    break;

                case 2:
                    int elementoRemovido = pilhaPrincipal.pop();
                    if (elementoRemovido != -1) {  // Se a remoção foi bem-sucedida
                        pilhaAuxiliar.push(elementoRemovido);
                        System.out.println("Elemento movido para a pilha auxiliar.");
                    }
                    break;

                case 3:
                    int topo = pilhaPrincipal.peek();
                    if (topo != -1) {
                        System.out.println("Topo da pilha: " + topo);
                    }
                    break;

                case 4:
                    if (pilhaPrincipal.isEmpty()) {
                        System.out.println("A pilha está vazia.");
                    } else {
                        System.out.println("A pilha NÃO está vazia.");
                    }
                    break;

                case 5:
                    System.out.println("Tamanho da pilha: " + pilhaPrincipal.size());
                    break;

                case 6:
                    int elementoAux = pilhaAuxiliar.pop();
                    if (elementoAux != -1) { // Se a remoção foi bem-sucedida
                        pilhaPrincipal.push(elementoAux);
                        System.out.println("Elemento retornado para a pilha principal.");
                    }
                    break;

                case 7:
                    System.out.println("Encerrando o programa...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
