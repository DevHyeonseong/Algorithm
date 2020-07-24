/*
 * BOJ2263
 * 2020.02.03
 * Hyeonseong 
 */
import java.util.*;	
public class BOJ2263 {
	public static void main(String[] args) {
		Solution s = new Solution();
	}
}
class Solution{
	int n;
	int inOrder[],postOrder[],position[];
	public Solution() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		inOrder = new int[n+1];
		postOrder = new int[n+1];
		position = new int[n+1];
		for(int i=0;i<n;i++) {
			inOrder[i] = scan.nextInt();
		}
		for(int i=0;i<n;i++) {
			postOrder[i] = scan.nextInt();
		}
		for(int i=0;i<n;i++) {
			position[inOrder[i]] = i;
		}
		solve(0,n-1,0,n-1);
	}
	public void solve(int inStart, int inEnd, int postStart, int postEnd) {
		if(inStart > inEnd || postStart > postEnd) return;
		int root = postOrder[postEnd];
		System.out.print(root+" ");
		int p = position[root];
		solve(inStart, p-1, postStart, postStart+(p-inStart)-1);
		solve(p+1,inEnd,postStart+(p-inStart),postEnd-1);
	}
}