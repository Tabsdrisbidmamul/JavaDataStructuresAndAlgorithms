package com.example;

public class SimpleHashtable{
    private StoredKey[] hashtable;

    public SimpleHashtable() {
        hashtable = new StoredKey[10];
    }

    private int hashKey(String key) {
        return key.length() % hashtable.length;
    }

    // return true if the space has an Employee
    // return false if the space is null
    // Constant time check O(1)
    private boolean occupied(int index) {
        return hashtable[index] != null;
    }

    // Linear time O(n)
    public void put(String key, Employee employee) {
        int hashedKey = hashKey(key);

        if(occupied(hashedKey)) {
            // true - the index is occupied so we need to do Linear Probing
            // We are going to loop over the array and wrap over it as well till we find an empty spot

            // stopIndex to tell the loop to stop at the first point where we checked for an empty spot
            int stopIndex = hashedKey;

            // Creating the first probe value - because hashtable[hashedKey] is full, so we need to create the first
            // probe value and then check if that space is empty
            if(hashedKey == hashtable.length - 1) {
                // wrapping the probe
                hashedKey = 0;
            } else {
                // incrementing the probe
                hashedKey++;
            }

            while(occupied(hashedKey) && hashedKey != stopIndex) {
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }

        if(occupied(hashedKey)) {
            // We have finished the Linear Probing, and we have reached all available spots - so we cannot add the
            // value to the Hashtable
            System.out.println("Sorry, there is already an employee at position " + hashedKey);
        } else {
            // false - the space is not occupied so we can add the value to the Hashtable
            hashtable[hashedKey] = new StoredKey(key, employee);
        }
    }

    public Employee remove(String key) {
        int hashedKey = findKey(key);
        if(hashedKey == -1) {
            return null;
        }

        Employee employee = hashtable[hashedKey].employee;
        hashtable[hashedKey] = null;

        StoredKey[] oldHashtable = hashtable;
        hashtable = new StoredKey[oldHashtable.length];

        for (StoredKey storedKey : oldHashtable) {
            if(storedKey != null) {
                put(storedKey.key, storedKey.employee);
            }
        }

        return employee;
    }

    // Linear time O(n)
    public Employee get(String key) {
        int hashedKey = findKey(key);
        if(hashedKey == -1) {
            return null;
        }
        return hashtable[hashedKey].employee;
    }

    private int findKey(String key) {
        int hashedKey = hashKey(key);
        // check if the raw key matches with the key in the Hashtable
        if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        }

        // else we have to do Linear Probing
        int stopIndex = hashedKey;
        if (hashedKey == hashtable.length - 1) {
            hashedKey = 0;
        } else {
            hashedKey++;
        }

        /* only increment the hashedKey as follows:
        This assumes that the occupied space is followed by more occupied space, the moment we hit an empty spot - we
        break out of the loop - because of our Linear Probing - which is that it will place the value as soon as it
        find an empty spot
           1. The hashedKey has not reached the stopIndex
           2. The hashedKey is not pointing to an occupied spot
           3. The hashedKey when indexed, the key within that object is different from the raw key passed

        To fix this problem in the Hashtable with our findKey where we want to find Mary using the key "Smith", it
        will index it to 5 - but it is null because of our first implementation of remove() - so we have to rehash
        the table

        public Employee remove(String key) {
            int hashedKey = findKey(key);
            if(hashedKey == -1) {
                return null;
            }

            Employee employee = hashtable[hashedKey].employee;
            hashtable[hashedKey] = null;
            return employee;
        }

        0. Empty
        1. Empty
        2. Empty
        3. Position 3: { firstName='John', lastName='Doe', id=4567 }
        4. Empty
        5. Empty
        6. Empty
        7. Position 7: { firstName='Mary', lastName='Smith', id=22 }
        8. Empty
        9. Empty
        */
        while (hashedKey != stopIndex &&
                hashtable[hashedKey] != null &&
                !hashtable[hashedKey].key.equals(key)) {
            hashedKey = (hashedKey + 1) % hashtable.length;
        }

        if(hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
            return hashedKey;
        } else {
            return -1;
        }
    }

    public void printHashTable() {
        System.out.println("---HASHTABLE---");
        for(int i=0; i<hashtable.length; i++) {
            if(hashtable[i] == null) {
                System.out.println("Empty");
            } else {
                System.out.printf("Position %d: %s\n", i, hashtable[i].employee);
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
