package com.example;

import java.util.LinkedList;
import java.util.ListIterator;

public class ChainedHashtable {
    private LinkedList<StoredKey>[] hashtable;

    public ChainedHashtable() {
        hashtable = new LinkedList[10];
        for (int i=0; i<hashtable.length; i++) {
            hashtable[i] = new LinkedList<>();
        }
    }

    public void put(String key, Employee employee) {
        int hashedKey = hashKey(key);
        hashtable[hashedKey].add(new StoredKey(key, employee));
    }

    public Employee get(String key) {
        int hashedKey = hashKey(key);
        ListIterator<StoredKey> iterator = hashtable[hashedKey].listIterator();
        StoredKey employee;
        while(iterator.hasNext()) {
            employee = iterator.next();
            if(employee.key.equals(key)) {
                return employee.employee;
            }
        }

        return null;
    }

    public Employee remove(String key) {
        int hashedKey = hashKey(key);
        ListIterator<StoredKey> iterator = hashtable[hashedKey].listIterator();
        StoredKey employee;
        while(iterator.hasNext()) {
            employee = iterator.next();
            if(employee.key.equals(key)) {
                iterator.remove();
                return employee.employee;
            }
        }
        return null;
    }

    private int hashKey(String key) {
//        return key.length() % hashtable.length;
        return Math.abs(key.hashCode() % hashtable.length);
    }


    public void printHashTable() {
        for (int i=0; i<hashtable.length; i++) {
            if(hashtable[i].isEmpty()) {
                System.out.printf("Position %d: Empty\n", i);
            } else {
                System.out.printf("Position %d:\n\t", i);
                for (StoredKey storedKey : hashtable[i]) {
                    System.out.printf("%s -> ", storedKey.employee);
                }
                System.out.println("NULL");
            }
        }
    }

    private class StoredKey {
        private String key;
        private Employee employee;

        private StoredKey(String key, Employee employee) {
            this.key = key;
            this.employee = employee;
        }

    }
}
