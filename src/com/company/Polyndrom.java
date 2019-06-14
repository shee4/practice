package com.company;

import java.util.Scanner;

public class Polyndrom {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number sequence: ");
        if(isPalindrome(scan.nextLine()))
            System.out.println("the number is palindrome!");
        else
            System.out.println("the number isn't a palindrome");

    }

    private static boolean isPalindrome(String str){
        String toCompare = new StringBuilder(str).reverse().toString();
        return toCompare.equals(str);
    }
}
