package banking;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i += 2) {
            if ("-fileName".equals(args[i])) {
                MyDB.setDbName(args[i + 1]);
            }
        }
        MyDB.createTable();
        Bank.menu();
    }
}
