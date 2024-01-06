public class CircularLinkedList {
    class Node {
        int data;
        Node  next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public Node head = null;
    public Node tail = null;

    public void addAtStart(int data){
        Node newNode = new Node(data);
        if(head == null) {
            head = tail = newNode;
            tail.next = head;
        }
        else{
            newNode.next = head;
            tail.next = newNode;
            head = newNode;
        }
    }
    public void addAtEnd(int data){
        Node newNode = new Node(data);
        if(head == null) {
            head = tail = newNode;
            tail.next = head;
        }
        else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void addAtPostion(int data, int position){
        Node newNode = new Node(data);
        if(position == 1)
            addAtStart(data);
        else{
            Node current = head;
            int count = 1;
            while(count < position-1){
                current = current.next;
                count++;
            }
            if(current.next == head)
                addAtEnd(data);
            else{
                newNode.next = current.next;
                current.next = newNode;

            }
        }
    }

    public void addBeforeElement(int data, int element){
        Node newNode = new Node(data);
        Node current = head;
        int count = 1;
        if(current.data == head.data){
            newNode.next = head;
            tail.next = newNode;
            head = newNode;
        }
        while (current.next.data != element ){
           current = current.next;
           count++;
        }

        if (current.next == head) {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
        else{
            newNode.next = current.next;
            current.next = newNode;
        }
    }
    public void display(){
        Node current = head;
        int count  = 0;
        if(head == null){
            System.out.println("List is Empty");
            return;
        }
        else{
            do{
                System.out.println("Data"+" "+current.data+ " ");
                System.out.println("Next"+" "+current.next);
                current = current.next;
                count++;
            } while (current!=head);

        }
        System.out.println();
        System.out.println("Number of nodes in linked list are"+" "+count );
    }

    public static void main(String[]args){
        CircularLinkedList circularLinkedList = new CircularLinkedList();
        circularLinkedList.addAtStart(20);
        circularLinkedList.addAtStart(10);
        circularLinkedList.addAtEnd(30);
        circularLinkedList.addAtPostion(35,2 );
        circularLinkedList.addBeforeElement(5,10);
        System.out.println("Linked List");
        circularLinkedList.display();
        System.out.println();
        System.out.println("Head"+" "+ circularLinkedList.head.data);
        System.out.println("Tail"+" "+ circularLinkedList.tail.data);
    }
}
