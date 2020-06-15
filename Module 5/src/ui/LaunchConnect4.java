package ui;

import javafx.application.Application;

import java.util.Scanner;

public class LaunchConnect4{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 'G' for JavaFX GUI or 'T' for text UI:");
        char selection = scanner.next().charAt(0);
        if (selection == 'G')
            Application.launch(Connect4GUI.class);  //this command is used to call a JavaFX class from another class
        else if (selection == 'T')
            new Connect4TextConsole().runGame();   //provide runGame method in TextConsole class
        else
            System.out.println("Invalid Entry!\n");
    }
}
