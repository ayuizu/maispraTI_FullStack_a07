package SinglyLinkedList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

class BrowsingData{
    private String url;
    private String title;
    private String date;
    private int id;

    public BrowsingData(){

    }
    public BrowsingData(String url, String title, String date, int id){
        this.url = url;
        this.title = title;
        this.date = date;
        this.id = id;
    }
    public String getUrl(){
        return url;
    }
    public String getTitle(){
        return title;
    }
    public String getDate(){
        return date;
    }
    public int getId(){
        return id;
    }
    public void setUrl(String url){
        this.url = url;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setDate(){
        LocalDateTime actualDateHour = LocalDateTime.now();
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("dd/MM/uuuu");
        DateTimeFormatter formatterHour = DateTimeFormatter.ofPattern("HH:mm:ss");
        this.date = formatterDate.format(actualDateHour) + " " + formatterHour.format(actualDateHour);
    }
    public void setId(int id){
        this.id=id;
    }
    //Metodo toString
    public String toString(){
        return "ID " + this.id + " - " + this.title + " - Data " + this.date + " - Url " + this.url;
    }

}

public class BrowsingHistory {
    //O histórico de navegação vai armazenar até 5 URLs.
    //Ao atingir 5 históricos, os antigos vão sendo descartados.

    private LinkedList<BrowsingData> browsingHistory;
    private BrowsingData browsingData;
    private int count;

    private int historySize;

    public BrowsingHistory(){
        this.browsingHistory = new LinkedList<>();
        this.historySize = 5;
    }

    //Adicionar URL ao historico
    public void addBrowsingData(String url, String title){
        BrowsingData newData = new BrowsingData();
        newData.setDate();
        newData.setTitle(title);
        newData.setUrl(url);
        if(this.browsingHistory.size()+1>this.historySize){
            this.browsingHistory.remove(0);
            newData.setId(count+1);
            count++;
        }else{
            newData.setId(count+1);
            count++;
        }

        this.browsingHistory.add(newData);
        System.out.println("URL adicionada com sucesso.");
    }
    //Remover URL da lista
    public void deleteBrowsingData(int id){
        boolean removed = false;
        for(BrowsingData d: this.browsingHistory){
            if(d.getId() == id){
                this.browsingHistory.remove(d);
                System.out.println("URL removido com sucesso.");
                removed = true;
                break;
            }
        }
        if(!removed){
            System.out.println("URL não foi removido.");
        }

    }

    //Imprimir lista de tarefas
    public String toString(){
        String text = "\nHistórico de nagevação: \n";
        for(BrowsingData d: this.browsingHistory){
            text = text + d.toString() + "\n";
        }
        return text;
    }

    //Teste
    /*
    public static void main(String[] args) {
        BrowsingHistory history = new BrowsingHistory();

        history.addBrowsingData("https://www.google.com.br/", "Google");
        System.out.println(history.toString());
        history.addBrowsingData("https://www.linkedin.com/", "LinkedIn");
        System.out.println(history.toString());
        history.addBrowsingData("https://www.linkedin.com/", "Instagram");
        System.out.println(history.toString());
        history.addBrowsingData("https://www.linkedin.com/", "YouTube");
        System.out.println(history.toString());
        history.addBrowsingData("https://www.linkedin.com/", "Unisinos");
        System.out.println(history.toString());
        history.addBrowsingData("https://www.linkedin.com/", "Google");
        System.out.println(history.toString());
        history.addBrowsingData("https://www.linkedin.com/", "LinkedIn");
        System.out.println(history.toString());

    }

     */
}
