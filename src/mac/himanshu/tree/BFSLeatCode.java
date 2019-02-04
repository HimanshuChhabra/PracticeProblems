package mac.himanshu.tree;

import java.util.*;

public class BFSLeatCode {

	public static void main(String[] args) {
//		TreeNode root = new TreeNode(3);
//		TreeNode l11 = new TreeNode(9);
//		TreeNode l12 = new TreeNode(2);
//		root.left = l11;
//		root.right = l12;
//		TreeNode l21 = new TreeNode(15);
//		TreeNode l22 = new TreeNode(7);
//		l12.left = l21;
//		l12.right = l22;

		//System.out.println(levelOrder(root));
		
		
		TreeNode root = new TreeNode(1);
		TreeNode l11 = new TreeNode(2);
		TreeNode l12 = new TreeNode(2);
		root.left = l11;
		root.right = l12;
		TreeNode l21 = new TreeNode(3);
		TreeNode l22 = new TreeNode(4);
		l11.left = l21;
		l11.right = l22;
		TreeNode l23 = new TreeNode(4);
		TreeNode l24 = new TreeNode(3);
		l12.left = l23;
		l12.right = l24;
		
		BFSLeatCode b = new BFSLeatCode();
		System.out.println(b.isSymmetric(root));
		

	}

	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> parentList = new ArrayList<List<Integer>>();
		List<TreeNode> nodelist = null;
		if (root != null) {
			List<Integer> list = Arrays.asList(root.value);
			nodelist = Arrays.asList(root);
			parentList.add(list);
		}

		while (root != null && !nodelist.isEmpty()) {

			List<Integer> childrenList = new ArrayList<Integer>();
			List<TreeNode> childNodeList = new ArrayList<TreeNode>();
			
			for (TreeNode node : nodelist) {
				if (node.left != null) {
					childrenList.add(node.left.value);
					childNodeList.add(node.left);
				}
				if (node.right != null) {
					childrenList.add(node.right.value);
					childNodeList.add(node.right);
				}
			}
			if (!childrenList.isEmpty()) {
				parentList.add(childrenList);
			}
			nodelist = childNodeList;

		}

		return parentList;
	}
	

	List<Integer> preList = new ArrayList<Integer>();
	List<Integer> postList = new ArrayList<Integer>();

	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;

		List<Integer> preList = getPreOrderList(root.left);
		List<Integer> postList = getPostOrderList(root.right);

		if (preList.size() != postList.size()) {
			return false;
		}
		int size = preList.size() - 1;

		for (int i = 0; i < preList.size(); i++) {

			if (preList.get(i) == null && postList.get(size - i) == null)
				continue;
			
			if(preList.get(i) == null)
				return false;
			
			if(postList.get(size - i) == null)
				return false;
			
//		
			if (preList.get(i)!= postList.get(size - i)) {
				return false;
			}
		}
		return true;
	}

	List<Integer> getPreOrderList(TreeNode root) {
		if (root == null) {
			preList.add(null);
			return preList;
		}

		preList.add(root.value);
		getPreOrderList(root.left);
		getPreOrderList(root.right);

		return preList;
	}

	List<Integer> getPostOrderList(TreeNode root) {
		if (root == null) {
			postList.add(null);
			return postList;
		}

		getPostOrderList(root.left);
		getPostOrderList(root.right);
		postList.add(root.value);

		return postList;
	}
}
// 	Symmetric

/*
public boolean isSymmetric(TreeNode root) {
    return isMirror(root, root);
}

public boolean isMirror(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) return true;
    if (t1 == null || t2 == null) return false;
    return (t1.val == t2.val)
        && isMirror(t1.right, t2.left)
        && isMirror(t1.left, t2.right);
} 

iterative solution
public boolean isSymmetric(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    q.add(root);
    while (!q.isEmpty()) {
        TreeNode t1 = q.poll();
        TreeNode t2 = q.poll();
        if (t1 == null && t2 == null) continue;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        q.add(t1.left);
        q.add(t2.right);
        q.add(t1.right);
        q.add(t2.left);
    }
    return true;
}


// find path of a sum
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }

class Solution {
    private boolean result = false;
    private int totalSum = 0;
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null){
            return false;
            
        }else if(root.left == null && root.right == null){
            totalSum+=root.val;
            if(totalSum == sum)
               return true;
            else{
                return false;
            }
        }
        else{
                    totalSum+=root.val;
        }    
        
        result = hasPathSum(root.left,sum);
        if(!result){
            if(root.left != null)
            totalSum-=root.left.val;
            
            result = hasPathSum(root.right,sum);
            if(!result){
                   if(root.right != null)
                 totalSum-=root.right.val;
            }
        }
    return result;
    }
}
 */

