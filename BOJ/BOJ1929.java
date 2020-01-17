/*
 * BOJ1929
 * 2020.01.16
 * Hyeonseong
 */
import java.util.*;
public class BOJ1929 {
	public static void main(String[] args) {
		Solution s = new Solution();
	}
}
class Solution{
	public Solution() {
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int n = scan.nextInt();
		
		boolean[] check = new boolean[10000001];
		ArrayList<Integer> prime = new ArrayList<Integer>();
		int num = 0;
		
		for(int i=2;i<=n;i++) {
			if(check[i]==false && i>=m) {
				prime.add(i);
			}
			for(int j=i*2;j<=n;j=j+i) {
				check[j] = true;
			}
		}
		
		for(int i : prime) {
			System.out.println(i);
		}
	}
}