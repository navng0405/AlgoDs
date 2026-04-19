package problems.Tree;
/**
 *
 */

import java.util.Map;
import java.util.TreeMap;

public class ViewTree {
    static class Node
    {
        int data;
        Node left, right;
        Node(int key)
        {
            data = key;
            left = right = null;
        }
    }

    /**
     *                                      1
     *                                2              3
     *                         4         5                 6
     *                    7                                      8
     *
     *
     *  7 -> H 3,HD -3
     *  4 -> H 2,HD -2
     *  2 -> H 1,HD -1
     *  5 -> H 2,HD -2
     *  1 -> H 0,HD  0
     *  3 -> H 1.HD  1
     *  6 -> H 2,HD  2
     *  8 -> H 3,HD  3
     *
     *  -3 --> 7
     *
     *
     *
     *
     *
     *
     *                    7,4,2,1,3,6,8
     * @param args
     */
    public static void main (String[] args)
    {
        /*create the Binary Tree*/
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.left.left.left = new Node(7);
        root.right.right.right = new Node(8);
        topView(root);
        bottomView(root);
    }

    static class Pair{
        int data;
        int height;
        Pair(int data,int height){
            this.data = data;
            this.height = height;
        }
    }

    private static void topView(Node root){
        Map<Integer,Pair> map = new TreeMap<>();
        inOrderTravasal(root,map,0,0);
        System.out.print("Top View :");
        for(Map.Entry<Integer,Pair> entry : map.entrySet()){
            System.out.print( entry.getValue().data + " ");
        }
    }

    private static void inOrderTravasal(Node root,Map<Integer,Pair> map,int HD,int height){
        if(root == null){
            return;
        }
        inOrderTravasal(root.left,map,HD-1,height+1);
        if(map.containsKey(HD)){
            if(map.get(HD).height>height){
                map.put(HD,new Pair(root.data, height));
            }
        }else{
            map.put(HD,new Pair(root.data, height));
        }
        inOrderTravasal(root.right,map,HD+1,height+1);
    }

    private static void bottomView(Node root){
        Map<Integer,Pair> map = new TreeMap<>();
        inOrderTraBtm(root,map,0,0);
        System.out.println("Bottom View :");
        for(Map.Entry<Integer,Pair> entry : map.entrySet()){
            System.out.print(entry.getValue().data + " ");
        }

    }

    private static void inOrderTraBtm(Node root,Map<Integer,Pair> map,int width,int height){
        if(root == null){
            return;
        }
        inOrderTravasal(root.left,map,width-1,height+1);
        if(map.containsKey(width)){
            if(map.get(width).height<height){
                map.put(width,new Pair(root.data, height));
            }
        }else{
            map.put(width,new Pair(root.data, height));
        }
        inOrderTravasal(root.right,map,width+1,height+1);
    }
}
