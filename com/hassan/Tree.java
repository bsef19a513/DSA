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
    public Node root;
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

}
