/*
 * BOJ1654
 * 2020.02.04
 * Hyeonseong 
 */
import java.util.*;	
public class BOJ1654 {
	public static void main(String[] args) {
		Solution s = new Solution();
	}
}
class Solution{
	int k;
	long n;
	long list[];
	public Solution() {
		Scanner scan = new Scanner(System.in);
		k = scan.nextInt(); // 이미 가지고 있는 랜선의 개수
		n = scan.nextLong(); // 필요한 랜선의 개수
		list = new long[k];
		long max = -1;
		for(int i=0;i<k;i++) {
			list[i] = scan.nextInt();
			if(max < list[i]) {
				max = list[i];
			}
		}
		long start = 1;
		long end = max;
		long maxLen = -1;
		while(start<=end) {
			long mid = (start+end)/2;
			long sum = 0;
			for(int i=0;i<list.length;i++) {
				sum+=list[i]/mid; // 현재 길이로 짤랐을때 나오는 랜선의 개수
			}
			if(sum >= n) { // 개수가 크거나같다면
				if(maxLen < mid) { // 가장 큰 길이만 저장한다
					maxLen = mid;
				}
				start = mid+1;
			} else {
				end = mid-1;
			}
		}
		System.out.println(maxLen);
	}
}