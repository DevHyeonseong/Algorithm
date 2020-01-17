/*
 * BOJ11052
 * 2020.01.16
 * Hyeonseong
 */
import java.util.*;
public class BOJ11052 {
	public static void main(String[] args) {
		Solution s = new Solution();
	}
}
class Solution{
	public Solution() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] p = new int[n+1];
		int[] dp = new int[n+1];
		
		for(int i=1;i<n+1;i++) {
			p[i] = scan.nextInt();
		}
		
		dp[1] = p[1];
		
		for(int i=2 ;i<n+1;i++) {
			for(int j=i;j>0;j--) {
				dp[i] = Math.max(dp[i],dp[i-j]+p[j]);
			}
		}
		System.out.println(dp[n]);
		
	}
}
