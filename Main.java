import com.hassan.*;
import com.sun.jdi.connect.Connector;

public class Main {

    public static void main(String[] args) {
        Tree root = new Tree();
        root.insert(7);
        root.insert(4);
        root.insert(9);
        root.insert(1);
        root.insert(6);
        root.insert(28);
        root.insert(10);

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
        root.levelOrderTraversal();
    }
}