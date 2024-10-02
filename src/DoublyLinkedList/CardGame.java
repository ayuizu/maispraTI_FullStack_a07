package DoublyLinkedList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Objects;

public class CardGame {

    public static class Card{
        protected String cardSuit;
        protected String cardValue;

        public Card(String cardSuit, String cardValue) {
            this.cardSuit = cardSuit;
            this.cardValue = cardValue;
        }
        public String getCardSuit() {
            return this.cardSuit;
        }
        public String getCardValue() {
            return this.cardValue;
        }
        public void setCardSuit(String cardSuit) {
            this.cardSuit = cardSuit;
        }
        public void setCardValue(String cardValue) {
            this.cardValue = cardValue;
        }
        @Override
        public String toString() {
            return cardValue + " de " + cardSuit;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Card card = (Card) obj;
            return cardSuit.equals(card.cardSuit) && cardValue.equals(card.cardValue);
        }
        @Override
        public int hashCode() {
            return Objects.hash(cardSuit, cardValue);
        }
    }

    private LinkedList<Card> cardsHand;

    public CardGame() {
        cardsHand = new LinkedList<Card>();
    }
    public void addCard(String cardSuit, String cardValue) {
        cardsHand.add(new Card(cardSuit, cardValue));
    }

    public void removeCard(String cardSuit, String cardValue) {
        cardsHand.remove(new Card(cardSuit,cardValue));
    }

    @Override
    public String toString() {
        return cardsHand.toString();
    }

    public LinkedList<Card> organizeHand(String suit1, String value1, String suit2, String value2) {
        Card card1 = new Card(suit1, value1);
        Card card2 = new Card(suit2, value2);
        if(cardsHand.contains(card1) && cardsHand.contains(card2)){
            int ind1 = cardsHand.indexOf(card1);
            int ind2 = cardsHand.indexOf(card2);
            cardsHand.set(ind1, card2);
            cardsHand.set(ind2, card1);
            return cardsHand;
        }else{
            System.out.println("Cartas não localizadas");
            return null;
        }
    }

    public static void main(String[] args){
        CardGame game = new CardGame();
        game.addCard("E","A");
        game.addCard("D","2");
        game.addCard("E","3");
        game.addCard("P","4");
        game.addCard("O","5");
        System.out.println(game.toString());
        game.organizeHand("E","A","P","4");
        System.out.println(game.toString());
    }

}

