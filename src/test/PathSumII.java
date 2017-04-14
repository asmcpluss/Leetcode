package test;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(5);
		TreeNode n1 = new TreeNode(4);
		TreeNode n2 = new TreeNode(8);
		TreeNode n3 = new TreeNode(11);
		TreeNode n4 = new TreeNode(13);
		TreeNode n5 = new TreeNode(4);
		TreeNode n6 = new TreeNode(7);
		TreeNode n7 = new TreeNode(2);
		TreeNode n8 = new TreeNode(5);
		TreeNode n9 = new TreeNode(1);
		root.right = n2;
		root.left = n1;
		n1.left = n3;
		n1.right = null;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n4.left = null;
		n4.right = null;
		n5.left = n8;
		n5.right = n9;
		n6.left = n6.right = null;
		n7.left = n7.right = null;
		n8.left = n8.right = null;
		n9.left = n9.right = null;
		System.out.println(pathSum(root,22));
	}

	/**
	 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
	 * @param root
	 * @param sum
	 * @return
	 */
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> paths = new ArrayList<List<Integer>>();
        if(root==null){
            return paths;
        }
        if(root.val==sum){
        	if(root.left==null&&root.right==null){
        		List<List<Integer>> result = new ArrayList<List<Integer>>();
                List<Integer> path = new ArrayList<Integer>();
                path.add(sum);
                result.add(path);
                return result;
        	}
        }
        List<List<Integer>> leftPath = pathSum(root.left,sum-root.val);
        List<List<Integer>> rightPath = pathSum(root.right,sum-root.val);
        if(leftPath!=null){
            for(int i=0;i<leftPath.size();i++){
                List<Integer> path = new ArrayList<Integer>();
                path.add(root.val);
                path.addAll(leftPath.get(i));
                paths.add(path);
            }
        }
        if(rightPath!=null){
            for(int i=0;i<rightPath.size();i++){
                List<Integer> path = new ArrayList<Integer>();
                path.add(root.val);
                path.addAll(rightPath.get(i));
                paths.add(path);
            }
        }
        return paths;
    }
}
