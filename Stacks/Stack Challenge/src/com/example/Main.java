package com.example;


public class Main {

    public static void main(String[] args) {
        // should return true
        System.out.println(checkForPalindrome("abccba"));
        // should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));
        // should return true
        System.out.println(checkForPalindrome("i"));
        // should return false
        System.out.println(checkForPalindrome(""));

    }

    public static boolean checkForPalindrome(String string) {
        if(string.length() > 0) {
            Stack stack = new Stack();
            String newString = string.replaceAll("[ .!?,;()'\\\\-]", "").toLowerCase();
            char[] charArray = newString.toCharArray();

            for(Character letter: charArray) {
                stack.push(letter.toString());
            }

            StringBuilder sb = new StringBuilder(stack.getSize());
            for(int i = stack.getSize(); i > 0; i--) {
                sb.append(stack.pop());
            }

            return newString.equals(sb.toString());
        }
        return false;
    }
}
