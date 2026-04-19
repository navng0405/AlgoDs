package Tree;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) { this.val = val; }
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        height(root, result);
        return result;
    }

    private int height(TreeNode node, List<List<Integer>> result) {
        if (node == null) return -1; // Base case
        int leftHeight = height(node.left, result);
        int rightHeight = height(node.right, result);
        int currHeight = Math.max(leftHeight, rightHeight) + 1;

        // Ensure the sublist exists for the current height
        while (result.size() <= currHeight) {
            result.add(new ArrayList<>());
        }
        result.get(currHeight).add(node.val);

        return currHeight;
    }

    // Example usage
    public static void main(String[] args) {
        // Construct the tree: [1,2,3,4,5]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        Solution solution = new Solution();
        List<List<Integer>> leaves = solution.findLeaves(root);
        System.out.println(leaves); // Expected: [[4, 5, 3], [2], [1]]
    }
}

