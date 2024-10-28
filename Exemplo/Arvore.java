package Estrutura_Dados;

import java.util.Scanner;  // Importa a classe Scanner para entrada de dados

//Classe que representa um nó da árvore
class Nodo {
 int valor;       // Valor armazenado no nó
 Nodo esquerda;   // Referência para o filho à esquerda
 Nodo direita;    // Referência para o filho à direita

 // Construtor do nó, que define o valor e inicializa os filhos como null
 public Nodo(int valor) {
     this.valor = valor;
     this.esquerda = null;
     this.direita = null;
 }
}

//Classe que representa a Árvore Binária de Busca (BST)
class ArvoreBinariaBusca {
 Nodo raiz;  // Referência para o nó raiz da árvore

 // Construtor da árvore, que inicia a raiz como null
 public ArvoreBinariaBusca() {
     raiz = null;
 }

 // Método para inserir um novo valor na árvore
 public void inserir(int valor) {
     raiz = inserirRecursivo(raiz, valor);  // Chama o método recursivo de inserção
 }

 // Método recursivo que encontra a posição correta para o novo valor
 private Nodo inserirRecursivo(Nodo atual, int valor) {
     // Caso base: se o nó atual for null, cria um novo nó
     if (atual == null) {
         return new Nodo(valor);
     }

     // Se o valor for menor que o valor do nó atual, insere à esquerda
     if (valor < atual.valor) {
         atual.esquerda = inserirRecursivo(atual.esquerda, valor);
     } 
     // Se o valor for maior, insere à direita
     else if (valor > atual.valor) {
         atual.direita = inserirRecursivo(atual.direita, valor);
     }

     // Retorna o nó atual após a inserção
     return atual;
 }

 // Método para buscar um valor na árvore
 public boolean buscar(int valor) {
     return buscarRecursivo(raiz, valor);  // Chama o método recursivo de busca
 }

 // Método recursivo para buscar um valor na árvore
 private boolean buscarRecursivo(Nodo atual, int valor) {
     // Caso base: se o nó atual é null, o valor não está na árvore
     if (atual == null) {
         return false;
     }

     // Se o valor procurado é igual ao valor do nó atual, retorna true
     if (valor == atual.valor) {
         return true;
     }

     // Se o valor procurado é menor, continua a busca à esquerda
     return valor < atual.valor ? buscarRecursivo(atual.esquerda, valor) : buscarRecursivo(atual.direita, valor);
 }

 // Método para exibir os valores da árvore em ordem
 public void exibirEmOrdem() {
     exibirEmOrdemRecursivo(raiz);  // Chama o método recursivo de exibição
     System.out.println();
 }

 // Método recursivo para exibir os valores da árvore em ordem
 private void exibirEmOrdemRecursivo(Nodo atual) {
     // Caso base: se o nó atual for null, termina a recursão
     if (atual != null) {
         // Visita a subárvore esquerda
         exibirEmOrdemRecursivo(atual.esquerda);
         // Imprime o valor do nó atual
         System.out.print(atual.valor + " ");
         // Visita a subárvore direita
         exibirEmOrdemRecursivo(atual.direita);
     }
 }


//Classe principal para testar a árvore binária de busca
 public static void main(String[] args) {
     ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();  // Cria uma nova árvore
     Scanner scanner = new Scanner(System.in);  // Cria o Scanner para receber dados do usuário

     // Interatividade com o usuário
     while (true) {
         // Exibe o menu de opções
         System.out.println("\nEscolha uma opção:");
         System.out.println("1 - Inserir um valor na árvore");
         System.out.println("2 - Buscar um valor na árvore");
         System.out.println("3 - Exibir a árvore em ordem");
         System.out.println("4 - Sair");

         int opcao = scanner.nextInt();  // Lê a opção escolhida pelo usuário

         switch (opcao) {
             case 1:  // Inserir um valor
                 System.out.print("Digite o valor para inserir: ");
                 int valorInserir = scanner.nextInt();  // Lê o valor a ser inserido
                 arvore.inserir(valorInserir);  // Insere o valor na árvore
                 System.out.println("Valor " + valorInserir + " inserido.");
                 break;

             case 2:  // Buscar um valor
                 System.out.print("Digite o valor para buscar: ");
                 int valorBuscar = scanner.nextInt();  // Lê o valor a ser buscado
                 boolean encontrado = arvore.buscar(valorBuscar);  // Busca o valor na árvore
                 if (encontrado) {
                     System.out.println("Valor " + valorBuscar + " encontrado na árvore.");
                 } else {
                     System.out.println("Valor " + valorBuscar + " não encontrado na árvore.");
                 }
                 break;

             case 3:  // Exibir a árvore em ordem
                 System.out.print("Árvore em ordem: ");
                 arvore.exibirEmOrdem();  // Exibe a árvore em ordem crescente
                 break;

             case 4:  // Sair do programa
                 System.out.println("Encerrando o programa...");
                 scanner.close();  // Fecha o Scanner
                 return;  // Encerra o programa

             default:  // Caso o usuário escolha uma opção inválida
                 System.out.println("Opção inválida. Tente novamente.");
         }
     }
 }
}
