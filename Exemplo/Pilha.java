package Estrutura_Dados;

import java.util.Scanner;  // Importa a classe Scanner para receber entrada de dados

//Definição da classe Pilha, que armazena inteiros
class Pilha {
 private int[] elementos;  // Array para armazenar os elementos da pilha
 private int topo;         // Índice que aponta para o topo da pilha
 private int capacidade;   // Capacidade máxima da pilha

 // Construtor que define o tamanho máximo da pilha
 public Pilha(int tamanho) {
     elementos = new int[tamanho];  // Inicializa o array com o tamanho fornecido
     capacidade = tamanho;          // Define a capacidade da pilha
     topo = -1;  // Inicializa o topo como -1 (pilha vazia)
 }

 // Método para adicionar um elemento na pilha
 public void push(int elemento) {
     // Verifica se a pilha está cheia
     if (topo == capacidade - 1) {
         System.out.println("Pilha cheia. Não é possível empilhar mais elementos.");
     } else {
         topo++;                  // Incrementa o topo para o próximo índice
         elementos[topo] = elemento;  // Adiciona o novo elemento no topo
         System.out.println("Elemento " + elemento + " empilhado.");
     }
 }

 // Método para remover o elemento do topo da pilha
 public int pop() {
     // Verifica se a pilha está vazia
     if (isEmpty()) {
         System.out.println("Pilha vazia. Não é possível desempilhar.");
         return -1;  // Retorna um valor inválido indicando que não há elementos para desempilhar
     } else {
         int elementoRemovido = elementos[topo];  // Armazena o valor a ser removido
         topo--;  // Decrementa o topo para remover o elemento
         System.out.println("Elemento " + elementoRemovido + " desempilhado.");
         return elementoRemovido;  // Retorna o elemento removido
     }
 }

 // Método para verificar o elemento do topo da pilha
 public int peek() {
     // Verifica se a pilha está vazia
     if (isEmpty()) {
         System.out.println("Pilha vazia.");
         return -1;
     } else {
         return elementos[topo];  // Retorna o elemento do topo sem removê-lo
     }
 }

 // Método para verificar se a pilha está vazia
 public boolean isEmpty() {
     return topo == -1;  // Retorna verdadeiro se o topo for -1 (ou seja, a pilha está vazia)
 }

 // Método para retornar o tamanho atual da pilha
 public int size() {
     return topo + 1;  // O tamanho da pilha é o índice do topo + 1
 }


//Classe principal para testar a implementação da pilha
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);  // Cria o objeto Scanner para entrada de dados
     
     // Pergunta o tamanho da pilha ao usuário
     System.out.println("Informe o tamanho da pilha: ");
     int tamanho = scanner.nextInt();  // Lê o tamanho da pilha fornecido pelo usuário
     
     Pilha pilha = new Pilha(tamanho);  // Cria uma nova pilha com o tamanho informado

     // Loop para oferecer opções ao usuário
     while (true) {
         // Exibe o menu de opções
         System.out.println("\nEscolha uma opção:");
         System.out.println("1 - Empilhar");
         System.out.println("2 - Desempilhar");
         System.out.println("3 - Ver o topo");
         System.out.println("4 - Verificar se está vazia");
         System.out.println("5 - Ver tamanho da pilha");
         System.out.println("6 - Sair");
         
         int opcao = scanner.nextInt();  // Lê a opção escolhida pelo usuário

         switch (opcao) {
             case 1:  // Empilhar (push)
                 System.out.println("Informe o valor a ser empilhado:");
                 int valor = scanner.nextInt();  // Lê o valor que será empilhado
                 pilha.push(valor);  // Empilha o valor
                 break;

             case 2:  // Desempilhar (pop)
                 pilha.pop();  // Remove o elemento do topo
                 break;

             case 3:  // Ver o topo da pilha (peek)
                 int topo = pilha.peek();  // Lê o valor do topo
                 if (topo != -1) {  // Verifica se a pilha não está vazia
                     System.out.println("Topo da pilha: " + topo);
                 }
                 break;

             case 4:  // Verificar se a pilha está vazia
                 if (pilha.isEmpty()) {
                     System.out.println("A pilha está vazia.");
                 } else {
                     System.out.println("A pilha NÃO está vazia.");
                 }
                 break;

             case 5:  // Ver o tamanho da pilha
                 System.out.println("Tamanho da pilha: " + pilha.size());
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
