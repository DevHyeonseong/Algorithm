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
	int n; // ������ ��
	long m; // ������ ���������� ������ ����
	int wood[]; // ����
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
		long maxCut = 0; // ���ܱ��� �ִ����
		while(start<=end) {
			long mid = (start+end)/2; // ���ܱ��� ����
			long len = 0;
			for(int i=0;i<wood.length;i++) {
				if(wood[i]>=mid) {
					len+=wood[i]-mid; // ������ �� �ִ� ������ ����
				}
			}
			if(len >= m) { // m���� ũ�ų� ���ٸ�
				if(maxCut < mid) { // ���ܱ��� �ִ���̸� �����Ѵ�
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