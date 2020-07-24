/*
 * BOJ1300
 * 2020.02.07
 * Hyeonseong 
 */
import java.util.*;	
public class BOJ2343 {
	public static void main(String[] args) {
		Solution s = new Solution();
	}
}
class Solution{
	int n; // 레슨의 수
	int m; // 블루레이의 수 
	int les[]; // 강의
	int answer; // 정답 
	public Solution() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		les = new int[n];
		int start = 0, end = 0;
		answer = 0;
		for(int i=0;i<n;i++) {
			les[i] = scan.nextInt();
		}
		for(int i=0;i<n;i++) {
			if(start < les[i]) {
				start = les[i];
			}
			end+=les[i];
		}
		while(start<=end) {
			int mid = (start+end)/2; // 블루레이의 크기
			if(go(mid)) { 
				answer = mid;
				end = mid-1;
			} else {
				start = mid+1;
			}
		}
		System.out.println(answer);
	}
	public boolean go(int size) {
		int cnt = 0;
		int sum = 0;
		for(int i=0;i<n;i++) {
			if(sum+les[i]>size) { // 레슨크기의합이 사이즈보다 커지면
				cnt++; // 블루레이의 개수를 1개늘리고
				sum = les[i]; // 새로운 그룹을 만든다
			} else {
				sum+=les[i];
			}
		}
		return (cnt>=m) ? false : true;
	}
}