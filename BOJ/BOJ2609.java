/*
 * BOJ2609
 * 2020.01.16
 * Hyeonseong
 */
import java.util.*;
public class BOJ2609 {

	public static void main(String[] args) {
		Solution s = new Solution();
	}
}
class Solution{
	public Solution() {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int g = gcd(a,b);
		System.out.println(g);
		System.out.println((a*b)/g);
	}
	public int gcd(int a, int b) {
		if(b==0) {
			return a;
		}
		else {
			return gcd(b, a%b);
		}
	}
}
