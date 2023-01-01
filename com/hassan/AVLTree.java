package com.hassan;

public class AVLTree {
    private class AVLNode {
        private int value;
        private int height;
        private AVLNode leftChild;
        private AVLNode rightChild;
        public AVLNode(int value)
        {
            this.value = value;
        }

        @Override
        public String toString()
        {
            return "Value: "+this.value;
        }
    }
    private AVLNode root;

    public void insert(int value)
    {
        root = insert(root,value);
    }

    private AVLNode insert(AVLNode root,int value)
    {
            if(root==null)
                return new AVLNode(value);
            if(value<root.value)
               root.leftChild = insert(root.leftChild, value);
            else
               root.rightChild = insert(root.rightChild,value);
            setHeight(root);
            root = balance(root);

            return root;
    }

    private AVLNode balance(AVLNode root)
    {
        if(isLeftHeavy(root))
        {
            if(balanceFactor(root.leftChild)<0)
                root.leftChild = leftRotation(root.leftChild);
            return rightRotation(root);
        }
        else if(isRightHeavy(root))
        {
            if(balanceFactor(root.rightChild)>0)
                root.rightChild = rightRotation(root.rightChild);
            return leftRotation(root);
        }
        return root;
    }

    private AVLNode leftRotation(AVLNode root)
    {
        var newRoot = root.rightChild;
        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;
        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }
    private AVLNode rightRotation(AVLNode root)
    {
        var newRoot = root.leftChild;
        root.leftChild = newRoot.leftChild;
        newRoot.rightChild = root;
        setHeight(root);
        setHeight(newRoot);
        return newRoot;
    }

    private void setHeight(AVLNode node)
    {
        node.height = Math.max(height(root.leftChild),
                height(root.rightChild))+1;
    }

    private boolean isLeftHeavy(AVLNode node)
    {
        return (balanceFactor(node)>1);
    }
    private boolean isRightHeavy(AVLNode node)
    {
        return (balanceFactor(node)<-1);
    }
    private int balanceFactor(AVLNode node)
    {
        return node==null?0:height(node.leftChild)-height(node.rightChild);
    }
    private int height(AVLNode root)
    {
        return (root==null)?-1:root.height;
    }
}
