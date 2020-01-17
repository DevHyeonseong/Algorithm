/*
 * BOJ2225
 * 2020.01.18
 * Hyeonseong
 */
import java.util.*;
public class BOJ2225 {
	public static void main(String[] args) {
		Solution s = new Solution();
	}
}
class Solution{
	public Solution() {
		final long MOD = 1000000000;
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		
		long[][] dp = new long[k+1][n+1];
		
		for(int i=0;i<n+1;i++) {
			dp[1][i] = 1;
		}
		
		for(int i=1;i<k+1;i++) {
			for(int j=0;j<n+1;j++) {
				for(int p=0;p<=j;p++) {
					dp[i][j]+=dp[i-1][j-p]%MOD;
				}
			}
		}
		System.out.println(dp[k][n]%MOD);
	}
}