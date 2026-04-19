package Tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TreeViews {
    static class Pair{
        TreeNode node;
        int HD;
        Pair(TreeNode node,int HD){
            this.node = node;
            this.HD = HD;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(2);
        treeNode.left.left = new TreeNode(1);
        treeNode.left.right = new TreeNode(6);
        treeNode.right = new TreeNode(4);
        treeNode.right.right = new TreeNode(5);
        printTopView(treeNode);
        printBottomView(treeNode);
        System.out.println();
        System.out.print("Left View : ");
        printLeftView(treeNode);
        System.out.println();
        System.out.print("Right View :" );
        printRightView(treeNode);
    }

    private static void printRightView(TreeNode treeNode) {
        if(treeNode == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        while (!queue.isEmpty()){
            int queueSize = queue.size();
            for(int i=1;i<=queueSize;i++){
                TreeNode temp = queue.poll();
                if(i == queueSize){
                    System.out.print(temp.data + " ");
                    if(temp.left != null){
                        queue.add(temp.left);
                    }
                    if(temp.right != null){
                        queue.add(temp.right);
                    }
                }
            }
        }
    }

    private static void printLeftView(TreeNode treeNode) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(treeNode != null){
            queue.add(treeNode);
        }
        while(!queue.isEmpty()){
            int queueSize = queue.size();
            for(int i=1;i<=queueSize;i++){
                TreeNode temp = queue.poll();
                if(i ==1){
                    System.out.print(temp.data + " ");
                    if(temp.left != null){
                        queue.add(temp.left);
                    }
                    if(temp.right != null){
                        queue.add(temp.right);
                    }
                }
            }
        }

    }

    private static void printBottomView(TreeNode treeNode) {
        Map<Integer,TreeNode> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        if(treeNode != null){
            queue.add(new Pair(treeNode,0));
        }

        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            map.put(pair.HD,pair.node);
            if(pair.node.left != null){
                queue.add(new Pair(pair.node.left,pair.HD-1));
            }
            if(pair.node.right != null){
                queue.add(new Pair(pair.node.right, pair.HD+1));
            }
        }
        System.out.println();
        System.out.println("Bottom View:");
        for(TreeNode node : map.values()){
            System.out.print(node.data + " ");
        }
    }

    private static void printTopView(TreeNode treeNode) {
        Map<Integer,TreeNode> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();
        if(treeNode != null){
            queue.add(new Pair(treeNode,0));
        }
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            if(!map.containsKey(pair.HD)){
                map.put(pair.HD, pair.node);
            }
            if(pair.node.left != null){
                queue.add(new Pair(pair.node.left,pair.HD-1));
            }
            if(pair.node.right != null){
                queue.add(new Pair(pair.node.right,pair.HD+1));
            }

        }

        for(TreeNode node : map.values()){
            System.out.print(node.data + " ");
        }
    }
}
