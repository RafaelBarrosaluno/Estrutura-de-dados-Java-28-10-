package Estrutura_Dados;

import java.util.Scanner;  // Importa a classe Scanner para receber entrada de dados

//Definição da classe Fila, que armazena inteiros
class Fila {
 private int[] elementos;  // Array para armazenar os elementos da fila
 private int capacidade;   // Capacidade máxima da fila
 private int frente;       // Índice da frente da fila
 private int traseira;     // Índice da traseira da fila
 private int tamanho;      // Tamanho atual da fila

 // Construtor que define o tamanho máximo da fila
 public Fila(int tamanho) {
     this.capacidade = tamanho;      // Define a capacidade da fila
     this.elementos = new int[capacidade];  // Inicializa o array com o tamanho fornecido
     this.frente = 0;     // A frente começa no índice 0
     this.traseira = -1;  // A traseira começa fora da fila (vazia)
     this.tamanho = 0;    // Inicializa o tamanho da fila como 0
 }

 // Método para adicionar um elemento ao final da fila (enqueue)
 public void enqueue(int elemento) {
     // Verifica se a fila está cheia
     if (tamanho == capacidade) {
         System.out.println("Fila cheia. Não é possível adicionar mais elementos.");
     } else {
         // Move a traseira para o próximo índice circularmente
         traseira = (traseira + 1) % capacidade;
         elementos[traseira] = elemento;  // Adiciona o elemento na nova posição da traseira
         tamanho++;  // Incrementa o tamanho da fila
         System.out.println("Elemento " + elemento + " adicionado à fila.");
     }
 }

 // Método para remover o elemento da frente da fila (dequeue)
 public int dequeue() {
     // Verifica se a fila está vazia
     if (isEmpty()) {
         System.out.println("Fila vazia. Não é possível remover elementos.");
         return -1;  // Retorna -1 indicando que a fila está vazia
     } else {
         int elementoRemovido = elementos[frente];  // Armazena o valor a ser removido
         // Move a frente para o próximo índice circularmente
         frente = (frente + 1) % capacidade;
         tamanho--;  // Decrementa o tamanho da fila
         System.out.println("Elemento " + elementoRemovido + " removido da fila.");
         return elementoRemovido;  // Retorna o elemento removido
     }
 }

 // Método para verificar o elemento na frente da fila (peek)
 public int peek() {
     // Verifica se a fila está vazia
     if (isEmpty()) {
         System.out.println("Fila vazia.");
         return -1;  // Retorna -1 indicando que a fila está vazia
     } else {
         return elementos[frente];  // Retorna o elemento da frente sem removê-lo
     }
 }

 // Método para verificar se a fila está vazia
 public boolean isEmpty() {
     return tamanho == 0;  // Retorna verdadeiro se o tamanho for 0 (fila vazia)
 }

 // Método para retornar o tamanho atual da fila
 public int size() {
     return tamanho;  // Retorna o número de elementos presentes na fila
 }

//Classe principal para testar a implementação da fila
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);  // Cria o objeto Scanner para entrada de dados

     // Pergunta o tamanho da fila ao usuário
     System.out.println("Informe o tamanho da fila: ");
     int tamanho = scanner.nextInt();  // Lê o tamanho da fila fornecido pelo usuário

     Fila fila = new Fila(tamanho);  // Cria uma nova fila com o tamanho informado

     // Loop para oferecer opções ao usuário
     while (true) {
         // Exibe o menu de opções
         System.out.println("\nEscolha uma opção:");
         System.out.println("1 - Adicionar à fila (enqueue)");
         System.out.println("2 - Remover da fila (dequeue)");
         System.out.println("3 - Ver o elemento na frente");
         System.out.println("4 - Verificar se a fila está vazia");
         System.out.println("5 - Ver tamanho da fila");
         System.out.println("6 - Sair");

         int opcao = scanner.nextInt();  // Lê a opção escolhida pelo usuário

         switch (opcao) {
             case 1:  // Adicionar à fila (enqueue)
                 System.out.println("Informe o valor a ser adicionado:");
                 int valor = scanner.nextInt();  // Lê o valor que será adicionado
                 fila.enqueue(valor);  // Adiciona o valor à fila
                 break;

             case 2:  // Remover da fila (dequeue)
                 fila.dequeue();  // Remove o elemento da frente
                 break;

             case 3:  // Ver o elemento na frente (peek)
                 int frente = fila.peek();  // Lê o valor da frente
                 if (frente != -1) {  // Verifica se a fila não está vazia
                     System.out.println("Elemento na frente da fila: " + frente);
                 }
                 break;

             case 4:  // Verificar se a fila está vazia
                 if (fila.isEmpty()) {
                     System.out.println("A fila está vazia.");
                 } else {
                     System.out.println("A fila NÃO está vazia.");
                 }
                 break;

             case 5:  // Ver o tamanho da fila
                 System.out.println("Tamanho da fila: " + fila.size());
                 break;

             case 6:  // Sair do programa
                 System.out.println("Encerrando o programa...");
                 scanner.close();  // Fecha o scanner
                 System.exit(0);  // Encerra o programa

             default:  // Caso o usuário informe uma opção inválida
                 System.out.println("Opção inválida. Tente novamente.");
         }
     }
 }
}
