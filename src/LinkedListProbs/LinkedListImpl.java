package LinkedListProbs;


import java.io.StringReader;
import java.net.InetAddress;
import java.util.HashSet;
import java.util.Set;

public class LinkedListImpl {
    static Node head;
    public Node append(int value){
        if(head == null){
            head = new Node(value);
            return head;
        }
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = new Node(value);
        return current;
    }

    public Node deleteNode(int value){
        if(head == null){
            return null;
        }
        if(head.data == value){
            head = head.next;
            return head;
        }
        Node current = head;
        while(current.next!=null){
            if(current.next.data == value){
                current.next = current.next.next;
                return head;
            }
            current = current.next;
        }
        return head;
    }

    public Node reverse(Node head){
        Node current = head;
        Node previous = null;
        while(current!=null){
            Node next = current.next;
            current.next = previous;
            previous = current;
            current=next;
        }


        return previous;
    }

    public Node mergeSortList(Node head1,Node head2){
        Node result = new Node(0);
        Node dummy = result;
        if(head1 ==null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        while(head1 != null && head2 != null){
            if(head1.data < head2.data){
                dummy.next = head1;
                head1 = head1.next;
                dummy = dummy.next;
            }else if(head1.data > head2.data){
                dummy.next = head2;
                head2 = head2.next;
                dummy = dummy.next;
            }else if(head1.data == head2.data){
                dummy.next = head1;
                head1 = head1.next;
                dummy = dummy.next;
            }
        }
        if(head1 != null){
            dummy.next = head1;
        }
        if(head2 != null){
            dummy.next = head2;
        }
        return result.next;
    }

    public Node removeNthNodeFromEnd(Node node,int n){
        Node dummy = new Node(-1);
        dummy.next = node;
        Node fastPtr = dummy;
        Node slowPtr = dummy;
        //Need to go one step ahead of n
        for(int i=0;i<=n;i++){
            fastPtr = fastPtr.next;
        }
        while(fastPtr!=null){
            fastPtr = fastPtr.next;
            slowPtr = slowPtr.next;
        }
        slowPtr.next = slowPtr.next.next;
        return dummy.next;
    }

    //Fine middle node by moving fastPtr = fastPtr.next.next ,slowPtr = slowPtr.next until fastPtr.next != null and fastPtr = null
    //Reverse second halves
    //merge 2 heads
    // 1->2->3->4>-5->null
    //
    //1->5->2->4->3->null
    public Node reOrder(Node node){

        //
        Node fastPtr = node;
        Node slowPtr = node;
        Node prev = null;

        while(fastPtr != null && fastPtr.next != null){
            prev = slowPtr;
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        if(prev !=null){
            prev.next = null;
        }

        Node current = slowPtr;
        Node previvous = null;
        Node next ;
        while (current != null){
            next = current.next;
            current.next = previvous;
            previvous = current;
            current = next;
        }

        Node reorder = mergeSortList(node,previvous);




        return reorder;
    }

    public Node removeDuplicates(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node currentNode = head;
        while(currentNode != null && currentNode.next != null){
            if(currentNode.data == currentNode.next.data){
                currentNode.next = currentNode.next.next;
            }else{
                currentNode = currentNode.next;
            }
        }
        return head;
    }

    public Node rotateRight(Node head,int k){
        if(head == null && head.next ==null){
            return head;
        }

        Node lastNode = head;
        int length;
        for(length=1;lastNode.next != null ;length++){
            lastNode = lastNode.next;
        }

        lastNode.next = head;

        //length - k%length -1

        for(int i=0;i<length-k%length-1;i++){
            head = head.next;
        }

        Node newHead =head.next;
        head.next = null;

        return newHead;

    }

    /**
     * Problem Statement:
     *
     * Input: Two heads of singly linked lists headA and headB.
     * Output: The node at which the two lists intersect, or null if they do not intersect.
     * Approach:
     *
     * Two Pointer Technique: Use two pointers, pointerA starting at headA and pointerB starting at headB.
     * Traverse the Lists: Move pointerA and pointerB forward through the lists.
     * Switch Lists: When pointerA reaches the end of list A, continue from the beginning of list B, and vice versa for pointerB.
     * Intersection or End: If the lists intersect, pointerA and pointerB will meet at the intersection node. If not, they will both
     * reach the end (null) without meeting.
     * Reasoning:
     *
     * By traversing both lists and then switching, both pointers travel the same distance: the length of list A + the length of list B.
     * This neutralizes the difference in lengths.
     * If the lists intersect, the pointers will meet at the intersection point after traversing the non-common and common parts of the lists.
     * If there's no intersection, both pointers reach null simultaneously.
     * @param args
     */

    public Node getIntersection(Node headA,Node headB){
        if(headA == null || headB == null){
            return null;
        }

        Node pointerA = headA;
        Node pointerB = headB;
        while(pointerB != pointerA){
            pointerA = pointerA == null ? headB : pointerA.next;
            pointerB = pointerB == null ? headA : pointerB.next;
        }

        return pointerA;
    }

    /**
     * Flashcard Style Explanation
     * Problem Statement:
     *
     * Input: The head of a singly linked list.
     * Output: true if the list has a cycle, false otherwise.
     * Approach:
     *
     * Two Pointer Technique: Use two pointers, slow and fast, where slow moves one step at a time and fast moves two steps at a time.
     * Cycle Detection: If there is a cycle, fast and slow will eventually meet at some node within the cycle. If fast reaches the end (null),
     * the list does not have a cycle.
     *
     * Reasoning:
     *
     * The fast pointer moves at double the speed of the slow pointer. If there's a cycle, it's guaranteed that fast will "lap" slow, leading them to meet.
     * If there's no cycle, fast will reach the end of the list.
     * @param args
     */

    public boolean hasCycle(Node head){
        if(head == null || head.next == null){
            return false;
        }

        Node slowPtr = head;
        Node fastPtr = head;
        while(slowPtr != fastPtr){
            if(fastPtr == null || fastPtr.next == null){
                return false;
            }
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        return true;
    }

    /**
     * Problem Statement:
     *
     * Input: The head of a singly linked list.
     * Output: true if the list is a palindrome, false otherwise.
     * Approach:
     *
     * Find the Middle: Use the fast and slow pointer technique to find the middle of the list. Fast pointer moves two steps for every one step of the slow pointer.
     * Reverse the Second Half: Reverse the second half of the list.
     * Compare Halves: Compare the first half with the reversed second half. If every node matches, it's a palindrome.
     * Restore the List (Optional): Reverse the second half back to its original order and reattach to the first half if you need to retain the original list structure.
     * Reasoning:
     *
     * A palindrome list's second half is a mirror of its first half. By reversing the second half and comparing it to the first, we can check for palindromicity without needing extra space for a list/array copy.
     * The fast and slow pointer method efficiently finds the middle of the list, ensuring O(n) time complexity.
     * @param args
     */

    public boolean isPalindrome(Node head){
        if(head == null || head.next == null){
            return true;
        }

        //Find middle node
        Node slowPtr = head;
        Node fastPtr = head;
        while(fastPtr != null && fastPtr.next!= null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }

        //Reverse second halves
        Node prev = null;
        Node currentNode = slowPtr;
        while (currentNode != null){
            Node next = currentNode.next;
            currentNode.next = prev;
            prev =currentNode;
            currentNode = next;
        }

        Node left = head;
        Node right = prev;
        while(right!= null){
            if(left.data != right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    /**
     * Problem Statement:
     *
     * Input: Two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each node contains a single digit.
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     * Output: A linked list representing the sum of the two numbers.
     * Approach:
     *
     * Traverse Both Lists: Start with two pointers at the heads of the two lists. Add the values of nodes referred to by the pointers.
     * Carry Over: Keep track of the carry from each addition. If the sum of two digits plus the carry exceeds 9, set the carry for the next addition
     * and reduce the sum by 10.
     * Next Digits: Move to the next nodes in both lists. If one list is longer, continue with the longer list and the carry.
     * Handle Remaining Carry: If there's a carry left after the last addition, add a new node with the carry value.
     * Reasoning:
     *
     * Adding two numbers digit by digit from left to right (as the lists are in reverse order) simulates the manual addition process.
     * Handling the carry is crucial for correct results, especially for numbers of different lengths or resulting in an extra digit.
     * The problem effectively demonstrates manipulation of linked lists and basic arithmetic operations.
     * @param list1
     * @param list2
     * @return
     */
    public Node addNumbers(Node list1,Node list2){
        Node dummy = new Node(0);
        Node p = list1;
        Node q = list2;
        int carry = 0;
        Node curr = dummy;
        while(p != null || q!=null){
            int x = p != null ? p.data : 0;
            int y = q != null ? q.data : 0;
            int sum = carry + x + y;
            carry = sum/10;
            curr.next= new Node(sum%10);
            curr = curr.next;
            p = p!=null ? p.next : null;
            q = q!=null ? q.next : null;
        }
        if(carry>0){
            curr.next = new Node(carry);
        }

        return dummy.next;
    }

    /**
     * Approach:
     *
     * Iterate and Clone Nodes: Traverse the original list and for each original node, create a new node with the same value and insert it right after the
     * original node. This interleaves the original and copied nodes.
     * Copy Random Pointers: Iterate the list again. For each original node, set the random pointer of the copied node (which is the next node) to point to the
     * copied node of the original node's random (which is the next node of the original's random).
     * Separate the Lists: Iterate the list again, this time separating the interleaved list into the original list and the copied list.
     *
     * Reasoning:
     * By interleaving the copied nodes with their corresponding original nodes, we can easily set the correct random pointers without needing an extra map
     * to track the old-to-new node relationships.
     * Separating the interleaved list into two individual lists completes the deep copy process, ensuring that the original and copied lists are independent.
     * @param args
     */


    public Node copyClone(Node head){
        if(head == null){
            return null;
        }

        //Step 1:Clone nodes and interleave
        Node curr = head;
        while(curr != null){
            Node newNode = new Node(curr.data);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }

        //Step 2:Copy random pointers
        curr = head;
        while (curr != null){
            if(curr.random != null){
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        //Step 3:Separate the lists
        Node pseduoHead = new Node(0);
        Node copy;
        Node copyIter = pseduoHead;
        curr = head;
        while(curr != null){
            Node next = curr.next.next;

            //Extract copy
            copy = curr.next;
            copyIter.next = copy;
            copyIter = copy;

            curr.next = next;
            curr = curr.next;

        }

        return pseduoHead.next;
    }


    /**
     * Approach:
     *
     * Hash Set for Tracking: Use a hash set to track the values that have already appeared in the list. This allows for constant-time checks to determine
     * if a node is a duplicate.
     * Two Pointers: Use two pointers, prev and current. prev will always point to the last node that was determined to be unique, and current will traverse the
     * list to check for duplicates.
     * Traversal and Removal: As you traverse the list with current, check if its value is in the hash set:
     * If it is, it's a duplicate, and you should remove it by setting prev.next to current.next.
     * If it isn't, add the value to the hash set and move prev to current.
     * Reasoning:
     *
     * The hash set enables efficient tracking of which values have been seen, ensuring that each value is only allowed once in the modified list.
     * By using two pointers, you can efficiently remove duplicates in-place without needing to reallocate any nodes, only reassigning pointers as needed.
     * @param args
     */

    public Node removeDuplicateUnsorted(Node head){
        if(head == null){
            return head;
        }

        Node previous = null;
        Node current = head;
        Set<Integer> temp = new HashSet<>();
        while(current != null){
            if(!temp.contains(current.data)){
                temp.add(current.data);
                previous = current;
            }else{
                previous.next = current.next;
            }
            current = current.next;
        }
        return head;
    }
    public static void main(String[] args) {
        LinkedListImpl linkedList = new LinkedListImpl();
        Node head = linkedList.append(1);
        System.out.println(head.data);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.append(6);
        linkedList.printList(head);
        linkedList.deleteNode(5);
        System.out.println();
        linkedList.printList(head);
        System.out.println();
        linkedList.printList(head);
        System.out.println();
        Node anotherNode = new Node(2);
        anotherNode.next = new Node(5);
        anotherNode.next.next = new Node(8);
        linkedList.printList(anotherNode);
        System.out.println();
        Node mergeNode = linkedList.mergeSortList(head,anotherNode);
        linkedList.printList(mergeNode);
        linkedList.removeNthNodeFromEnd(mergeNode,2);
        System.out.println();
        linkedList.printList(mergeNode);
        System.out.println();
        Node reOrder = linkedList.reOrder(mergeNode);
        linkedList.printList(reOrder);

        Node removeDuplicate = linkedList.removeDuplicates(reOrder);
        System.out.println();
        linkedList.printList(removeDuplicate);

        Node rotate = linkedList.rotateRight(removeDuplicate,2);
        System.out.println();
        linkedList.printList(rotate);







    }

    private void printList(Node head) {
        if(head != null){
            Node currentNode = head;
            while(currentNode!= null){
                System.out.print(currentNode.data + " ");
                currentNode = currentNode.next;
            }
        }
    }

}
