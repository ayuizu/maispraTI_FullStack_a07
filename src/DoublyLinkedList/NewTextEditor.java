package DoublyLinkedList;

import java.util.LinkedList;

public class NewTextEditor {
    private LinkedList<NewTextEdit> editionsList;
    private int index;

    //Classe para edição de texto
    public static class NewTextEdit{
        private String text;
        private int id;
        //Metodo construtor
        public NewTextEdit(String text){
            this.text = text;
            this.id = 0;
        }
        //Metodos de acesso
        public String getText(){
            return text;
        }
        public void setText(String text){
            this.text = text;
        }
        public int getId(){
            return id;
        }
        public void setId(int id){
            this.id = id;
        }
        //Metodo toString
        public String toString(){
            return text + " (id " + id + ")";
        }
    }

    //Metodo construtor
    public NewTextEditor() {
        editionsList = new LinkedList<>();
    }
    //Metodos de acesso
    public int getIndex(){
        return index;
    }
    public void setIndex(int index){
        this.index=editionsList.size();
    }
    //Verificar se lista está vazia
    public boolean isEmpty(){
        return editionsList.isEmpty();
    }

    //Variável para guardar 1 edição desfeita. Ela é perdida caso seja adicionado algo antes de recuperá-la.
    NewTextEdit editMemo;

    //Adicionar uma edição
    public void addEdit(String text){
        NewTextEdit edit = new NewTextEdit(text);
        edit.setId(editionsList.size()+1);
        editionsList.add(edit);
        editMemo = null;

    }

    //Voltar uma edição
    public void undoEdit(){
        if(editionsList.isEmpty()){
            System.out.println("Nada a desfazer.");
        }else{
            editMemo = editionsList.get(editionsList.size()-1);
            editionsList.remove(editionsList.size()-1);
        }
    }
    //Recuperar uma edição
    public void redoEdit(){
        if(editMemo == null){
            System.out.println("Nada a recuperar.");
        }else{
            editionsList.add(editMemo);
            editMemo = null;
        }
    }

    //Exibir a edição atual
    public String getCurrentEdit(){
        if(editionsList.isEmpty()){
            System.out.println("Não há edições.");
            return "";
        }else {
            int currentIndex = editionsList.size() - 1;
            return editionsList.get(currentIndex).toString();
        }
    }

    public String toString(){
        String text = "";
        for(NewTextEdit edit : editionsList){
            text = text + edit.toString() + "\n";
        }
        return text;
    }
}
