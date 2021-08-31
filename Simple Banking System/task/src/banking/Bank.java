package banking;


public class Bank {

    public static void menu() {
        while (true) {
            int select = MyInput.readInt("\n1. Create an account\n" +
                    "2. Log into account\n" +
                    "0. Exit");
            switch (select) {
                case 1:
                    createCard();
                    break;
                case 2:
                    logIn();
                    break;
                default:
                    System.out.println("\nBye!");
                    return;
            }
        }
    }

    //create new card for customer
    private static void createCard() {
        final int BIN = 400_000;
        String customerNumber = BIN + MyNumber.getRandomNumberSequence(9);
        String cardNumber = customerNumber + Card.generateChecksum(customerNumber);
        String cardPin = MyNumber.getRandomNumberSequence(4);

        Card card = new Card(cardNumber, cardPin);
        Card.issuedCardList.add(card);
        System.out.println("\nYour card has been created");
        MyDB.insertCard(card);
        card.showInfo();
    }

    private static void logIn() {
        //read userInput
        String cardNumber = MyInput.readLine("Enter your card number:");
        String cardPin = MyInput.readLine("Enter your PIN:");

        //create temp card from userInput to compare with cards in issuedList
        Card card = findCard(new Card(cardNumber, cardPin));
        if (card != null) {
            //card was found
            System.out.println("\nYou have successfully logged in");
            card.menu();
        } else {
            //no card was found
            System.out.println("\nWrong card number or PIN!");
        }
    }

    private static Card findCard(Card userInput) {
        //if card in issuedList, return this card
        for (Card card : Card.issuedCardList) {
            if (card.equals(userInput)) {
                return card;
            }
        }
        return null;
    }

}
