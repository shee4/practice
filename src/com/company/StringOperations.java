package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Stream;

public class StringOperations {

    public static void main(String[] args) {

        operate();
    }

    public static void operate() {

        Scanner scan = new Scanner(System.in);

        String text = getText(scan);
        System.out.println();

        int operation;

        while (true) {
        System.out.println("Enter operation number: \n" +
                "1 - Number of characters in the text \n" +
                "2 - Number of words in the text \n" +
                "3 - Number of lines in the text \n" +
                "4 - The maximum length of the string in the text \n" +
                "5 - Convert text to uppercase \n" +
                "6 - Convert text to lowercase \n" +
                "0 - exit\n");

        operation = Integer.parseInt(scan.next());

            switch (operation) {
                case 1:
                    System.out.println("Number of characters in the text: " + text.length() + "\n");
                    break;
                case 2:
                    System.out.println("Number of words in the text: " + text.split("[^a-zA-z]+").length + "\n");
                    break;
                case 3:
                    System.out.println("Number of lines in the text: " + text.split("\n").length + "\n");
                    break;
                case 4:
                    Stream<String> stream = Arrays.stream(text.split("\n"));
                    System.out.println("The maximum length of the string in the text: " + stream.max(Comparator.comparingInt(String::length)).get().length() + "\n");
                    break;
                case 5:
                    System.out.println("Convert text to uppercase: \n" + text.toUpperCase() + "\n");
                    break;
                case 6:
                    System.out.println("Convert text to lowercase: \n" + text.toLowerCase() + "\n");
                    break;
                case 0:
                    Runtime.getRuntime().exit(0);
                default:
                    System.out.println("Unknown operation. Please try again\n");
                    break;
            }
        }
    }

    private static String getText(Scanner scan) {

        String text = "";

        System.out.println("Enter text (STOP INPUT on new line to finish):");

        while (true) {
            String append = scan.nextLine();
            if (append.equals("STOP INPUT")) break;
            text += append + "\n";
        }

        return text;
    }
}
