//LL.java

public class LL {

    static Node head;
    public static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = next;
        }
    }

    Node reverse (Node node){
        if(head == null || head.next == null )
            return head;
        Node prev = null;
        Node current = head;
        Node next = null;
        Node forward = null;
        while(current != null){
            forward = current.next;
            current.next = prev;
            prev = current;
            current = forward;
        }
        
        return prev;
    }

    void printList(Node node){
        while(node != null){
            System.out.println(node.data + " ");
            node = node.next;
        }
    }

}

//Main.java
public class Main {

    public static void main(String[] args) {
        LL list = new LL();
        list.head = new LL.Node(5);
        list.head.next = new LL.Node(20);
        list.head.next.next = new LL.Node(14);
        list.head.next.next.next = new LL.Node(19);
        list.head.next.next.next.next = new LL.Node(100);

        System.out.println("Given Linked List");
        list.printList(list.head);
        list.head = list.reverse(list.head);
        System.out.println(" ");
        System.out.println("Reverse Linked List");
        list.printList(list.head);

    }
}


