/*
 * BO11729
 * 2020.02.03
 * Hyeonseong
 */
import java.util.*;	
public class BOJ1729 {
	public static void main(String[] args) {
		Solution s = new Solution();
	}
}
class Solution{
	int n;
	int num;
	StringBuilder sb;
	public Solution() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		sb = new StringBuilder();
		num = 0;
		go(n,1,3);
		System.out.println(num);
		System.out.print(sb.toString().trim());
	}
	public void go(int n, int x, int y) {
		if(n==0) return;
		go(n-1,x,6-x-y);
		sb.append(x+" "+y+"\n");
		num++;
		go(n-1,6-x-y,y);
	}
}
