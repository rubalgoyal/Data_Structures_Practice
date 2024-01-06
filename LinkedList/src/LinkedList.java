
public class LinkedList {
    //represent nod ein the single link list
     class Node {
        int data;
        Node next;
        Node prev;


       public Node(int data) {
        this.data = data;
        this.next = null;


        }
    }
     // represent head and tail of single link list
     public Node head = null;
     public Node tail = null;

     //add node at start

    public void addAtStart(int data){
        Node newNode = new Node(data);

        //check if this list is empty

        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            newNode.next = head;
            head = newNode;
        }
    }
    public void addAtEnd(int data){
        Node newNode = new Node(data);
        if (head==null){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
    }
    public void insertAfter(int position, int data) {
        Node newNode = new Node(data);
        if(position == 1){
            addAtStart(data);
        }

        else{
            Node temp = head;
            int count = 1;
            while (count < position-1){
                temp = temp.next;
                count++;
            }
            if(temp.next == null)
                addAtEnd(data);
            else{
                newNode.next = temp.next;
                temp.next = newNode;
            }
        }
    }
    public void deleteAtStart(){
        if(head==null)
            System.out.println("List is empty");
        else{
            if(head!=tail)
                head = head.next;
            else
                head=tail=null;
        }
    }
    public void deleteAtEnd(){
        if (head==null)
            System.out.println("List is empty");

        else{
            if(head!=tail){
               Node temp = head;
               while(temp.next!=tail){
                   temp=temp.next;
               }
               tail = temp;
               tail.next = null;

            }
            else{
                head=tail=null;
            }
        }
    }
    public void deleteAfter(int position){
        if(position == 1){
            deleteAtStart();
        }
        else{
            Node temp = head;
            int count = 1;
            while(count <position-1){
                temp=temp.next;
                count ++;
            }
            if (temp.next== null)
                deleteAtEnd();
            else
             temp.next = temp.next.next;
        }
    }
    public void display(){
          Node current = head;
          if(head == null){
              System.out.println("List is empty");
              return;
          }
          while (current!=null){
              System.out.println(current.data+ " ");
              current = current.next;
          }
        System.out.println();
    }
    public static void main(String[] args){
        LinkedList linkedList = new LinkedList();
        linkedList.addAtStart(10);
        linkedList.addAtStart(20);
        linkedList.addAtStart(30);
        linkedList.addAtStart(40);
        linkedList.addAtEnd(50);
        linkedList.insertAfter(6,80);
        linkedList.deleteAfter(6);

        System.out.println("Linked List is: " );
        linkedList.display();

    }
}
