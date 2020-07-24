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
		k = scan.nextInt(); // �̹� ������ �ִ� ������ ����
		n = scan.nextLong(); // �ʿ��� ������ ����
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
				sum+=list[i]/mid; // ���� ���̷� ©������ ������ ������ ����
			}
			if(sum >= n) { // ������ ũ�ų����ٸ�
				if(maxLen < mid) { // ���� ū ���̸� �����Ѵ�
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