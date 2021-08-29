package banking;


public class Bank {

    public static void menu() {
        boolean isClosed = false;
        while (!isClosed) {
            int select = MyInput.readInt("\n1. Create an account\n" +
                    "2. Log into account\n" +
                    "0. Exit");
            switch (select) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    logIn();
                    break;
                default:
                    isClosed = true;
                    System.out.println("\nBye!");
            }
        }
    }

    //create new account for customer
    private static void createAccount() {
        final int BIN = 400_000;
        String cardNumber = BIN + MyNumber.getRandomNumberSequence(10);
        String cardPin = MyNumber.getRandomNumberSequence(4);

        Card card = new Card(cardNumber, cardPin);
        Card.issuedCardList.add(card);
        System.out.println("\nYour card has been created");
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
