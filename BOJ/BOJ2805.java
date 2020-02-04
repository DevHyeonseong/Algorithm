/*
 * BOJ2805
 * 2020.02.04
 * Hyeonseong 
 */
import java.util.*;	
public class BOJ2805 {
	public static void main(String[] args) {
		Solution s = new Solution();
	}
}
class Solution{
	int n; // 나무의 수
	long m; // 집으로 가져가려는 나무의 길이
	int wood[]; // 나무
	public Solution() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextLong();
		wood = new int[n];
		long max = -1;
		for(int i=0;i<n;i++) {
			wood[i] = scan.nextInt();
			if(max<wood[i]) {
				max = wood[i];
			}
		}
		long start = 1;
		long end = max;
		long maxCut = 0; // 절단기의 최대높이
		while(start<=end) {
			long mid = (start+end)/2; // 절단기의 높이
			long len = 0;
			for(int i=0;i<wood.length;i++) {
				if(wood[i]>=mid) {
					len+=wood[i]-mid; // 가져갈 수 있는 나무의 총합
				}
			}
			if(len >= m) { // m보다 크거나 같다면
				if(maxCut < mid) { // 절단기의 최대높이를 저장한다
					maxCut = mid; 
				}
				start = mid+1;
			} else {
				end = mid-1;
			}
		}
		System.out.println(maxCut);
	}
}