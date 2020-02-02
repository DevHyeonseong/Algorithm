/*
 * BO1010
 * 2020.02.01
 * Hyeonseong
 */
import java.util.*;	
public class BOJ1010 {
	public static void main(String[] args) {
		Solution s = new Solution();
	}
}
class Solution{
	int t; // 테스트케이스
	public Solution() {
		Scanner scan = new Scanner(System.in);
		t = scan.nextInt();
		int dp[][] = new int[31][31];
		for(int i=1;i<31;i++) {
			dp[i][i] = 1;
			dp[1][i] = i;
		}
		for(int i=2;i<31;i++) {
			for(int j=i+1;j<31;j++) {
				for(int k=j-1;k>=i-1;k--) {
					dp[i][j] += dp[i-1][k];
				}
			}
		}
		while(t-->0) {
			System.out.println(dp[scan.nextInt()][scan.nextInt()]);
		}
	}
}
