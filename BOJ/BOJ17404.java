/*
 * BOJ17404
 * 2020.01.20
 * Hyeonseong
 */
import java.util.*;
public class BOJ17404
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
		int[][] dp = new int[n+1][3];
		int[][] arr = new int[n+1][3];
		for(int i=1;i<n+1;i++) {
			for(int j=0;j<3;j++) {
				arr[i][j] = scan.nextInt();
			}
		}
		
		int answer = Integer.MAX_VALUE;
		for(int k=0;k<3;k++) {
			for(int j=0;j<3;j++) {
				if(j==k) {
					dp[1][j] = arr[1][j];
				}
				else {
					dp[1][j] = 1000*1000+1;
				}
			}
			for(int i=2;i<n+1;i++) {
				dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2])+arr[i][0];
				dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2])+arr[i][1];
				dp[i][2] = Math.min(dp[i-1][1],dp[i-1][0])+arr[i][2];
			}
			for(int i=0;i<3;i++) {
				if(i!=k) {
					answer = Math.min(answer,dp[n][i]);
				}
			}
		}
		System.out.println(answer);		
	}
}
