package com.hassan;
public class Array {
    private int[] items;
    private int size=0;


    public Array(int length)
    {
        items = new int[length];
    }

    public void print()
    {
        for (int i = 0; i < this.size; i++) {
            System.out.println(items[i]);
        }
    }
    public void insert(int item)
    {
        if(items.length==size)
        {
            int[] temp = new int[2*size];
            for (int i = 0; i < size; i++) {
                temp[i] = items[i];
            }
            this.items = temp;
        }

        items[size] = item;
        size++;

    }
    public int getSize()
    {
        return this.size;
    }
    public void removeAt(int index)
    {
        if(index>=size)
        {
            System.out.println("index out of bound");
        }
        else
        {
        for (int i = index; i < size; i++) {
            items[i] = items[i+1];
        }
        size--;
        }
    }
    public int indexOf(int value)
    {
        for (int i = 0; i < size; i++) {
            if(items[i]==value)
                return i;
        }
        return -1;
    }
    public int max()
    {
        int max=0;
        for (int i = 0; i < size; i++) {
            if(items[i]>=max)
                max = items[i];
        }
        return max;
    }
    public Array intersect(int[] items2)
    {
        Array intersect = new Array(size);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < items2.length; j++) {
                if (items[i]==items2[j])
                {
                    intersect.insert(items[i]);
                    break;
                }
            }
        }
        return intersect;
    }
    public void reverse()
    {
        int[] temp = new int[size];
        for (int i = 0; i < size; i++) {
            temp[i]=items[i];
        }
        int j=0;
        for (int i = size-1; i >= 0 ; i--)
        {
            items[j] = temp[i];
            j++;
        }
    }
    public void insertAt(int item, int index)
    {
        if(items.length==size)
        {
            int[] temp = new int[2*size];
            for (int i = 0; i < size; i++) {
                temp[i] = items[i];
            }
            this.items = temp;
        }
        for (int i = size; i >= index ; i--)
            items[i] = items[i-1];
        items[index] = item;
        size++;
    }
}
