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
        root.insert(8);
        root.insert(10);
//        System.out.println(root.find(10));
//        System.out.println(root.find(5));
//        System.out.println(root.find(15));
//        System.out.println(root.find(6));
//        System.out.println(root.find(1));
//        System.out.println(root.find(18));
        root.traversePreOrder();
        root.traverseInOrder();
        System.out.println("==========");
        root.traversePostOrder();
    }
}