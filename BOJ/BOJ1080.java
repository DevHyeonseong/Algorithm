/*
 * BOJ1080
 * 2020.02.01
 * Hyeonseong
 */
import java.util.*;	
public class BOJ1080 {
	public static void main(String[] args) {
		Solution s = new Solution();
	}
}
class Solution{
	int n,m;
	int a[][];
	int b[][];
	int answer = 0;
	public Solution() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt(); scan.nextLine();
		a = new int[n][m];
		b = new int[n][m];
		for(int i=0;i<n;i++) {
			char temp[] = scan.nextLine().toCharArray();
			for(int j=0;j<m;j++) {
				a[i][j] = temp[j]-'0';
			}
		}
		for(int i=0;i<n;i++) {
			char temp[] = scan.nextLine().toCharArray();
			for(int j=0;j<m;j++) {
				b[i][j] = temp[j]-'0';
			}
		}
		for(int i=0;i<n-2;i++) {
			for(int j=0;j<m-2;j++) {
				if(a[i][j]!=b[i][j]) {
					change(i,j);
					answer++;
				}
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(a[i][j]!=b[i][j]) {
					System.out.println("-1");
					return;
				}
			}
		}
		System.out.println(answer);
	}
	public void change(int x, int y) {
		for(int i=x;i<x+3;i++) {
			for(int j=y;j<y+3;j++) {
				a[i][j] = 1-a[i][j];
			}
		}
	}
}