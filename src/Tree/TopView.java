package Tree;

import java.util.Map;
import java.util.TreeMap;

public class TopView {
    static class QueueObj{
        Integer node;
        Integer depth;
        QueueObj(Integer node,Integer depth){
            this.node = node;
            this.depth = depth;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        printTopView(root);

    }

    static void printTopView(TreeNode root){
        Map<Integer,QueueObj> map = new TreeMap<>();
        inOrderTravasal(root,0,0,map);
        System.out.print("Top View : ");
        for(QueueObj queueObj : map.values()){
            System.out.print(queueObj.node + " ");
        }
    }

    private static void inOrderTravasal(TreeNode root, int HD, int depth, Map<Integer, QueueObj> map) {
        if(root == null){
            return;
        }

        inOrderTravasal(root.left,HD-1,depth+1,map);
        if(map.containsKey(HD)){
            if(map.get(HD).depth > depth) {
                map.put(HD, new QueueObj(root.data, depth));
            }
        }else{
            map.put(HD,new QueueObj(root.data,depth));
        }
        inOrderTravasal(root.right,HD+1,depth+1,map);
    }
}
