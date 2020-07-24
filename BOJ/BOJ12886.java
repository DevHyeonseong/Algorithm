/*
 * BOJ12886
 * 2020.01.29
 * Hyeonseong
 */
import java.util.*;	
public class BOJ12886 {
	public static void main(String[] args) {
		Solution s = new Solution();
	}
}
class Solution{
	int a,b,c;
	int sum;
	boolean check[][];
	public Solution() {
		Scanner scan = new Scanner(System.in);
		a = scan.nextInt();
		b = scan.nextInt();
		c = scan.nextInt();
		sum = a+b+c;
		check = new boolean[1501][1501];
		if(sum%3!=0) {
			System.out.println(0);
			return;
		}
		go(a,b);
		if(check[sum/3][sum/3]) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}
	public void go(int x,int y) {
		if(check[x][y])
			return;
		check[x][y] = true;
		int a[] = {x,y,sum-x-y};
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				if(a[i] < a[j]) {
					int b[] = {x,y,sum-x-y};
					b[i] += a[i];
					b[j] -= a[i];
					go(b[0],b[1]);
				}
			}
		}
	}
}



