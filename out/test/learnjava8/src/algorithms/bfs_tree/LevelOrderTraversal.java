package algorithms.bfs_tree;

import java.util.*;

/**
 * Given a binary tree, populate an array to represent its level-by-level traversal. You should populate the
 * values of all nodes of each level from left to right in separate sub-arrays.
 * https://www.educative.io/courses/grokking-the-coding-interview/xV7E64m4lnz
 */
public class LevelOrderTraversal {

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
        System.out.println(getLevelByLevelTraversal(root));
    }

    private static List<List<Integer>> getLevelByLevelTraversal( TreeNode root ) {
        List<List<Integer>> nodeLevels = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while( !queue.isEmpty() ) {
            List<Integer> currentLevel = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.nodeValue);
                if(currentNode.leftNode!=null){
                    queue.offer(currentNode.leftNode);
                }
                if(currentNode.rightNode!=null){
                    queue.offer(currentNode.rightNode);
                }
            }
            nodeLevels.add(currentLevel);
        }
        return nodeLevels;
    }
}
