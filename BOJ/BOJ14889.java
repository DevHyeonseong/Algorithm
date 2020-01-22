/*
 * BOJ14889
 * 2020.01.22
 * Hyeonseong
 */
import java.util.*;
public class BOJ14889
{
	public static void main(String[] args) 
	{
		Solution s = new Solution();
	}
}
class Solution{
	int n;
	int[][] team;
	int[] a;
	int min;
	ArrayList<Integer> s;
	public Solution() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		team = new int[n+1][n+1];
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<n+1;j++) {
				team[i][j] = scan.nextInt();
			}
		}
		a = new int[21];
		min = Integer.MAX_VALUE;
		s = new ArrayList<Integer>();
		go(0,1,n/2);
		for(int i=0;i<s.size()/2;i++) {
			min = Math.min(min, Math.abs(s.get(i)-s.get(s.size()-(i+1))));
		}
		System.out.println(min);
	}
	public void go(int index,int p, int m) {
		if(index==m) {
			int sum = 0;
			for(int i=0;i<n/2-1;i++) {
				for(int j=i+1;j<n/2;j++) {
					sum += team[a[i]][a[j]];
					sum += team[a[j]][a[i]];
				}
			}
			s.add(sum);
			return;
		}
		for(int i=p;i<=n;i++) {
			a[index] = i;
			go(index+1,i+1,m);
		}
	}
}