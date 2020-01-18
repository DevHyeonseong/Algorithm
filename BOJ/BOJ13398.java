/*
 * BOJ13398
 * 2020.01.19
 * Hyeonseong
 */
import java.util.*;
public class BOJ13398
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

		int[] arr = new int[n+1];
		int[] dp1 = new int[n+1];
		int[] dp2 = new int[n+1];
		for(int i=1;i<n+1;i++) {
			arr[i] = scan.nextInt();
		}
		dp1[1] = arr[1];
		for(int i=2;i<n+1;i++) {
			dp1[i] = Math.max(dp1[i-1]+arr[i],arr[i]);
		}
		
		dp2[n] = arr[n];
		for(int i=n-1;i>=0;i--) {
			dp2[i] = Math.max(dp2[i+1]+arr[i],arr[i]);
		}
		
		int answer = Integer.MIN_VALUE;
		for(int i=1;i<n+1;i++) {
			answer = Math.max(answer,dp1[i]);
		}
		
		for(int i=1;i<n;i++) {
			answer = Math.max(answer, dp1[i-1]+dp2[i+1]);
		}
		System.out.println(answer);
	}
}