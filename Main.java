import com.hassan.*;
public class Main {

    public static void main(String[] args) {
        Tree root = new Tree();
        root.insert(10);
        root.insert(5);
        root.insert(15);
        root.insert(6);
        root.insert(1);
        System.out.println(root.find(10));
        System.out.println(root.find(5));
        System.out.println(root.find(15));
        System.out.println(root.find(6));
        System.out.println(root.find(1));
        System.out.println(root.find(18));
    }
}