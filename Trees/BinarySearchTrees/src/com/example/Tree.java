package com.example;

import javax.swing.tree.TreeNode;

public class Tree {
    private TreeNode root;

    public Tree() {
        this.root = null;
    }

    public void insert(int value) {
        if(isEmpty()) {
            System.out.printf("Empty tree, inserting %d as the root node\n", value);
            root = new TreeNode(value);
        } else {
            root.insert(value);
        }
    }

    public TreeNode get(int value) {
        if(!isEmpty()) {
            return root.get(value);
        }
        return null;
    }

    public void delete(int value) {
        root = delete(root, value); // returns the root of the subtree
    }

    private TreeNode delete(TreeNode subTreeRoot, int value) {
        // test to see empty TreeNodeList return null essentially
        if(subTreeRoot == null) {
            return subTreeRoot;
        }
        /* the 2 iffys handle the traversing of the tree always making sure that subtree root node becomes the child
           of the node we are checking against

           The moment when the node equal to the data, we have found the node we are looking for

                                            25
                                           /  \
                                          20   27
                                         /       \
                                        15        30
                                          \
                                           17

            Subtree root node when entered into the delete method is 25 - the root node
            when the method is recursively called it will be passing in either the left/ right child node
            so in this case 20 or 27 as the subTreeRoot - so as we go further down in the rabbit hole of recursion we
            always have a reference to the subTreeRoot Node or basically its parent node


        */
        if(value < subTreeRoot.data) {
            subTreeRoot.leftChild = delete(subTreeRoot.leftChild, value);
        } else if (value > subTreeRoot.data) {
            subTreeRoot.rightChild = delete(subTreeRoot.rightChild, value);
        // We have found the node we are looking for as its one of the children of the subTreeRoot
        // now there are  3 cases that can happen
        /*
        * 1. Its a leaf node
        * 2. Its a left/ right child node of its subtree root node
        * 3 There are 2 children
        *
        * */
        } else {
            /*
            * In this code we cover the first 2 cases
            *                               25
                                           /  \
                                          20   27
                                         /       \
                                        15        30
                                          \
                                           17
            *
            * If we have a tree like this and we want to do case 1, where we target a leaf node
            * root = delete(25, 17)
            *   In delete we check if 17 < 25: TRUE
            *   So we set 25's leftChild (20) to be equal to delete(20, 17)
            *
            * Node 25 Left Child (Node 20) = (20, 17)
            *   17 < 20: TRUE
            *   So we set 20's leftChild to be equal to delete(15, 17)
            *
            * Node 20 Left Child (Node 15) = (15, 17)
            *   17 > 15: TRUE
            *   So we set 15's rightChild to be equal to delete(17, 17)
            *
            * Node 15 Right Child (Node 17) = (17, 17)
            *   17 < 17 FALSE
            *   17 > 17 FALSE
            *
            * We found the node, so we go to the else block and the first check for leftChild == null is true
            * (rightChild == null is true but the first one condition is ran first) and it will return the leaf
            * node's rightChild - which in this case is null
            *
            * delete(17, 17) = null
            * Node 17 = null
            * Node 15 Right Child = null
            * Node 20 Left Child = Node 15 (with the new edge link, that its right child is null)
            * Node 25 Left Child = Node 20 (with the new edge link from 15)
            *
            * And all the way to the top
            * root = delete(root, value)
            * root now has new reference type connections, as we traversed the left subtree, the right subtree
            * connections are still the same, but its left subtree connections are the one that has changed
            *
            * This code also holds true to when we want to delete a node that has one child
            * root = delete(25, 15)
            *   In delete we check if 15 < 25: TRUE
            *   So we set 25's leftChild (20) to be equal to delete(20, 17)
            *
            * Node 25 Left Child (Node 20) = (20, 15)
            *   15 < 20: TRUE
            *   So we set 20's leftChild to be equal to delete(15, 17)
            *
            * Node 20 Left Child (Node 15) = (15, 15)
            *   15 < 15: FALSE
            *   15 > 15: FALSE
            *   We have found the node
            *
            * We run the else block of code, where we check if it has a left or right child, and simply return it
            *
            * so (15, 15) = Node 17
            * Node 20 Left Child (Node 15) = Node 17
            * Node 25 Left Child (Node 20) = Node 20 (With its new connection that Node 15 has been replaced with
            * Node 17)
            *
            * root = delete(root, value)
            * With the new Node list connections
            * */
            // Case 1 and 2 (Leaf node or 1 child Node)
            if(subTreeRoot.leftChild == null) {
                return subTreeRoot.rightChild;
            } else if (subTreeRoot.rightChild == null) {
                return subTreeRoot.leftChild;
            // Case 3 (Deletion of Node that has 2 Children (that can very well be subtrees))
            } else {
                // Replace the data in the subTreeRoot Node with the smallest value in the right subtree
                subTreeRoot.data = subTreeRoot.rightChild.min().data;

                // Delete the Node that has the smallest value in the right subtree
                /*
                * The line above has gotten the data from the smallest value in the right subtree and set the subtree
                *  root node with the data returned from the min() call
                *
                * We now need to clean up the references - so we call delete on the rightChild of subtree root, and
                * the value that we are deleting is the subtree root data, because everything down below the subtree
                * root contains the data with the reference to the smallest value in that subtree and we essentially
                * need to recreate the rightChild subtree NodeList again with new connections to the Nodes within the
                * Tree structure
                *
                * */
                subTreeRoot.rightChild = delete(subTreeRoot.rightChild, subTreeRoot.data);
            }
        }
        return subTreeRoot;
    }

    public TreeNode min() {
        if(!isEmpty()) {
            return root.min();
        }
        return null;
    }

    public TreeNode max() {
        if(!isEmpty()) {
            return root.max();
        }
        return null;
    }

    public void inOrder() {
        if(!isEmpty()) {
            System.out.println("Data:");
            root.traverseInOrder();
        }
    }

    public void preOrder() {
        if(!isEmpty()) {
            System.out.println("Data:");
            root.traversePreOrder();
        }
    }

    public void postOrder() {
        if(!isEmpty()) {
            System.out.println("Data:");
            root.traversePostOrder();
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    private class TreeNode {
        private int data;
        private TreeNode leftChild;
        private TreeNode rightChild;

        private TreeNode(int data) {
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }

        public void insert(int value) {
            // Duplicates are not added to the tree
            if(data == value) {
                System.out.printf("Duplicate Values (%d) are not allowed\n", value);
                return;
            }

            // check to see if the data is less than the parent node - if so traverse the left subtree
            if(value < data) {
                // found an empty spot! insert the value here
                if(leftChild == null) {
                    System.out.printf("Inserting node value %d at the left subtree\n", value);
                    leftChild = new TreeNode(value);
                // leftChild spot is full, call the insert method on that node till we hit an empty spot
                } else {
                    System.out.printf("Left child spot is full, calling insert on this the left child node for value " +
                            "%d" +
                            " %s\n", value, this);
                    leftChild.insert(value);
                }
            // traversing the right subtree because the value was greater than the parent node
            } else {
                // found an empty spot! insert the value here
                if(rightChild == null) {
                    System.out.printf("Inserting node value %d at the right subtree\n", value);
                    rightChild = new TreeNode(value);
                // rightChild spot is full, call the insert method on that node till we hit an empty spot
                } else {
                    System.out.printf("Right child spot is full, calling insert on this the right child node for " +
                            "value %d" +
                            " %s\n", value, this);
                    rightChild.insert(value);
                }
            }
        }

        public TreeNode get(int value) {
            if(value == data) {
                return this;
            }

            if(value < data) {
                if(leftChild != null) {
                    return leftChild.get(value);
                }

            } else {
                if(rightChild != null) {
                    return rightChild.get(value);
                }
            }

            return null;
        }

        public TreeNode min() {
            if(leftChild != null) {
                return leftChild.min();
            }
            return this;
        }

        public TreeNode max() {
            if(rightChild != null) {
                return rightChild.max();
            }
            return this;
        }

        public void traverseInOrder() {
            /*
            * How this method works?
            * - We check if the the current node (the subtree root node) has any left and right children
            *
            * - if so, lets recursively call the traverseInOrder method again but on the left child first, this will
            * push each method call onto the call stack
            *
            * - We keep recursively calling this method till we come across a leaf node (one that does not have
            *   children)
            *
            * - When we come across a leaf node, the check to see if the leftChild is not equal to null will fail and
            *  then go to the print statement where it will output the node data
            *
            * - The code will then go to check if the leaf node has any right child - which will be false so the
            * program execution of this method will end
            *
            * - The call stack will then pop the previous call to traverseInOrder - which will be the parent of the
            * leaf node, its code will then go to the print statement and print the node data
            *
            * - It will then check if there is any right child, if so it will recursively call the method but for the
            *  right child
            *
            * - Until it comes to a point where it hits another leaf node - and repeats the process for checking
            * children on a leaf node
            * */
            if(leftChild != null) {
                leftChild.traverseInOrder();
            }
            System.out.printf("%d, ", data);
            if(rightChild != null) {
                rightChild.traverseInOrder();
            }
        }

        public void traversePreOrder() {
            System.out.printf("%d, ", data);
            if(leftChild != null) {
                leftChild.traversePreOrder();
            }

            if(rightChild != null) {
                rightChild.traversePreOrder();
            }
        }

        public void traversePostOrder() {
            if(leftChild != null) {
                leftChild.traversePostOrder();
            }

            if(rightChild != null) {
                rightChild.traversePostOrder();
            }
            System.out.printf("%d, ", data);
        }



        @Override
        public String toString() {
            return "TreeNode{" +
                    "data=" + data +
                    ", leftChild=" + leftChild +
                    ", rightChild=" + rightChild +
                    '}';
        }
    }
}
