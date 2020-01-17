/*
 * BOJ1699
 * 2020.01.17
 * Hyeonseong
 */
import java.util.*;
public class BOJ1699 {
	public static void main(String[] args) {
		Solution s = new Solution();
	}
}
class Solution{
	public Solution() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		int[] dp = new int[n+1];
		dp[1] = 1;
		
		for(int i=2;i<n+1;i++) {
			dp[i] = Integer.MAX_VALUE;
			for(int j=1;i>=j*j;j++) {
				dp[i] = Math.min(dp[i],dp[i-(j*j)]+1);
			}
		}
		
		System.out.println(dp[n]);
	}
}