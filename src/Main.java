import SinglyLinkedList.BrowsingHistory;
import SinglyLinkedList.Tasks;
import SinglyLinkedList.TextEditor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int quest = 0;
        do{
            System.out.println("-----Lista de Exercícios - Módulo 5 - Java-----");
            System.out.println("\n--- Lista Simplesmente Encadeada\n[1] Gerenciador de tarefas\n[2] Histórico de navegação\n[3] Editor de texto");
            System.out.println("--- Lista Duplamente Encadeada\n[4] Editor de texto\n[5] Jogo de cartas");
            System.out.println("--- Filas\n[6] Fila de atendimento\n[7] Fila de impressão\n[8] Fila de processos");
            System.out.println("--- Para sair, digite [9]");

            //Evitar que o terminal pare ao inserir não-inteiros
            boolean input = true;
            while(input){
                System.out.print("\nDigite o número exercício a ser executado: ");
                String line = sc.nextLine();
                try{
                    quest = Integer.parseInt(line);
                }catch(NumberFormatException e){
                    System.err.println("Digite um número inteiro válido: " + e.getMessage());
                    continue;
                }
                if(quest>0 && quest<10){
                    input = false;
                }else{
                    System.err.println("Opção inválida. Tente novamente.");
                }

            }

            switch (quest) {
                case 1:
                    System.out.println("\n-----[1] Gerenciador de taferas-----");
                    int option1=0;
                    Tasks taskList = new Tasks();
                    do{
                        System.out.println("\n[1] Adicionar tarefa\n[2] Remover tarefa\n[3] Concluir tarefa\n[4] Imprimir lista de tarefas\n[5] Sair");

                        boolean input1 = true;
                        while(input1){
                            System.out.print("\nDigite uma opção: ");
                            String line1 = sc.nextLine();
                            try{
                                option1 = Integer.parseInt(line1);
                            }catch(NumberFormatException e){
                                System.err.println("Digite um número inteiro: " + e.getMessage());
                                continue;
                            }
                            if(option1>0 && option1<6){
                                input1 = false;
                            }else{
                                System.err.println("Opção inválida. Tente novamente.");
                            }
                        }
                        switch (option1) {
                            case 1:
                                System.out.print("Digite a descrição da tarefa a ser adicionada: ");
                                String desc = sc.nextLine();
                                taskList.createTask(desc);
                                break;
                            case 2:
                                System.out.print("Digite o ID da tarefa a ser removida: ");
                                int idRemove = sc.nextInt();
                                sc.nextLine();
                                taskList.removeTask(idRemove);
                                break;
                            case 3:
                                System.out.print("Digite o ID da tarefa a ser concluída: ");
                                int idComplete = sc.nextInt();
                                sc.nextLine();
                                taskList.completeTask(idComplete);
                                break;
                            case 4:
                                System.out.println(taskList.toString());
                                break;
                            case 5:
                                System.out.println("Voltando ao Menu Principal.\n");
                            default:
                                System.out.println("Opção inválida, tente novamente.");
                        }
                    }while(option1!=5);
                    break;
                case 2:
                    System.out.println("\n-----[2] Histórico de Navegação-----");
                    int option2=0;
                    BrowsingHistory bh = new BrowsingHistory();
                    do{
                        System.out.println("\n[1] Adicionar URL\n[2] Remover URL\n[3] Imprimir histórico de navegação\n[4] Sair");
                        boolean input2 = true;
                        while(input2){
                            System.out.print("\nDigite uma opção: ");
                            String line2 = sc.nextLine();
                            try{
                                option2 = Integer.parseInt(line2);
                            }catch(NumberFormatException e){
                                System.err.println("Digite um número inteiro: " + e.getMessage());
                                continue;
                            }
                            if(option2>0 && option2<5){
                                input2 = false;
                            }else{
                                System.err.println("Opção inválida. Tente novamente.");
                            }
                        }
                        switch (option2) {
                            case 1:
                                System.out.print("Digite o título do URL a ser adicionado: ");
                                String title = sc.nextLine();
                                System.out.print("Digite o URL a ser adicionado: ");
                                String url = sc.nextLine();
                                bh.addBrowsingData(title, url);
                                break;
                            case 2:
                                System.out.print("Digite o ID do URL a ser removido: ");
                                int idRemove = sc.nextInt();
                                sc.nextLine();
                                bh.deleteBrowsingData(idRemove);
                                break;
                            case 3:
                                System.out.println(bh.toString());
                                break;
                            case 4:
                                System.out.println("Voltando ao Menu Principal.\n");
                            default:
                                System.out.println("Opção inválida, tente novamente.");
                        }
                    }while(option2!=4);
                    break;
                case 3:
                    System.out.println("\n-----[3] Editor de texto-----");
                    int option3=0;
                    TextEditor te = new TextEditor();
                    do {
                        System.out.println("\n[1] Adicionar uma edição\n[2] Desfazer uma edição\n[3] Recuperar uma edição desfeita\n[4] Exibir edição atual\n[5] Exibir todas as edições\n[6] Sair");
                        boolean input3 = true;
                        while (input3) {
                            System.out.print("\nDigite uma opção: ");
                            String line3 = sc.nextLine();
                            try {
                                option3 = Integer.parseInt(line3);
                            } catch (NumberFormatException e) {
                                System.err.println("Digite um número inteiro: " + e.getMessage());
                                continue;
                            }
                            if (option3 > 0 && option3 < 7) {
                                input3 = false;
                            } else {
                                System.err.println("Opção inválida. Tente novamente.");
                            }
                        }
                        switch (option3) {
                            case 1:
                                System.out.print("Digite uma edição:");
                                String edit = sc.nextLine();
                                te.addEdit(edit);
                                break;
                            case 2:
                                te.undoEdit();
                                System.out.println("Edição atual: " + te.getCurrentEdit());
                                break;
                            case 3:
                                te.redoEdit();
                                System.out.println("Edição atual: " + te.getCurrentEdit());
                                break;
                            case 4:
                                System.out.println("Edição atual: " + te.getCurrentEdit());
                                break;
                            case 5:
                                System.out.println(te.toString());
                                break;
                            case 6:
                                System.out.println("Voltando ao Menu Principal.\n");
                            default:
                                System.out.println("Opção inválida, tente novamente.");
                        }
                    }while(option3!=6);
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        }while(quest!=9);
        System.out.println("Volte sempre!");
    }
}