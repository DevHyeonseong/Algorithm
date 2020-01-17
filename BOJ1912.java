/*
 * BOJ1912
 * 2020.01.17
 * Hyeonseong
 */
import java.util.*;
public class BOJ1912 {
	public static void main(String[] args) {
		Solution s = new Solution();
	}
}
class Solution{
	public Solution() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] arr = new int[n+1];
		for(int i=1;i<arr.length;i++) {
			arr[i] = scan.nextInt();
		}
		
		int[] dp = new int[n+1];
		dp[1] = arr[1];
		int max = Integer.MIN_VALUE;
		for(int i=2;i<n+1;i++) {
			dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
			if(max < dp[i]) {
				max = dp[i];
			}
		}
		
		System.out.println(Math.max(dp[1],max));
	}
}