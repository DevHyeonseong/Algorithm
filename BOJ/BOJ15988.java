/*
 * BOJ15988
 * 2020.01.18
 * Hyeonseong
 */
import java.util.*;
public class BOJ15988
{
	public static void main(String[] args) 
	{
		Solution s = new Solution();
	}
}
class Solution{
	public Solution() {
		final int MOD = 1000000009;
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		long dp[] = new long[10000001];
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i=4;i<10000001;i++) {
			dp[i] = (dp[i-1]+dp[i-2]+dp[i-3])%MOD;
		}
		for(int i=0;i<n;i++) {
			System.out.println(dp[scan.nextInt()%MOD]);
		}
		
	}
}