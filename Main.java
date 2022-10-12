import com.hassan.LinkedList;

public class Main {
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        list.addFirst(20);
        list.addFirst(10);
        System.out.println(list.size());
        int[] array = list.toArray();
        for (int item:
        array) {
            System.out.println(item);
        }
    }
}
