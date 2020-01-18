/*
 * BOJ11057
 * 2020.01.19
 * Hyeonseong
 */
import java.util.*;
public class BOJ11057
{
	public static void main(String[] args) 
	{
		Solution s = new Solution();
	}
}
class Solution{
	public Solution() {
		final int MOD = 10007;
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		long[][] dp = new long[n+1][10];
		for(int i=0;i<10;i++) {
			dp[1][i] = 1;
		}
		
		for(int i=2;i<n+1;i++) {
			for(int j=0;j<10;j++) {
				for(int k=0;k<=j;k++) {
					dp[i][j] += dp[i-1][k];
				}
				dp[i][j]%=MOD;
			}
		}
		long answer = 0;
		
		for(int i=0;i<10;i++) {
			answer += dp[n][i];
		}
		System.out.println(answer%MOD);
	}
}