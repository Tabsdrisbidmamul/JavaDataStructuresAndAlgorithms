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
    }

    public static boolean checkForPalindrome(String string) {
        if(string.length() > 0) {
            Stack<String> stack = new Stack<>();
            ArrayQueue queue = new ArrayQueue(10);

            String[] newString = string.replaceAll("[ .!?,;()'\\-\\[\\]]", "").toLowerCase().split("");

            for(String letter: newString) {
                stack.push(letter);
                queue.enqueue(letter);
            }

            while(!stack.isEmpty()) {
                if(queue.dequeue().compareTo(stack.pop()) != 0) return false;
            }

            return true;
        }
        return false;
    }
}
