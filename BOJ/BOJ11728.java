/*
 * BO11728
 * 2020.02.03
 * Hyeonseong
 */
import java.util.*;	
public class BOJ11728 {
	public static void main(String[] args) {
		Solution s = new Solution();
	}
}
class Solution{
	int n; // 첫번째 배열 크기
	int m; // 두번째 배열 크기
	int a[],b[];
	public Solution() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		m = scan.nextInt();
		a = new int[n];
		b = new int[m];
		for(int i=0;i<n;i++) {
			a[i] = scan.nextInt();
		}
		for(int i=0;i<m;i++) {
			b[i] = scan.nextInt();
		}
		int left = 0, right =0;
		StringBuilder sb = new StringBuilder();
		while(!(left==n || right==m)) {
			if(a[left]<=b[right]) {
				sb.append(a[left]+" ");
				left++;
			} else {
				sb.append(b[right]+" ");
				right++;
			}
		}
		if(left==n) {
			for(int i=right;i<m;i++) {
				sb.append(b[i]+" ");		
			}
		}
		if(right==m) {
			for(int i=left;i<n;i++) {
				sb.append(a[i]+" ");		
			}
		}
		System.out.println(sb.toString().trim());
	}
}
