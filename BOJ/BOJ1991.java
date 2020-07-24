/*
 * BOJ1991
 * 2020.01.27
 * Hyeonseong
 */
import java.util.*;	
public class BOJ1991 {
	public static void main(String[] args) {
		Solution s = new Solution();
	}
}
class TreeNode{
	char data;
	TreeNode left;
	TreeNode right;
	TreeNode(char data){
		this.data = data;
	}
}
class Tree{
	TreeNode root;
	public Tree(char data, char left, char right) {
		root = new TreeNode(data);
		if(data!='.') {
			root = new TreeNode(data);
		}
		if(left!='.') {
			root.left = new TreeNode(left);
		}
		if(right!='.') {
			root.right = new TreeNode(right);
		}
	}
	public void add(char data, char left, char right) {
		next(root.left, data,left,right);
		next(root.right,data,left,right);
	}
	public void next(TreeNode node, char data, char left, char right) {
		if(node==null)
			return;
		if(node.data==data) {
			if(left!='.')
				node.left = new TreeNode(left);
			if(right!='.')
				node.right = new TreeNode(right);
		} else {
			next(node.left, data, left, right);
			next(node.right, data, left, right);
		}
	}
	public void preOrder(TreeNode t) {
		if(t==null)
			return;
		System.out.print(t.data);
		preOrder(t.left);
		preOrder(t.right);
	}
	public void inOrder(TreeNode t) {
		if(t==null)
			return;
		inOrder(t.left);
		System.out.print(t.data);
		inOrder(t.right);
	}
	public void postOrder(TreeNode t) {
		if(t==null)
			return;
		postOrder(t.left);
		postOrder(t.right);
		System.out.print(t.data);
	}
}
class Solution{
	Tree t;
	int n;
	char data[];
	public Solution() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt(); scan.nextLine();
		data = scan.nextLine().replaceAll(" ","").toCharArray();
		t = new Tree(data[0],data[1],data[2]);
		for(int i=1;i<n;i++) {
			data = scan.nextLine().replaceAll(" ","").toCharArray();
			t.add(data[0], data[1],data[2]);
		}
		t.preOrder(t.root);
		System.out.println();
		t.inOrder(t.root);
		System.out.println();
		t.postOrder(t.root);
	}
}