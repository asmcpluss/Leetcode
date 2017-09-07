package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RetreiveBT {
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root==null){
            return result;
        }
        queue.add(root);
        while(queue.peek()!=null){
            TreeNode node = queue.poll();
            result.add(node.val);
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
        return result;
    }
    public static void main(String args[]){
    	TreeNode root = new TreeNode(1);
    	TreeNode node1 = new TreeNode(2);
    	TreeNode node2 = new TreeNode(5);
    	TreeNode node3 = new TreeNode(4);
    	TreeNode node4 = new TreeNode(7);
    	root.left = node1;
    	root.right = node4;
    	node1.left = node2;
    	node2.right = node3;
    	System.out.println(PrintFromTopToBottom(root));
    }
}
