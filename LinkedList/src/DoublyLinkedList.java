public class DoublyLinkedList {

     class Node {
         int data;
         Node next;
         Node prev;


         public Node(int data) {
             this.data = data;
             this.next = null;
             this.prev = null;

         }
     }

    public Node head = null;
     public Node tail = null;

     public void addAtStart(int data){
         Node newNode = new Node(data);
         if(head == null){
             head = newNode;
             tail = newNode;
         }
         else{
             Node temp = head;
             newNode.next = temp;
             temp.prev = newNode;
             head = newNode;
         }
     }

     public void addAtEnd(int data){
         Node newNode = new Node(data);
         if(head == null){
             head = newNode;
             tail = newNode;
         }
         else{
             newNode.prev = tail;
             tail.next = newNode;
             newNode.next = null;
             tail = newNode;
         }
     }
     public void addAtPosition(int data, int position){
         Node newNode = new Node(data);
         if(position == 1){
             addAtStart(data);
         }
         else{
             Node current = head;
             int count =1;
             while (count < position-1){
                 current = current.next;
                 count++;
            }
             if(current.next==null)
                 addAtEnd(data);
         else{
         newNode.next = current.next;
         current.next.prev =newNode;
         current.next = newNode;
         newNode.prev = current;

             }
         }
     }

     public void deleteAtStart(){
         if(head == null)
             System.out.println("List is empty");

         if(head!=tail){
             head = head.next;
             head.prev =null;
         }
         else
             head=tail=null;
     }
     public void deleteAtEnd(){
         if(head == null)
             System.out.println("List is Empty");

         else{
             if(head!=tail) {
                 tail.prev.next = null;
                 tail = tail.prev;
             }
             else
                 head=tail=null;
         }

     }
     public void deleteAtPosition(int position){
         if(position == 1)
             deleteAtStart();
         else {
             Node current = head;

             int count = 1;
             while (count< position-1){
                 current = current.next;
                 count++;
             }
             if(current.next == null)
                 deleteAtEnd();
             else{
                 current.next = current.next.next;
                 current.next.prev = current;
             }

         }


     }

     public void display(){
         Node current = head;
         int count =0;
         if(head == null){
             System.out.println("List is Empty");
             return;
         }
         else{
             while (current!= null){
                 System.out.println("Data"+" "+current.data+ " ");
                 System.out.println("Previous"+" "+current.prev+" ");
                 System.out.println("Next"+" "+current.next);
                 current = current.next;
                 count ++;

             }
         }
         System.out.println();
         System.out.println("Length of link list is "+" "+count);


     }


     public static void main(String[]args){
         DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
         doublyLinkedList.addAtStart(30);
         doublyLinkedList.addAtStart(20);
         doublyLinkedList.addAtEnd(40);
//        doublyLinkedList.addAtEnd(50);
       doublyLinkedList.addAtPosition(35,2);
//         doublyLinkedList.addAtPosition(10,1);
//         doublyLinkedList.addAtPosition(55,7);
//         doublyLinkedList.deleteAtPosition(4);
         System.out.println("Linked List");
         doublyLinkedList.display();
         System.out.println();
         System.out.println("Head"+" "+ doublyLinkedList.head.data);
         System.out.println("Tail"+" "+ doublyLinkedList.tail.data);

     }


}
