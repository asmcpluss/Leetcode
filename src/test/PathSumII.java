package test;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(10);
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(-3);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(2);
		TreeNode n5 = new TreeNode(11);
		TreeNode n6 = new TreeNode(3);
		TreeNode n7 = new TreeNode(-2);
		TreeNode n8 = new TreeNode(1);
		root.right = n2;
		root.left = n1;
		n1.left = n3;
		n1.right = n4;
		n2.left = null;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n4.left = null;
		n4.right = n8;
		n5.left = null;
		n5.right = null;
		n6.left = n6.right = null;
		n7.left = n7.right = null;
		n8.left = n8.right = null;
		System.out.println(pathSum2(root,8));
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
	
	/**
	 * Find the number of paths that sum to a given value.
	 * The path does not need to start or end at the root or a leaf, 
	 * but it must go downwards (traveling only from parent nodes to child nodes).
	 * @param root
	 * @param sum
	 * @return
	 */
	public static int pathSum2(TreeNode root, int sum) {
        int result = 0;
        if(root==null){
        	return 0;
        }
        result = hasPath(root,sum)+pathSum2(root.left,sum)+pathSum2(root.right,sum);
        return result;
    }
	public static int hasPath(TreeNode root,int sum){
		if(root==null){
            return 0;
        }
        if(root.val==sum){
            return 1+hasPath(root.left,0)+hasPath(root.right,0);
        }
        return hasPath(root.left,sum-root.val)+hasPath(root.right,sum-root.val);
	}
}
