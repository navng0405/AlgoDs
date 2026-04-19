package Tree;

import java.util.*;

public class BinaryTree {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        printPreOrderTraval(root);
        System.out.println();
        printPreOrderTravalStack(root);
        System.out.println();
        System.out.println("InOrder : ");
        printInOrderTraval(root);
        System.out.println();
        System.out.print("PostOrder : " );
        printPostOrderTraval(root);
        System.out.println();
        System.out.print("Level Order Travasal: ");
        printLevelOrderTravasalOrder(root);
        List<List<Integer>> verticalTraversal = verticalTraversal(root);
        System.out.println();
        System.out.print("Vertical Order");;
        for(List<Integer> val : verticalTraversal){
            System.out.print(Arrays.toString(val.toArray()) + " ");
        }

    }

    private static void printInOrderTraval(TreeNode root) {
        if(root == null){
            return;
        }
        printInOrderTraval(root.left);
        System.out.print(root.data + " ");
        printInOrderTraval(root.right);
    }

    private static void printPostOrderTraval(TreeNode root){
        if(root == null){
            return;
        }
        printPostOrderTraval(root.left);
        printPostOrderTraval(root.right);
        System.out.print(root.data + " ");
    }

    public static void printPreOrderTraval(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        printPreOrderTraval(root.left);
        printPreOrderTraval(root.right);
    }

    public static void printPreOrderTravalStack(TreeNode treeNode){
        if(treeNode == null){
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        while(!stack.isEmpty()){
            TreeNode currentNode = stack.pop();
            System.out.print(currentNode.data + " ");
            if(currentNode.right!= null){
                stack.push(currentNode.right);
            }
            if(currentNode.left!=null){
                stack.push(currentNode.left);
            }
        }
    }

    public static void printLevelOrderTravasalOrder(TreeNode root){
        if(root == null){
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode currentNode = queue.poll();
            System.out.print(currentNode.data + " ");
            if(currentNode.left != null){
                queue.add(currentNode.left);
            }
            if(currentNode.right != null){
                queue.add(currentNode.right);
            }
        }
    }


    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        dfs(root, 0, 0, map);
        List<List<Integer>> list = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            list.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
    }

    private static void dfs(TreeNode node, int x, int y, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        if (node == null) return;
        map.putIfAbsent(x, new TreeMap<>());
        map.get(x).putIfAbsent(y, new PriorityQueue<>());
        map.get(x).get(y).offer(node.data);

        dfs(node.left, x - 1, y + 1, map);
        dfs(node.right, x + 1, y + 1, map);
    }
}
