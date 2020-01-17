/*
 * BOJ1463
 * 2020.01.16
 * Hyeonseong
 */
import java.util.*;
public class BOJ1463 {
	public static void main(String[] args) {
		Solution s = new Solution();
	}
}
class Solution{
	public Solution() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] dp = new int[1000001];
		
		dp[1] = 0;
		dp[2] = 1;
		dp[3] = 1;
		if(n==1) {
			System.out.println("0");
		}
		else {
			for(int i=1;i<n+1;i++) {
				if(dp[i]==0) {
					if(i%3 !=0 && i%2 !=0) {
						dp[i] = dp[i-1]+1;
					}
					else if(i%3 == 0) {
						dp[i] = Math.min(dp[i/3]+1, dp[i-1]+1);
					}
					else if(i%2 ==0) {
						dp[i] = Math.min(dp[i/2]+1, dp[i-1]+1);
					}
					else {
						dp[i] = Math.min(dp[i/3]+1, dp[i/2]+1);
						dp[i] = Math.min(dp[i], dp[i-1]+1);
					}
				}
			}
			System.out.println(dp[n]);
		}
	}
}