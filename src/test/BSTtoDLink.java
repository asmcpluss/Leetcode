package test;

public class BSTtoDLink {
	public static void main(String args[]){
		TreeNode root = new TreeNode(5);
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		root.left = n2;
		root.right = n7;
		n2.left = n1;
		n2.right = n4;
		n4.left = n3;
		n7.left = n6;
		n7.right = n8;
		TreeNode phead = Convert(root);
		while(phead!=null){
			System.out.print(phead.val+" ");
			phead = phead.right;
		}
		StringBuilder sb = new StringBuilder("adfg");
		System.out.println(sb.deleteCharAt(1));
	}
	/**
	 * convert Binary Search Tree to double linkedlist
	 * @param pRootOfTree
	 * @return
	 */
	public static TreeNode Convert(TreeNode pRootOfTree) {
        TreeNode[] result = convert(pRootOfTree);
        return result[0];
    }
    public static TreeNode[] convert(TreeNode pRoot){
        TreeNode[] endpoints= new TreeNode[2];
        endpoints[0] = pRoot;
        endpoints[1] = pRoot;
        if(pRoot==null){
        	return endpoints;
        }
        if(pRoot.left==null&&pRoot.right==null){
            return endpoints;
        }
        TreeNode[] leftTree = convert(pRoot.left);
        TreeNode[] rightTree = convert(pRoot.right);
        if(leftTree[1]!=null){
            leftTree[1].right = pRoot;
            pRoot.left = leftTree[1];
        }
        if(rightTree[0]!=null){
            pRoot.right = rightTree[0];
            rightTree[0].left = pRoot;
        }
        if(rightTree[1]!=null){
            rightTree[1].right = null;
        }
        if(leftTree[0]!=null){
        	endpoints[0] = leftTree[0];
        }
        if(rightTree[1]!=null){
        	endpoints[1] = rightTree[1];
        }
        return endpoints;
    }
}