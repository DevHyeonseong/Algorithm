/*
 * BOJ15649
 * 2020.01.20
 * Hyeonseong
 */
import java.util.*;
public class BOJ15649
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
		go(0,n,m);
	}
	public void go(int index, int n, int m) {
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
		for(int i=1;i<=n;i++) {
			if(c[i]) {
				continue;
			}
			c[i] = true;
			a[index] = i;
			go(index+1,n,m);
			c[i] = false;
		}
	}
}