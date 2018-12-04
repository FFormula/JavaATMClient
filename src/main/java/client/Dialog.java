package client;

import java.util.Scanner;

public class Dialog {

    private Scanner scanner = new Scanner(System.in);

    public void print(String message) {
        System.out.println(message);
    }

    public String input(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }
}
