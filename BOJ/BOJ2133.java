/*
 * BOJ2133
 * 2020.01.20
 * Hyeonseong
 */
import java.util.*;
public class BOJ2133
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
		int[] dp = new int[31];
		dp[0] = 1;
		dp[2] = 3;
		if(n>=4) {
			for(int i=4;i<31;i+=2) {
				dp[i] = dp[i-2]*3;
				for(int j=4;j<=i;j+=2) {
					dp[i] += dp[i-j]*2;
				}
			}	
		}
		System.out.println(dp[n]);
	}
}