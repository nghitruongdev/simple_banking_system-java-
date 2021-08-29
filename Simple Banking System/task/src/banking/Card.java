package banking;

import java.util.ArrayList;
import java.util.Objects;

public class Card {
    private final String cardNumber;
    private String cardPin;
    private double balance;
    public static ArrayList<Card> issuedCardList = new ArrayList<>();

    public Card(String cardNumber, String cardPin) {
        this(cardNumber, cardPin, 0);
    }

    public Card(String cardNumber, String cardPin, double balance) {
        this.cardNumber = cardNumber;
        this.cardPin = cardPin;
        this.balance = balance;
    }

    public void menu() {
        boolean isClosed = false;
        while (!isClosed) {
            int select = MyInput.readInt("\n1. Balance\n" +
                    "2. Log out\n" +
                    "0. Exit");
            switch (select) {
                case 1:
                    System.out.println("\nBalance: " + this.balance);
                    break;
                case 2:
                    System.out.println("\nYou have successfully logged out!");
                default:
                    isClosed = true;
            }
        }
    }

    public void showInfo() {
        System.out.printf("Your card number:\n" +
                "%s\n" +
                "Your card PIN:\n" +
                "%s\n", this.cardNumber, this.cardPin);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return cardNumber.equals(card.cardNumber) && cardPin.equals(card.cardPin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, cardPin);
    }
}
