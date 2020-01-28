/*
 * BOJ1932
 * 2020.01.19
 * Hyeonseong
 */
import java.util.*;
public class BOJ1932
{
	public static void main(String[] args) 
	{
		Solution s = new Solution();
	}
}
class Solution{
	public Solution() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		
		int[][] dp = new int[n+1][n];
		int[][] arr = new int[n+1][n];
		for(int i=1;i<n+1;i++) {
			for(int j=0;j<i;j++) {
				arr[i][j] = scan.nextInt();
			}
		}
		dp[1][0] = arr[1][0];
		for(int i=2;i<n+1;i++) {
			for(int j=0;j<i;j++) {
				if(j==0) {
					dp[i][j] = dp[i-1][j]+arr[i][j];
				}
				else if(j==i-1) {
					dp[i][j] = dp[i-1][j-1]+arr[i][j];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j])+arr[i][j];
				}
			}
		}
		int answer = 0;
		for(int i=0;i<n;i++) {
			answer = Math.max(answer, dp[n][i]);
		}
		System.out.println(answer);
	}
}