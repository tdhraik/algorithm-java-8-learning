package algorithms.bfs_tree;

/**
 * Breadth first search
 */
public class SimpleTreeTraversal {

    static class TreeNode {
        TreeNode leftNode;
        TreeNode rightNode;
        int nodeValue;

        TreeNode(int nodeValue) {
            this.nodeValue = nodeValue;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.leftNode = new TreeNode(2);
        root.rightNode = new TreeNode(3);
        root.leftNode.leftNode = new TreeNode(4);
        root.leftNode.rightNode = new TreeNode(5);
        root.rightNode.leftNode = new TreeNode(6);
        root.rightNode.rightNode = new TreeNode(7);
        root.leftNode.leftNode.leftNode = new TreeNode(8);
        root.leftNode.leftNode.rightNode = new TreeNode(9);
        displayTreeStructure(root);
    }

    private static void displayTreeStructure(TreeNode root) {
        System.out.print(root.nodeValue + "=>");
        if (root.leftNode != null) {
            displayTreeStructure(root.leftNode);
        }
        if (root.rightNode != null) {
            displayTreeStructure(root.rightNode);
        }
    }
}