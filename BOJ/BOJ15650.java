/*
 * BOJ15650
 * 2020.01.20
 * Hyeonseong
 */
import java.util.*;
public class BOJ15650
{
	public static void main(String[] args) 
	{
		Solution s = new Solution();
	}
}
class Solution{
	boolean[] c;
	int[] a;
	public Solution() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		c = new boolean[10];
		a = new int[10];
		go(0,1,n,m);
	}
	public void go(int index,int start, int n, int m) {
		if(index==m) {
			for(int i=0;i<a.length;i++) {
				if(a[i]!=0) {
					System.out.print(a[i]+" ");
				}
				else {
					break;
				}
			}
			System.out.println();
			return;
		}
		for(int i=start;i<=n;i++) {
			if(c[i]) {
				continue;
			}
			c[i] = true;
			a[index] = i;
			go(index+1,i+1,n,m);
			c[i] = false;
		}
	}
}