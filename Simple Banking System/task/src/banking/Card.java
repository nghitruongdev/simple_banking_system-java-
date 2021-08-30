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

    public static int generateChecksum(String number) {
        char[] chars = number.toCharArray();
        int sum = 0;
        for (int i = 0; i < chars.length; i++) {
            //convert char to int
            int num = Integer.parseInt(String.valueOf(chars[i]));
            //if even (or odd if we count from 1), multiply by 2
            num = i % 2 != 0 ? num : num * 2;
            //if greater than 9, minus 9
            num = num > 9 ? num - 9 : num;
            //add sum
            sum += num;
        }
        //return remainder
        return sum % 10 == 0 ? 0 : 10 - (sum % 10);
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
