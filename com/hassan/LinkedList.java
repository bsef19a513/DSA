package com.hassan;

import java.util.NoSuchElementException;

public class LinkedList {

    public class Node {
        private int value;
        private Node next;
        public Node(int value)
        {
            this.value=value;
        }

    }

    private Node first;
    private Node last;
    private int size;

    public void addFirst(int value)
    {
        Node temp = new Node(value);
        if(isEmpty())
            first = last = temp;
        else
        {
            temp.next = first;
            first = temp;
        }
        size++;
    }
    public void addLast(int value)
    {
        Node temp = new Node(value);
        if(isEmpty())
            first = last = temp;
        else
        {
            last.next = temp;
            last = temp;
        }
        size++;
    }
    public int indexOf(int value)
    {
        if(isEmpty())
            return -1;
        else
        {
            int index=0;
            var temp = first;
            while (temp!=null)
            {
                if(temp.value==value)
                    return index;
                temp = temp.next;
                index++;
            }
            return -1;
        }
    }
    public Boolean contains(int value)
    {
        if(isEmpty())
            return false;
        else
        {
            var temp = first;
            while(temp!=null)
            {
                if(temp.value==value)
                    return true;
                temp = temp.next;
            }
            return false;
        }
    }
    public void removeFirst()
    {
        if(isEmpty())
            throw new NoSuchElementException();
        if(first==last)
        {
            first = last = null;
            size--;
        }
        var second = first.next;
        first.next = null;
        first = second;
        size--;
    }
    public void removeLast()
    {
        var temp = first;
        if(!isEmpty())
        {
            while(temp.next!=last)
            {
                temp = temp.next;
            }
            last = temp;
            last.next = null;
        }
        if(first==last)
        {
            first = last =null;
        }
        size--;
    }
    public int size()
    {
        return size;
    }
    public int[] toArray()
    {
        int[] converted = new int[size];
        var temp = first;
        for (int i = 0; i < size; i++) {
            converted[i] = temp.value;
            temp = temp.next;
        }
        return converted;
    }
    private boolean isEmpty()
    {
        return first == null;
    }
}
