package com.company;

import java.util.Scanner;

public class TheHundred {

    static int[] seq;
    static int result;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("input length of sequence");
        int n = scan.nextInt();
        seq = new int[n];

        System.out.println("input sequence:");
        for (int i = 0; i < n; i++) {
            seq[i] = scan.nextInt();
        }

        System.out.println("input result: ");
        result = scan.nextInt();


    }
}
