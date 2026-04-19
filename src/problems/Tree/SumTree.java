package problems.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class SumTree {
    static class Node
    {
        int data;
        Node left, right, next;
        Node(int key)
        {
            data = key;
            left = right = next = null;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(-3);
        root.right = new Node(4);
        root.left.left = new Node(9);
        root.left.right = new Node(-4);
        root.right.right = new Node(5);
        root.right.left = new Node(6);
        System.out.println(sumTree(root));
        printBST(root);

    }

    private static void printBST(Node root){
        if(root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while (size>0){
                Node temp = queue.poll();
                System.out.print(temp.data + " ");
                if(temp.left != null){
                    queue.add(temp.left);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                }
                size--;
            }
            System.out.println();
        }
    }

    private static int sumTree(Node root){
        if(root == null){
            return 0;
        }
        int oldData = root.data;
        int leftSum = sumTree(root.left);
        int rightSum = sumTree(root.right);
        root.data = leftSum+rightSum;
        return root.data+oldData;
    }
}
