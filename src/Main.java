import DoublyLinkedList.CardGame;
import DoublyLinkedList.NewTextEditor;
import SinglyLinkedList.BrowsingHistory;
import SinglyLinkedList.Tasks;
import SinglyLinkedList.TextEditor;

import javax.smartcardio.Card;
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
                                break;
                            default:
                                System.out.println("Opção inválida, tente novamente.");
                                break;
                        }
                    }while(option3!=6);
                    break;
                case 4:
                    System.out.println("\n-----[4] Editor de texto-----");
                    int option4=0;
                    NewTextEditor nte = new NewTextEditor();
                    do{
                        System.out.println("\n[1] Adicionar uma edição\n[2] Desfazer uma edição\n[3] Recuperar uma edição desfeita\n[4] Exibir edição atual\n[5] Exibir todas as edições\n[6] Sair");
                        boolean input4 = true;
                        while (input4) {
                            System.out.print("\nDigite uma opção: ");
                            String line4 = sc.nextLine();
                            try {
                                option4 = Integer.parseInt(line4);
                            } catch (NumberFormatException e) {
                                System.err.println("Digite um número inteiro: " + e.getMessage());
                                continue;
                            }
                            if (option4 > 0 && option4 < 7) {
                                input4 = false;
                            } else {
                                System.err.println("Opção inválida. Tente novamente.");
                            }
                        }
                        switch (option4) {
                            case 1:
                                System.out.print("Digite uma edição:");
                                String edit = sc.nextLine();
                                nte.addEdit(edit);
                                break;
                            case 2:
                                nte.undoEdit();
                                System.out.println("Edição atual: " + nte.getCurrentEdit());
                                break;
                            case 3:
                                nte.redoEdit();
                                System.out.println("Edição atual: " + nte.getCurrentEdit());
                                break;
                            case 4:
                                System.out.println("Edição atual: " + nte.getCurrentEdit());
                                break;
                            case 5:
                                System.out.println(nte.toString());
                                break;
                            case 6:
                                System.out.println("Voltando ao Menu Principal.\n");
                                break;
                            default:
                                System.out.println("Opção inválida, tente novamente.");
                                break;
                        }
                    }while(option4!=6);
                    break;
                case 5:
                    System.out.println("\n-----[5] Jogo de cartas-----");
                    CardGame newHand = new CardGame();
                    int option5=0;
                    CardGame cards = new CardGame();
                    do{
                        System.out.println("\n[1] Adicionar carta\n[2] Remover carta\n[3] Organizar cartas\n[4] Exiber cartas\n[5] Sair\n");
                        boolean input5 = true;
                        while (input5) {
                            System.out.print("\nDigite uma opção: ");
                            String line5 = sc.nextLine();
                            try {
                                option5 = Integer.parseInt(line5);
                            } catch (NumberFormatException e) {
                                System.err.println("Digite um número inteiro: " + e.getMessage());
                                continue;
                            }
                            if (option5 > 0 && option5 < 6) {
                                input5 = false;
                            } else {
                                System.err.println("Opção inválida. Tente novamente.");
                            }
                        }
                        String naipe;
                        String valor;
                        switch (option5) {
                            case 1:
                                System.out.println("Adicionar uma carta:");
                                do {
                                    System.out.print("Digite o naipe [E][P][D][O]: ");
                                    naipe = sc.next();
                                }while(!naipe.equals("E") && !naipe.equals("P") && !naipe.equals("D") && !naipe.equals("O"));
                                do {
                                    System.out.print("Digite o valor [A][2-10][J][Q][K]: ");
                                    valor = sc.next();
                                }while(!valor.equals("A") && !valor.equals("2") && !valor.equals("3") && !valor.equals("4") && !valor.equals("5") && !valor.equals("6") && !valor.equals("7") && !valor.equals("8") && !valor.equals("9") && !valor.equals("10") && !valor.equals("J") && !valor.equals("Q") && !valor.equals("K"));
                                newHand.addCard(naipe,valor);
                                System.out.println("Adicionada carta " + valor + " de " + naipe);
                                break;
                            case 2:
                                System.out.println("Remover uma carta:");
                                do {
                                    System.out.print("Digite o naipe [E][P][D][O]: ");
                                    naipe = sc.next();
                                }while(!naipe.equals("E") && !naipe.equals("P") && !naipe.equals("D") && !naipe.equals("O"));
                                do {
                                    System.out.print("Digite o valor [A][2-10][J][Q][K]: ");
                                    valor = sc.next();
                                }while(!valor.equals("A") && !valor.equals("2") && !valor.equals("3") && !valor.equals("4") && !valor.equals("5") && !valor.equals("6") && !valor.equals("7") && !valor.equals("8") && !valor.equals("9") && !valor.equals("10") && !valor.equals("J") && !valor.equals("Q") && !valor.equals("K"));
                                newHand.removeCard(naipe,valor);
                                System.out.println("Removida carta " + valor + " de " + naipe);
                                break;
                            case 3:
                                String naipe1,naipe2,valor1,valor2;
                                System.out.println("Organizar cartas: trocar duas caras de lugar");
                                System.out.println("Primeira carta");
                                do {
                                    System.out.print("Digite o naipe [E][P][D][O]: ");
                                    naipe1 = sc.next();
                                }while(!naipe1.equals("E") && !naipe1.equals("P") && !naipe1.equals("D") && !naipe1.equals("O"));
                                do {
                                    System.out.print("Digite o valor [A][2-10][J][Q][K]: ");
                                    valor1 = sc.next();
                                }while(!valor1.equals("A") && !valor1.equals("2") && !valor1.equals("3") && !valor1.equals("4") && !valor1.equals("5") && !valor1.equals("6") && !valor1.equals("7") && !valor1.equals("8") && !valor1.equals("9") && !valor1.equals("10") && !valor1.equals("J") && !valor1.equals("Q") && !valor1.equals("K"));
                                System.out.println("Segunda carta");
                                do {
                                    System.out.print("Digite o naipe [E][P][D][O]: ");
                                    naipe2 = sc.next();
                                }while(!naipe2.equals("E") && !naipe2.equals("P") && !naipe2.equals("D") && !naipe2.equals("O"));
                                do {
                                    System.out.print("Digite o valor [A][2-10][J][Q][K]: ");
                                    valor2 = sc.next();
                                }while(!valor2.equals("A") && !valor2.equals("2") && !valor2.equals("3") && !valor2.equals("4") && !valor2.equals("5") && !valor2.equals("6") && !valor2.equals("7") && !valor2.equals("8") && !valor2.equals("9") && !valor2.equals("10") && !valor2.equals("J") && !valor2.equals("Q") && !valor2.equals("K"));
                                System.out.println(newHand.organizeHand(naipe1, valor1, naipe2, valor2));
                                System.out.println();
                                break;
                            case 4:
                                System.out.println("Exibir cartas:");
                                System.out.println(newHand.toString());

                                break;
                            case 5:
                                System.out.println("Voltando ao Menu Principal.\n");
                                break;
                            default:
                                System.out.println("Opção inválida, tente novamente.");
                                break;
                        }
                    }while(option5!=5);
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