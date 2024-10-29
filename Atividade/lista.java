package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;    
public class lista {
    public static void main(String[] args) {
       
        List<String> lista = new ArrayList<>();
        
        
        Scanner scanner = new Scanner(System.in);

       
        System.out.println("Digite quantas tarefas você quer adicionar:");
        int quantidade = scanner.nextInt();   
        scanner.nextLine(); 
        
        for (int i = 0; i < quantidade; i++) {
            System.out.println("Digite o nome da primeira tarefa: " + (i + 1) + ": ");
            String tarefa = scanner.nextLine(); 
            lista.add(tarefa);  
        }
        
        System.out.println("\nTarefas adicionadas na lista:");
        for (String tarefa : lista) {
            System.out.println(tarefa);  
        }
        System.out.println("Deseja remover uma tarefa? (s/n)");
        String resposta = scanner.nextLine();

        if (resposta.equalsIgnoreCase("s")) {
            System.out.println("Digite o índice da tarefa que deseja remover (0 a " + (lista.size() - 1) + "):");
            int indiceParaRemover = scanner.nextInt();

            
            if (indiceParaRemover >= 0 && indiceParaRemover < lista.size()) {
                lista.remove(indiceParaRemover);
                System.out.println("Tarefa removida com sucesso!");
                System.out.println("\nTarefas adicionadas na lista:");
                for (String tarefa : lista) {
                    System.out.println(tarefa);  
                }
                
            }else {
                System.out.println("Índice inválido!");
            }
        }
        
        System.out.println("\nTamanho da lista: " + lista.size());  
        
        scanner.close();
    }
}