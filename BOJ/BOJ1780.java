/*
 * BO1780
 * 2020.02.03
 * Hyeonseong
 */
import java.util.*;	
public class BOJ1780 {
	public static void main(String[] args) {
		Solution s = new Solution();
	}
}
class Solution{
	int paper[][];
	int cnt[];
	public Solution() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		paper = new int[n][n];
		cnt = new int[3];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				paper[i][j] = scan.nextInt();
			}
		}
		go(0,0,n);
		for(int i=0;i<3;i++) {
			System.out.println(cnt[i]);
		}
	}
	public void go(int x,int y,int n) {
		if(check(x,y,n)) {
			cnt[paper[x][y]+1] += 1;
			return;
		}
		int m = n/3;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				go(x+i*m,y+j*m,m);
			}
		}
	}
	public boolean check(int x, int y, int n) {
		for(int i=x;i<x+n;i++) {
			for(int j=y;j<y+n;j++) {
				if(paper[x][y]!=paper[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
