package LinkedListProbs;

public class SinglyLinkedList {
    static Node head;
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    void printList(Node head){
        Node currentNode = head;
        while(currentNode != null){
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
    }

    Node reverseList(Node head){
        Node currentNode = head;
        Node previousNode = null;
        Node next = null;
        while(currentNode != null){
            next = currentNode.next;
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = next;
        }

        return previousNode;

    }

    Node mergeSorted(Node x,Node y){
        if(x == null){
            return y;
        }
        if(y == null){
            return x;
        }

        if(x.data<y.data){
            x.next = mergeSorted(x.next,y);
            return x;
        }else{
            y.next = mergeSorted(x,y.next);
            return y;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        singlyLinkedList.head = new Node(10);
        singlyLinkedList.head.next = new Node(20);
        singlyLinkedList.head.next.next = new Node(30);
        singlyLinkedList.head.next.next.next = new Node(40);
        System.out.println("old Linked list");
        singlyLinkedList.printList(head);
        System.out.println();

        Node node = new Node(-1);
        node = new Node(50);
        node.next = new Node(60);
        node.next.next = new Node(70);
        node.next.next.next = new Node(80);
        System.out.println("old Linked list");
        singlyLinkedList.printList(node);
        System.out.println();



        System.out.println("Merge");
        Node mergeSort = singlyLinkedList.iterativeMerge(head,node);
        singlyLinkedList.printList(mergeSort);
        System.out.println();


        System.out.println("Reversed Linked list");
        Node reverseNode = singlyLinkedList.reverseList(head);
        singlyLinkedList.printList(reverseNode);
        System.out.println();

        System.out.println("Remove nth node");
        Node removedNthNode = singlyLinkedList.removeNthFromEnd(reverseNode,3);
        singlyLinkedList.printList(removedNthNode);

        System.out.println("ReOrder");
        singlyLinkedList.reorderList(removedNthNode);
        singlyLinkedList.printList(removedNthNode);


    }

    private Node iterativeMerge(Node x, Node y) {
        Node head = new Node(-1);
        Node tail = head;
        while(x!=null & y!=null){
            if(x.data<y.data){
                tail.next = x;
                x = x.next;
            }else{
                tail.next = y;
                y=y.next;
            }
            tail = tail.next;
        }

        if(x!=null){
            tail.next = x;
        }
        if(y!=null){
            tail.next = y;
        }
        return head.next;
    }

    private Node removeNthFromEnd(Node node,int n){
        Node dummy = new Node(0);
        dummy.next = node;
        Node fastMover = dummy;
        Node slowMover = dummy;
        for(int i=0;i<=n;i++){
            fastMover = fastMover.next;
        }
        while(fastMover != null){
            fastMover = fastMover.next;
            slowMover = slowMover.next;
        }

        slowMover.next = slowMover.next.next;

        return dummy.next;
    }

    public void reorderList(Node head) {
        if (head == null || head.next == null) return;

        // Step 1: Find the middle of the linked list
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half
        Node prev = null, curr = slow, tmp;
        while (curr != null) {
            tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }

        // Step 3: Merge two halves
        Node first = head, second = prev;
        while (second.next != null) {
            tmp = first.next;
            first.next = second;
            first = tmp;

            tmp = second.next;
            second.next = first;
            second = tmp;
        }
    }


    public void reorderList1(Node head) {
        if (head == null || head.next == null) {
            return;
        }

        Node slowPtr = head, fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        Node prev = null;
        Node currentNode = slowPtr, tmp;
        ;
        while (currentNode != null) {
            tmp = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = tmp;
        }

        Node first = head, second = prev;
        while (second != null) {
            tmp = first.next;
            first.next = second;
            first = tmp;

            tmp = second.next;
            second.next = first;
            second = tmp;
        }
    }

}
