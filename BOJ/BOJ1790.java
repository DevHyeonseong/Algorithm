/*
 * BOJ1790
 * 2020.02.04
 * Hyeonseong 
 */
import java.util.*;	
public class BOJ1790 {
	public static void main(String[] args) {
		Solution s = new Solution();
	}
}
class Solution{
	int n;
	long k;
	int answer;
	public Solution() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		k = scan.nextLong();
		if(countLen(n)<k) {
			System.out.println("-1");
			return;
		}
		int start = 1;
		int end = n;
		while(start<=end) {
			int mid = (start+end)/2;
			long len = countLen(mid);
			if(len<k) {
				start = mid+1;
			} else {
				answer = mid;
				end = mid-1;
			}
		}
		String str = Integer.toString(answer);
		long len = countLen(answer);
		System.out.println(str.charAt((int) (str.length()-(len-k)-1)));
	}
	public long countLen(int n) {
		long l = 0;
		for(int start=1,len=1;start<=n;start*=10,len++) {
			int end = start*10-1;
			if(end>n) {
				end = n;
			}
			l += (long)(end-start+1)*len;
		}
		return l;
	}
}