package Estrutura_Dados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;    // Importa a classe Scanner para receber entrada de dados
public class Lista {
    public static void main(String[] args) {
        // Criação de uma lista de Strings usando a implementação ArrayList
        List<String> lista = new ArrayList<>();
        
        // Criação de um objeto Scanner para receber a entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Pergunta ao usuário quantas frutas ele quer adicionar
        System.out.println("Quantas frutas você quer adicionar?");
        int quantidade = scanner.nextInt();   // Lê o número de frutas
        scanner.nextLine();  // Consumir a nova linha após o número, para evitar problemas com a próxima entrada
        // Laço para adicionar os nomes das frutas à lista
        for (int i = 0; i < quantidade; i++) {
            System.out.println("Digite o nome da fruta " + (i + 1) + ": ");
            String fruta = scanner.nextLine();  // Lê o nome da fruta
            lista.add(fruta);  // Adiciona a fruta à lista
        }
        // Exibe todas as frutas adicionadas na lista
        System.out.println("\nFrutas adicionadas na lista:");
        for (String fruta : lista) {
            System.out.println(fruta);  // Imprime cada fruta
        }
        // Exibe o tamanho da lista
        System.out.println("\nTamanho da lista: " + lista.size());  // Imprime o número de elementos da lista
        // Fecha o scanner para evitar vazamento de recursos
        scanner.close();
    }
}
