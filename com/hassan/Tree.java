package com.hassan;

public class Tree {
    private class Node
    {
        private int value;
        private Node leftChild;
        private Node rightChild;
        public Node(int value)
        {
            this.value = value;
        }
        @Override
        public String toString()
        {
            return "Node:"+value;
        }
    }
    private Node root;
    public void insert(int value)
    {
        var node = new Node(value);
        if(root==null)
        {
            root = node;
            return;
        }
        var current = root;
        while (true)
        {
            if(value < current.value)
            {
                if(current.leftChild==null)
                {
                    current.leftChild=node;
                    break;
                }
                current = current.leftChild;
            }
            else if(value> current.value)
            {
                if(current.rightChild==null)
                {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }
    }
    public boolean find(int value)
    {
        var current = root;
        while(current!=null)
        {
        if(current.value==value)
            return true;
        if(value< current.value)
            current=current.leftChild;
        else if(value>current.value)
            current=current.rightChild;
        }
        return false;
    }
    public int factorial(int n)
    {
        if(n==1)
            return n;
        return n*factorial(n-1);
    }
    public  void traversePreOrder()
    {
        traversePreOrder(root);
    }
    public  void traverseInOrder()
    {
        traverseInOrder(root);
    }
    public  void traversePostOrder()
    {
        traversePostOrder(root);
    }
    private void traversePreOrder(Node root)
    {
        if(root == null)
            return;
        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }
    private void traverseInOrder(Node root)
    {
        if(root == null)
            return;
        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }
    private void traversePostOrder(Node root)
    {
        if(root == null)
            return;
        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }
    public int height()
    {
        return height(root);
    }
    private int height(Node root)
    {
        if(root == null)
            return -1;
        if(root.rightChild==null && root.leftChild==null)
            return 0;
        return 1 + Math.max(height(root.leftChild),height(root.rightChild));
    }

}
