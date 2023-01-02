import com.hassan.*;
import com.sun.jdi.connect.Connector;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Heap heap = new Heap();
        heap.insert(10);
        heap.insert(5);
        heap.insert(17);
        heap.insert(4);
        heap.insert(22);

//        Tree tree2 = new Tree();
//        tree2.insert(7);
//        tree2.insert(4);
//        tree2.insert(9);
//        tree2.insert(1);
//        tree2.insert(6);
//        tree2.insert(28);
//        tree2.insert(10);
//        System.out.println(root.equals(tree2));
//        System.out.println(root.find(10));
//        System.out.println(root.find(5));
//        System.out.println(root.find(15));
//        System.out.println(root.find(6));
//        System.out.println(root.find(1));
//        System.out.println(root.find(18));
//        root.traversePreOrder();
//        root.traverseInOrder();
//        System.out.println("==========");
//        root.traversePostOrder();
//        System.out.println(root.height());
//        System.out.println(root.BSTMin());
//        System.out.println(root.BSTMax());
//        System.out.println(root.isBinarySearchTree());
//        var list = root.getNodesAtDistance(2);
//        for (var items:
//             list) {
//            System.out.println(items);
//        }
//        root.levelOrderTraversal();

        //****************************************************
        // AVL Tree

        //****************************************************
        // Heap

        int numbers[] = {5,4,1,2,3,10};
        Heap heap1 = new Heap();
        for (var number:
             numbers) {
            heap1.insert(number);
        }
        // sort in descending order with heap
//        while (!heap1.isEmpty())
//        {
//            System.out.println(heap1.remove());
//        }
        //sort in ascending order
//        for (int i = numbers.length-1; i >=0 ; i--) {
//            numbers[i] = heap1.remove();
//        }
//        System.out.println(Arrays.toString(numbers));

        // Heapify i.e convert array into heap
        int nums[] = {5,3,8,4,1,2};
//        MaxHeap.heapify(nums);
//        System.out.println(Arrays.toString(nums));

        // kth Largest Number
        System.out.println(MaxHeap.kthLargestNumber(nums,6));
    }
}