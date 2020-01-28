/*
 * BOJ1309
 * 2020.01.19
 * Hyeonseong
 */
import java.util.*;
public class BOJ1309
{
	public static void main(String[] args) 
	{
		Solution s = new Solution();
	}
}
class Solution{
	public Solution() {
		final int MOD = 9901;
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		long[][] dp = new long[n+1][3];
		
		dp[1][0] = 1;
		dp[1][1] = 1;
		dp[1][2] = 1;
		
		for(int i=2;i<n+1;i++) {
			dp[i][0] = (dp[i-1][0]+dp[i-1][1]+dp[i-1][2])%MOD;
			dp[i][1] = (dp[i-1][0]+dp[i-1][2])%MOD;
			dp[i][2] = (dp[i-1][0]+dp[i-1][1])%MOD;
		}
		
		System.out.println((dp[n][0]+dp[n][1]+dp[n][2])%MOD);
	}
}