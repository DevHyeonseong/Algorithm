/*
 * BO11729
 * 2020.02.03
 * Hyeonseong
 */
import java.util.*;	
public class BOJ11729 {
	public static void main(String[] args) {
		Solution s = new Solution();
	}
}
class Solution{
	int n;
	public Solution() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		go(n,1,3);
	}
	public void go(int n, int x, int y) {
		if(n==0) return;
		go(n-1,x,6-x-y);
		System.out.println(x+" "+y);
		go(n-1,6-x-y,y);
	}
}
