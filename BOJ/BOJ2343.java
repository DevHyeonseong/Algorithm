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
	int n; // ������ ��
	int m; // ��緹���� �� 
	int les[]; // ����
	int answer; // ���� 
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
			int mid = (start+end)/2; // ��緹���� ũ��
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
			if(sum+les[i]>size) { // ����ũ�������� ������� Ŀ����
				cnt++; // ��緹���� ������ 1���ø���
				sum = les[i]; // ���ο� �׷��� �����
			} else {
				sum+=les[i];
			}
		}
		return (cnt>=m) ? false : true;
	}
}