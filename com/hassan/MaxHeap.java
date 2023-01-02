package com.hassan;

public class MaxHeap {
    public static void heapify(int arr[])
    {
        // not inplace heapify algorithm
//        for (int i = 0; i < arr.length; i++)
//        {
//            heapify(arr,i);
//        }
        //inplace heapify algorithm
        var lastParentNode  = arr.length/2-1;
        for (int i = lastParentNode; i >=0 ; i--) {
            heapify(arr,i);
        }
    }
    private static void heapify(int arr[],int index)
    {
        int largerIndex = index;
        int leftIndex = index*2+1;
        if (leftIndex<arr.length && arr[largerIndex]<arr[leftIndex])
            largerIndex = leftIndex;
        int rightIndex = index*2+2;
        if (rightIndex<arr.length && arr[largerIndex]<arr[rightIndex])
            largerIndex = rightIndex;
        if(index==largerIndex)
            return;
        swap(arr,index,largerIndex);
        heapify(arr,largerIndex);
    }

    public static int kthLargestNumber(int numbers[],int k)
    {
        if(k<1||k>numbers.length)
            throw new IllegalArgumentException();
        Heap heap = new Heap();
        for (var number:
             numbers) {
            heap.insert(number);
        }
        for (int i = 0; i < k-1; i++)
            heap.remove();
        return heap.max();
    }

    private static void swap(int arr[],int first,int second)
    {
        var temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
