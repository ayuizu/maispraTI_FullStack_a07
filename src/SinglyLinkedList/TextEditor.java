package SinglyLinkedList;
import java.util.ArrayList;

//Classe para Editor de Texto
public class TextEditor {
    private ArrayList<TextEdit> editionsList;
    private int index;

    //Classe para edição de texto
    public static class TextEdit{
        private String text;
        private int id;
        //Metodo construtor
        public TextEdit(String text){
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
    public TextEditor() {
        editionsList = new ArrayList<>();
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
    TextEdit editMemo;

    //Adicionar uma edição
    public void addEdit(String text){
        TextEdit edit = new TextEdit(text);
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
        for(TextEdit edit : editionsList){
            text = text + edit.toString() + "\n";
        }
        return text;
    }

    //Teste
    /*
    public static void main(String[] args) {
        TextEditor te = new TextEditor();
        te.addEdit("'But who can say what's best? That's why you need to grab whatever chance you have of happiness where you find it");
        te.addEdit("'But who can say what's best? That's why you need to grab whatever chance you have of happiness where you find it, and not worry about other people too much.");
        te.addEdit("'But who can say what's best? That's why you need to grab whatever chance you have of happiness where you find it, and not worry about other people too much. My experience tells me that we get no more than two or three such chances in a life time,");
        te.addEdit("'But who can say what's best? That's why you need to grab whatever chance you have of happiness where you find it, and not worry about other people too much. My experience tells me that we get no more than two or three such chances in a life time, and if we let them go, we regret it for the rest of our lives.'\n" +
                "― Haruki Murakami, Norwegian Wood");

        System.out.println("Todos:\n" + te.toString());
        System.out.println("Edição atual:\n" + te.getCurrentEdit()); //4

        te.undoEdit();
        System.out.println("Edição atual após undo:\n" + te.getCurrentEdit()); //3

        te.undoEdit();
        System.out.println("Edição atual após undo:\n" + te.getCurrentEdit()); //2

        te.redoEdit();
        System.out.println("Edição atual após redo:\n" + te.getCurrentEdit());
    }
    */
}
