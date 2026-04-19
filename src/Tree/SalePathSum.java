package Tree;

public class SalePathSum {
    static class Node{
        int cost;
        Node[] children;
        Node parent;

        Node(int cost){
            this.cost = cost;
            children = null;
            parent = null;
        }
    }
    public static void main(String[] args) {
        Node root = new Node(0);
        root.children = new Node[3];
        root.children[0] = new Node(5);
        root.children[1] = new Node(3);
        root.children[2] = new Node(6);
        root.children[0].children = new Node[1];
        root.children[0].children[0] = new Node(4);
        root.children[1].children = new Node[2];
        root.children[1].children[0] = new Node(2);
        root.children[1].children[1] = new Node(1);
        root.children[1].children[0].children = new Node[1];
        root.children[1].children[0].children[0]= new Node(1);

        System.out.println(getMinCost(root));
    }

    private static int getMinCost(Node root){
        if(root.children == null){
            return root.cost;
        }
        int minCost = Integer.MAX_VALUE;
        for(Node node : root.children){
            int currentCost = getMinCost(node);
            minCost = Math.min(minCost,currentCost);
        }
        return minCost+ root.cost;
    }
}
