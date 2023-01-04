import com.hassan.*;
import com.sun.jdi.connect.Connector;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
//        Heap heap = new Heap();
//        heap.insert(10);
//        heap.insert(5);
//        heap.insert(17);
//        heap.insert(4);
//        heap.insert(22);

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

//        int numbers[] = {5,4,1,2,3,10};
//        Heap heap1 = new Heap();
//        for (var number:
//             numbers) {
//            heap1.insert(number);
//        }
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
//        int nums[] = {5,3,8,4,1,2};
//        MaxHeap.heapify(nums);
//        System.out.println(Arrays.toString(nums));

        // kth Largest Number
//        System.out.println(MaxHeap.kthLargestNumber(nums,6));

        //********************************************
        // Trie
//        var trie = new Trie();
//        trie.insert("car");
//        trie.insert("card");
//        trie.insert("care");
//        trie.insert("careful");
//        trie.insert("egg");
//        System.out.println(trie.contains("can"));
//        System.out.println(trie.contains("canada"));
//        var words = trie.findWords(null);
//        System.out.println(words);
//        trie.traverse();


        //*********************************************
        // Graph

//        var graph = new Graph();
//        graph.addNode("A");
//        graph.addNode("B");
//        graph.addNode("C");
//        graph.addNode("D");
//        graph.addEdge("A","B");
//        graph.addEdge("B","C");
//        graph.addEdge("C","A");
//        graph.addEdge("D","A");
//        graph.print();
//        graph.removeEdge("A","B");
//        graph.removeNode("A");
//        graph.traverseDepthFirst("A");
//        graph.traverseBreadthFirst("A");
//        var list = graph.topologicalSort("X");
//        System.out.println(list);
//        System.out.println(graph.hasCycle());

        //*************************************
        // Undirected Graph

//        var graph = new WeightedGraph();
//        graph.addNode("A");
//        graph.addNode("B");
//        graph.addNode("C");
//        graph.addEdge("A","B",3);
//        graph.addEdge("A","C",2);
//        graph.print();

//        var reversed = StringUtils.reverseString("hello Friends");
//        var reversedSentence = StringUtils.reverseWords("  hello Friends  ");
//        var vowelCount = StringUtils.CountVowels("Hello friends");
//        var isRotation = StringUtils.areRotations("ABCD","DABC");
//        var word = StringUtils.removeDuplicates("Trees are beautifull");
//        var frequent = StringUtils.getMaxOccuringChar("hello");
//        var capitalize = StringUtils.capitalize("  Hello   how re   asd   ");
//        var anagram = StringUtils.areAnagrams("ABCD","BCDA");
//        var anagram = StringUtils.areAnagrams("ABCDA","ABDCA");
        var palindrome = StringUtils.isPalindrome("AB   BAA");
        System.out.println(palindrome);
    }

}