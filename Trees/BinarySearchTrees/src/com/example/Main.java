package com.example;

public class Main {

    public static void main(String[] args) {
        Tree intTree = new Tree();
        intTree.insert(25);
        intTree.insert(20);
        intTree.insert(15);
        intTree.insert(17);
        intTree.insert(27);
        intTree.insert(30);
        intTree.insert(29);
        intTree.insert(26);
        intTree.insert(22);
        intTree.insert(32);

        System.out.println("---IN ORDER---");
        intTree.inOrder();

        System.out.println("\n\n---PRE ORDER---");
        intTree.preOrder();

        System.out.println("\n\n---POST ORDER---");
        intTree.postOrder();

        System.out.println("\n\n---GET---");
        System.out.printf("Returned Value := %s\n", intTree.get(15));
        System.out.printf("Returned Value := %s\n", intTree.get(50));
        System.out.printf("Returned Value := %s\n", intTree.get(27));
        System.out.printf("Returned Value := %s\n", intTree.get(30));

        System.out.println("\n---MIN---");
        System.out.println(intTree.min());

        System.out.println("\n---MAX---");
        System.out.println(intTree.max());
    }

}
