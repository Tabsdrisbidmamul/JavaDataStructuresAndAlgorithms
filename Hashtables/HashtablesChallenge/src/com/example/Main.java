package com.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        /*
        * CHALLENGE 1:
        *   Complete the hashing function, so that it will populate the nums array
        *
        * CHALLENGE 2:
        *   - Remove duplicate items from a Linked List
        *   - Your solution must use the JDK's LinkedList class
        *   - Your solution must use a HashMap
        *
        *
        * */

        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee("Jane", "Jones", 123));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Mike", "Wilson", 45));
        employees.add(new Employee("Mary", "Smith", 5555));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Bill", "End", 3948));
        employees.add(new Employee("Jane", "Jones", 123));

        Map<String, Employee> hashmap = new HashMap<>();

        for(Employee employee: employees) {
            hashmap.putIfAbsent(employee.getLastName(), employee);
        }

        employees = new LinkedList<>(hashmap.values());

        employees.forEach(System.out::println);
        System.out.println("---HASHMAP---");
        hashmap.forEach((k, v) -> System.out.printf("Key: %s, Value: %s\n", k, v));


//        int[] nums = new int[10];
//        int[] numsToAdd = {59382, 43, 6894, 500, 99, -58};
//
//        for (int i = 0; i < numsToAdd.length; i++) {
//            nums[hash(numsToAdd[i])] = numsToAdd[i];
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(nums[i]);
//        }
//
//        System.out.println(Arrays.toString(nums));
    }

    public static int hash(int value) {
        return Math.abs(value % 10);
    }
}
