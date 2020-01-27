/*
 * BOJ1967
 * 2020.01.27
 * Hyeonseong
 */
import java.util.*;
public class BOJ1967
{
	public static void main(String[] args) 
	{
		Solution s = new Solution();
	}
}
class TreeNode{
	TreeNode parent;
	int data;
	int len; // 부모노드와의 거리
	ArrayList<TreeNode> child = new ArrayList<TreeNode>();
	TreeNode(int data){
		this.data = data;
	}
	TreeNode(int data, int len,TreeNode parent){
		this.data = data;
		this.len = len;
		this.parent = parent;
	}
}
class Tree{
	TreeNode root;
	int max = Integer.MIN_VALUE;
	int maxidx;
	boolean visit[];
	Tree(int data, int child, int len){
		root = new TreeNode(data);
		root.child.add(new TreeNode(child,len,root));
	}
	public void add(int data, int child, int len) {
		if(root.data == data) {
			root.child.add(new TreeNode(child,len,root));
		}
		else {
			for(int i=0;i<root.child.size();i++) {
				find(root.child.get(i),data,child,len);
			}
		}
	}
	public void find(TreeNode node, int data, int child,int len) {
		if(node==null)
			return;
		if(node.data == data) {
			node.child.add(new TreeNode(child,len,node));
		} else {
			for(int i=0;i<node.child.size();i++) {
				find(node.child.get(i),data,child,len);
			}
		}
	}
	public void dfs(TreeNode node, int distance) {
		if(node.child.size()==0) {
			if(max < distance) {
				max = distance;
				maxidx = node.data;
			}
		}
		for(int i=0;i<node.child.size();i++) {
			dfs(node.child.get(i),distance+node.child.get(i).len);
		}
	}
	public void reverseDfs(TreeNode node, int data,int n) {
		if(node==null)
			return;
		if(node.data == data) {
			max = 0; maxidx = 0;
			visit = new boolean[n+1];
			dfsFind(node,0);
		} else {
			for(int i=0;i<node.child.size();i++) {
				reverseDfs(node.child.get(i),data,n);
			}
		}
	}
	public void dfsFind(TreeNode node, int distance) {
		visit[node.data] = true;
		if(node.parent!=null && !visit[node.parent.data]) {
			dfsFind(node.parent, distance+node.len);
		}
		if(max < distance) {
			max = distance;
			maxidx = node.data;
		}
		for(int i=0;i<node.child.size();i++) {
			if(!visit[node.child.get(i).data]) {
				dfsFind(node.child.get(i),distance+node.child.get(i).len);
			}
		}
	}
}
class Solution{
	Tree t;
	int n;
	int input[];
	public Solution() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		input = new int[3];
		for(int i=0;i<3;i++) {
			input[i] = scan.nextInt();
		}
		t = new Tree(input[0],input[1],input[2]);
		for(int i=0;i<n-2;i++) {
			for(int j=0;j<3;j++) {
				input[j] = scan.nextInt();
			}
			t.add(input[0], input[1], input[2]);
		}
		t.dfs(t.root, t.root.len);
		t.reverseDfs(t.root, t.maxidx,n);
		System.out.println(t.max);
	}

}