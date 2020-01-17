/*
 * BOJ10844
 * 2020.01.17
 * Hyeonseong
 */
import java.util.*;
public class BOJ10844 {
	public static void main(String[] args) {
		Solution s = new Solution();
	}
}
class Solution{
	public Solution() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		long[][] dp = new long[n+1][10];
		final long MOD = 1000000000;
		dp[1] = new long[10];
		for(int i=1;i<10;i++) {
			dp[1][i] = 1;
		}
		for(int i=2;i<n+1;i++) {
			dp[i] = new long[10];
			for(int j=0;j<10;j++) {
				if(j-1>=0) {
					dp[i][j] += dp[i-1][j-1];
				}
				if(j+1<=9) {
					dp[i][j] += dp[i-1][j+1];
				}
				dp[i][j] %= MOD;
			}
		}
		long answer = 0;
		for(int i=0;i<10;i++) {
			answer += dp[n][i];
		}
		System.out.println(answer%MOD);
	}
}