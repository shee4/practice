package com.company;

import java.util.stream.IntStream;

public class CubesSum {

    public static void main(String[] args) {
        for (int i : CubesSum.matches(0, 5000)) {
            System.out.println(i);
        }
    }

    static int[] matches(int start, int end){
        return IntStream.rangeClosed(start, end).filter(CubesSum::check).toArray();
    }

    private static boolean check(int num){
        char[] chars = String.valueOf(num).toCharArray();
        int result = 0;
        for (char ch : chars)
            result += Math.pow(Character.getNumericValue(ch), 3);
        return result == num;
    }
}
