package banking;

import java.util.Scanner;

public class MyInput {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readLine(String message){
        System.out.println(message);
        return scanner.nextLine();
    }

    public static int readInt(String message){
        try{
            return Integer.parseInt(readLine(message));
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }
}
