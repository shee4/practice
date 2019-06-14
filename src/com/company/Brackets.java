package com.company;

import java.util.Stack;

public class Brackets {

    public static void main(String[] args) {
        System.out.println(check("(())"));
    }

    static String check(String input){
        Stack<Character> brackets = new Stack<>();
        int count = 0;
        char[] inp = input.toCharArray();
        for (char ch : inp) {
            if(ch == '(') brackets.push(ch);
            else {
                if(brackets.empty()) return "Ошибка";
                brackets.pop();
                count++;
            }
        }
        return brackets.empty() ? Integer.toString(count) : "Ошибка";
    }
}
