/*
 * BOJ2193
 * 2020.01.17
 * Hyeonseong
 */
import java.util.*;
public class BOJ2193 {
	public static void main(String[] args) {
		Solution s = new Solution();
	}
}
class Solution{
	public Solution() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		long[][] dp = new long[n+1][2];
		dp[1] = new long[2];
		dp[1][1] = 1;
		
		for(int i=2;i<n+1;i++) {
			dp[i] = new long[2];
			dp[i][1] = dp[i-1][0];
			dp[i][0] = dp[i-1][0]+dp[i-1][1];
		}
		
		long answer = 0;
		answer = dp[n][0]+dp[n][1];
		System.out.println(answer);
	}
}