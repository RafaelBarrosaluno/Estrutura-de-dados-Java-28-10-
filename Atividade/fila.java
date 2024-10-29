package main;

import java.util.Scanner;

class fila {
    private String[] elementos;  
    private int capacidade;       
    private int frente;          
    private int traseira;        
    private int tamanho;         

    public fila(int tamanho) {
        this.capacidade = tamanho;     
        this.elementos = new String[capacidade];  
        this.frente = 0;     
        this.traseira = -1;  
        this.tamanho = 0;    
    }

    public void enqueue(String elemento) {
        if (tamanho == capacidade) {
            System.out.println("Fila cheia. Não é possível adicionar mais pedidos.");
        } else {
            traseira = (traseira + 1) % capacidade;
            elementos[traseira] = elemento;  
            tamanho++;  
            System.out.println("Elemento \"" + elemento + "\" adicionado à fila.");
        }
    }

    public String dequeue() {
        if (isEmpty()) {
            System.out.println("Fila vazia. Não é possível remover elementos.");
            return null;  
        } else {
            String elementoRemovido = elementos[frente];  
            frente = (frente + 1) % capacidade;
            tamanho--;  
            System.out.println("Pedido: \"" + elementoRemovido + "\" removido da fila.");
            return elementoRemovido;  
        }
    }

    public String peek() {
        if (isEmpty()) {
            System.out.println("Fila vazia.");
            return null;  
        } else {
            return elementos[frente];  
        }
    }

    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("A fila está vazia.");
        } else {
            System.out.println("Elementos na fila:");
            for (int i = 0; i < tamanho; i++) {
                System.out.println(elementos[(frente + i) % capacidade]);
            }
        }
    }

    public boolean isEmpty() {
        return tamanho == 0; 
    }

    public int size() {
        return tamanho; 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);  

        System.out.println("Informe o tamanho da fila de pedidos: ");
        int tamanho = scanner.nextInt();  
        scanner.nextLine(); // Consume newline

        fila fila = new fila(tamanho);  

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Adicionar à fila");
            System.out.println("2 - Remover da fila");
            System.out.println("3 - Ver o elemento na frente");
            System.out.println("4 - Verificar se a fila está vazia");
            System.out.println("5 - Ver tamanho da fila");
            System.out.println("6 - Mostrar lista de tarefas");
            System.out.println("7 - Sair");

            int opcao = scanner.nextInt();  
            scanner.nextLine(); // Consume newline

            switch (opcao) {
                case 1:  
                    System.out.println("Informe o valor a ser adicionado:");
                    String valor = scanner.nextLine();  
                    fila.enqueue(valor); 
                    break;

                case 2:  
                    fila.dequeue();  
                    break;

                case 3:  
                    String frente = fila.peek();  
                    if (frente != null) {  
                        System.out.println("Elemento na frente da fila: \"" + frente + "\"");
                    }
                    break;

                case 4: 
                    if (fila.isEmpty()) {
                        System.out.println("A fila está vazia.");
                    } else {
                        System.out.println("A fila NÃO está vazia.");
                    }
                    break;

                case 5:  
                    System.out.println("Tamanho da fila: " + fila.size());
                    break;

                case 6:  
                    fila.displayQueue();  
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
