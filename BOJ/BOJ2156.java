import java.util.*;
/*
 * BOJ 2156
 * 2020.01.14
 * Hyeonseong
 */
public class BOJ2156 {
	public static void main(String[] args) {
		Solution s = new Solution();
		s.solution();
	}

}
class Solution{
	int n;
	int[] grape;
	int[] dp;
	Solution(){
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		grape = new int[n+1];
		for(int i=1;i<n+1;i++) {
			grape[i] = scan.nextInt();
		}
		dp = new int[10001];
	}
	public void solution() {
		if(n==1) {
			System.out.println(grape[1]);
		}
		else if(n==2) {
			System.out.println(grape[1]+grape[2]);
		}
		else {
			dp[1] = grape[1];
			dp[2] = grape[1]+grape[2];
			for(int i=3;i<n+1;i++) {
				dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + grape[i], dp[i-3] + grape[i-1]+grape[i]));
				dp[i] = Math.max(dp[i - 1], dp[i]);
			}
			System.out.println(dp[n]);
		}
	}
}