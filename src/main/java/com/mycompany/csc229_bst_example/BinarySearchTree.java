package com.mycompany.csc229_bst_example;
/**
 *
 * @author MoaathAlrajab
 */
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    private BstNode root;

    public boolean isEmpty() {
        return (this.root == null);
    }

    public void insert(Integer data) {

        if (root == null) {
            this.root = new BstNode(data);
            System.out.println(data + " was inserted");
            return;
        }
        insertNode(this.root, data);
        System.out.print(data + " was inserted");
        System.out.println();
    }

    private BstNode insertNode(BstNode root, Integer data) {

        BstNode tmpNode = null;
        System.out.print(root.getData());
        if (root.getData() >= data) {
            System.out.print("| Left: ");
            if (root.getLeft() == null) {
                root.setLeft(new BstNode(data));
                return root.getLeft();
            } else {
                tmpNode = root.getLeft();
            }
        } else {
            System.out.print("| Right: ");
            if (root.getRight() == null) {
                root.setRight(new BstNode(data));
                return root.getRight();
            } else {
                tmpNode = root.getRight();
            }
        }
        return insertNode(tmpNode, data);
    }

    public void inOrderTraversal() {
        doInOrder(this.root);
    }

    private void doInOrder(BstNode root) {
        // ToDo 1: complete InOrder Traversal 
        if (root == null) {
            return;
        }
        doInOrder(root.getLeft());
        System.out.print(root.getData() + " ");
        doInOrder(root.getRight());
    }
    public void preOrderTraversal() {
        doPreOrder(this.root);
        
    }
    // ToDo 2: complete the pre-order travesal . 
    private void doPreOrder(BstNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getData() + " ");
        doPreOrder(root.getLeft());
        doPreOrder(root.getRight());
    }
    public Integer findHeight() {

        return getHeight(this.root);
    }
    private Integer getHeight(BstNode root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = getHeight(root.getLeft());
        int rightHeight = getHeight(root.getRight());
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    public int getDepth(BstNode node) {
        return getDepth(this.root, node, 0); 
    }
        private int getDepth(BstNode root, BstNode node, int depth) {
        if (root == null) {
            return -1;
        }
        if (root.getData() == node.getData()) {
            return depth;
        }
        int leftDepth = getDepth(root.getLeft(), node, depth + 1);
        if (leftDepth != -1) {
            return leftDepth;
        }
        int rightDepth = getDepth(root.getRight(), node, depth + 1);
        return rightDepth;
    }
   public void print() {
       System.out.println("BST PRINT");
        print("", root, false);
        // ToDo 5: complete the print of the BST
    }
       private void print(String prefix, BstNode node, boolean isLeft) {
        if (node != null) {
            System.out.println(prefix + (isLeft ? "- " : "\\- ") + node.getData());
            print(prefix + (isLeft ? "|   " : "    "), node.getLeft(), true);
            print(prefix + (isLeft ? "|   " : "    "), node.getRight(), false);
        }
    }


}
