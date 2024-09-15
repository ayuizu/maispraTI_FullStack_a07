package DataStructure;


public class SinglyLinkedList {

    private static class Node {
        protected int data;
        protected Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    //Construtor - ao iniciar não há dados
    public SinglyLinkedList() {
        this.head = null;
    }

    public int getSize() {
        int count = 0;
        Node currentNode = this.head;

        while (currentNode != null) {
            count++;
            currentNode = currentNode.next;
        }
        return count;
    }

    public boolean isEmpty() {
        return this.head == null;
    }
    public void add(int data){
        Node newNode = new Node(data);
        if(this.head == null){
            this.head = newNode;
        }else{
            Node current = this.head;
            while(current.next != null){
                current = current.next;
            }
            current.next=newNode;
        }
    }
    public int get(int index){
        //Inicia no primeiro nó
        Node current = this.head;
        int count = 0;
        //Percorre a lista enquanto nó não for null
        while(current != null){
            if(count == index){
                return current.data; //Se contador = index procurado, retorna o dado
            }
            count++;
            current = current.next; //Avança para o próximo nó
        }
        //Se não encontrar o index, devolve aviso
        throw new IndexOutOfBoundsException("Index fora dos limites/inválido");
    }

    public void remove(int index){
        //Inicia no priemiro nó
        Node current = this.head;
        //Verifica se lista não está vazia
        if(this.head == null){
            throw new IndexOutOfBoundsException("Index fora dos limites/inválido");
        }
        //Verifica se o índice é 0 (remove primeiro nó)
        if(index == 0){
            this.head = this.head.next;
            return;
        }

        int count = 0;
        Node previous = null; //Armazena dados do nó anterior

        //Move os nós até o índice buscado ou final da lista
        while(current != null && count < index){
            previous = current; //Nó anterior recebe o nó atual
            current = current.next; //Nó atual recebe o próximo nó
            count++;
        }
        //Verifica se nó atual é nulo e avisa
        if(current == null){
            throw new IndexOutOfBoundsException("Index fora dos limites/inválido");
        }
        //Remove o nó atual - próximo do anterior = próximo do atual (!=atual)
        previous.next = current.next;
    }

    private int size(){
        // Começa do primeiro nó.
        Node current = this.head;
        int count = 0;
        //Percorre a lista enquanto o nó atual não for nulo.
        while(current != null){
            count++;
            current = current.next; //Avança para o próximo nó.
        }
        // Retorna o número total de nós na lista.
        return count;
    }

}
