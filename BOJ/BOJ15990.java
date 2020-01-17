/*
 * BOJ15990
 * 2020.01.16
 * Hyeonseong
 */
import java.util.*;
public class BOJ15990 {
	public static void main(String[] args) {
		Solution s = new Solution();
	}
}
class Solution{
	public Solution() {
		final long MOD = 1000000009;
		Scanner scan = new Scanner(System.in);
		long dp[][] = new long[100001][4];
		dp[1][1] = 1;
		dp[2][2] = 1;
		dp[3][1] = 1;
		dp[3][2] = 1;
		dp[3][3] = 1;
		for(int i=4;i<=100000;i++) {
			dp[i] = new long[4];
			dp[i][1] = dp[i-1][2]+dp[i-1][3];
			dp[i][1] %= MOD;
			dp[i][2] = dp[i-2][1]+dp[i-2][3];
			dp[i][2] %= MOD;
			dp[i][3] = dp[i-3][1]+dp[i-3][2];
			dp[i][3] %= MOD;
		}
		int t = scan.nextInt();
		for(int i=0;i<t;i++) {
			int n = scan.nextInt();
			System.out.println((dp[n][1]+dp[n][2]+dp[n][3])%MOD);
		}
	}
}