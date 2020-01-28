/*
 * BOJ9465
 * 2020.01.19
 * Hyeonseong
 */
import java.util.*;
public class BOJ9465
{
	public static void main(String[] args) 
	{
		Solution s = new Solution();
	}
}
class Solution{
	public Solution() {
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		while(t-->0) {
			int n = scan.nextInt();
			int[][] dp = new int[3][n+1];
			int[][] arr = new int[3][n+1];
			for(int i=1;i<3;i++) {
				for(int j=1;j<n+1;j++) {
					arr[i][j] = scan.nextInt();
				}
			}
			dp[1][1] = arr[1][1];
			dp[2][1] = arr[2][1];
			
			for(int i=2;i<n+1;i++) {
				dp[0][i] = Math.max(dp[1][i-1],dp[2][i-1]);
				dp[0][i] = Math.max(dp[0][i], dp[0][i-1]);
				
				dp[1][i] = Math.max(dp[0][i-1],dp[2][i-1])+arr[1][i];
				
				dp[2][i] = Math.max(dp[0][i-1],dp[1][i-1])+arr[2][i];
			}
			
			int answer = Math.max(dp[0][n],dp[1][n]);
			answer = Math.max(answer, dp[2][n]);
			System.out.println(answer);
		}
	}
}