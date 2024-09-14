package SinglyLinkedList;
import java.util.LinkedList;

class Task{
    //Atributos da tarefa
    private String taskDescription;
    private int id;
    private boolean completed;
    //Métido construtor da tarefa
    public Task(String task, int id, boolean completed) {
        this.taskDescription = task;
        this.id=id;
        this.completed = false;
    }
    //Getters e setters
    public String getTaskDescription(){
        return this.taskDescription;
    }
    public int getId(){
        return this.id;
    }
    public boolean getCompleted(){
        return this.completed;
    }
    public void setCompleted(){
        this.completed = true;
    }
    public void setTaskDescription(String taskDescription){
        this.taskDescription = taskDescription;
    }
    public void setId(int id){
        this.id = id;
    }

    //Metodo toString
    public String toString(){
        String concluida;
        if(completed){
            concluida="Sim";
        }else{
            concluida="Não";
        }

        return "ID " + id + " - Tarefa: " + taskDescription + " - Concluída: " + concluida;
    }

}
public class Tasks {
    private LinkedList<Task> taskList;
    private Task task;

    public Tasks(){
        this.taskList = new LinkedList<>();
    }
    //Adicionar tarefa à lista
    public void createTask(String task){
        Task newTask = new Task(task, taskList.size()+1, false);
        this.taskList.add(newTask);
        System.out.println("Tarefa adicionada com sucesso. ID " + taskList.size());
    }
    //Remover tarefa da lista
    public void removeTask(int id){
        boolean removed = false;
        for(Task t: this.taskList){
            if(t.getId() == id){
                this.taskList.remove(t);
                System.out.println("Tarefa removida com sucesso.");
                removed = true;
                break;
            }
        }
        if(!removed){
            System.out.println("Tarefa não localizada.");
        }

    }
    //Marcar tarefa como condluída
    public void completeTask(int id){
        boolean completed = false;
        for(Task t: this.taskList){
            if(t.getId() == id){
                t.setCompleted();
                System.out.println("Tarefa concluída com sucesso.");
                completed = true;
                break;
            }
        }
        if(!completed){
            System.out.println("Tarefa não localizada.");
        }
    }

    //Imprimir lista de tarefas
    public String getTaskDescription(int id){
        return this.task.getTaskDescription();
    }

    public String toString(){
        String taskListString = "\nLista de tarefas: \n";
        for(Task i: taskList){
            taskListString = taskListString + i.toString() + "\n";
        }
        return taskListString;
    }

    //Teste
    /*
    public static void main(String[] args) {
        Tasks taskList =new Tasks();
        System.out.println("---------------------------");
        taskList.createTask("task1");
        taskList.createTask("task2");
        taskList.createTask("task3");
        taskList.createTask("task4");
        taskList.createTask("task5");
        System.out.println(taskList.toString());
        System.out.println("Removendo tarefa de ID 2");
        taskList.removeTask(2);
        System.out.println("Nova " + taskList.toString());
        System.out.println("Removendo tarefa de ID 6");
        taskList.removeTask(6);
        System.out.println("Nova " + taskList.toString());
        System.out.println("Marcando como concluída a tarefa de ID 3");
        taskList.completeTask(3);
        System.out.println("Nova " + taskList.toString());
    }

     */

}
