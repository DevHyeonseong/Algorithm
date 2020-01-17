/*
 * BOJ1676
 * 2020.01.16
 * Hyeonseong
 */
import java.util.*;
public class BOJ1676 {
	public static void main(String[] args) {
		Solution s = new Solution();
	}
}
class Solution{
	public Solution() {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int num = 0;
		for(int i=5;i<a;i*=5) {
			num += a/i;
		}
		System.out.println(num);
	}
}