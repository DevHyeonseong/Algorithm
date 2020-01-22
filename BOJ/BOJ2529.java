/*
 * BOJ2529
 * 2020.01.22
 * Hyeonseong
 */
import java.util.*;
public class BOJ2529
{
	public static void main(String[] args) 
	{
		Solution s = new Solution();
	}
}
class Solution{
	int n;
	char[] ineq;
	int[] a;
	boolean[] c;
	ArrayList<String> list = new ArrayList<String>();
	public Solution() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<n;i++) {
			sb.append(scan.next());
		}
		ineq = sb.toString().toCharArray();
		a = new int[11];
		c = new boolean[11];
		go(0);
		System.out.println(list.get(list.size()-1));
		System.out.println(list.get(0));
	}
	public void go(int index) {
		if(index==n+1) {
			StringBuilder sb =new StringBuilder();
			int p =0;
			sb.append(a[0]);
			for(int i=0;i<n;i++) {
				if(ineq[p]=='<') {
					if(a[i] >= a[i+1]) {
						return;
					}
					else {
						sb.append(a[i+1]);
					}
				}
				else { // '>'
					if(a[i] <= a[i+1]) {
						return;
					}
					else {
						sb.append(a[i+1]);
					}
				}
				p++;
			}
			list.add(sb.toString());
			return;
		}
		for(int i=0;i<10;i++) {
			if(c[i]) {
				continue;
			}
			a[index] = i;
			c[i] = true;
			go(index+1);
			c[i] = false;
		}
	}
}