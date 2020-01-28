/*
 * 2019 KAKAO 길 찾기 게임
 * 2020.01.28
 * Hyeonseong
 */
import java.util.*;	
public class KakaoBlind2019_5 {
	public static void main(String[] args) {
		int temp[][] = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		Solution s = new Solution();
		s.solution(temp);
	}
}
class Node implements Comparable<Node>{
	int x;
	int y;
	int idx;
	Node(int x, int y, int idx){
		this.x = x;
		this.y = y;
		this.idx = idx;
	}
	@Override
	public int compareTo(Node o) {
		if(o.y==this.y) {
			return o.x-this.x;
		}
		else {
			return o.y-this.y;
		}
	}
}
class TreeNode{
	int data;
	int x;
	TreeNode left;
	TreeNode right;
	TreeNode(int data,int x){
		this.data = data;
		this.x = x;
	}
}
class Tree{
	TreeNode root;
	ArrayList<Integer> list1 = new ArrayList<Integer>();
	ArrayList<Integer> list2 = new ArrayList<Integer>();
	Tree(int data,int x){
		root = new TreeNode(data,x);
	}
	public void add(int data, int x) {
		find(root, data, x);
	}
	public void find(TreeNode node, int data, int x) {
		if(node.x < x) {
			if(node.right == null) {
				node.right = new TreeNode(data,x);
			} else {
				find(node.right,data,x);
			}
		}
		else {
			if(node.left == null) {
				node.left = new TreeNode(data,x);
			} else {
				find(node.left,data,x);
			}
		}
	}
	public void preOrder(TreeNode node) {
		if(node==null)
			return;
		list1.add(node.data);
		preOrder(node.left);
		preOrder(node.right);
	}
	public void postOrder(TreeNode node) {
		if(node==null)
			return;
		postOrder(node.left);
		postOrder(node.right);
		list2.add(node.data);
	}
}
class Solution{
	public int[][] solution(int[][] nodeinfo) {
		int[][] answer = new int[2][nodeinfo.length];
		for(int i=0;i<2;i++) {
			answer[i] = new int[nodeinfo.length];
		}
		Node node[] = new Node[nodeinfo.length];
		for(int i=0;i<nodeinfo.length;i++) {
			node[i] = new Node(nodeinfo[i][0],nodeinfo[i][1],i+1);
		}
		Arrays.sort(node);
		
		Tree t = new Tree(node[0].idx,node[0].x);
		for(int i=1;i<node.length;i++) {
			t.add(node[i].idx,node[i].x);
		}
		t.preOrder(t.root);
		t.postOrder(t.root);
		for(int i=0;i<t.list1.size();i++) {
			answer[0][i] = t.list1.get(i);
			answer[1][i] = t.list2.get(i);
		}
		return answer;
	}
}