/*
 * BOJ2138
 * 2020.02.01
 * Hyeonseong
 */
import java.util.*;	
public class BOJ2138 {
	public static void main(String[] args) {
		Solution s = new Solution();
	}
}
class Solution{
	int n;
	int min = Integer.MAX_VALUE;
	int a[],b[],copy[];
	public Solution() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt(); scan.nextLine();
		a = new int[n];
		b = new int[n];
		copy = new int[n];
		char temp[] = scan.nextLine().toCharArray();
		for(int i=0;i<n;i++) {
			a[i] = temp[i]-'0';
			copy[i] = a[i];
		}
		temp = scan.nextLine().toCharArray();
		for(int i=0;i<n;i++) {
			b[i] = temp[i]-'0';
		}
		copy[0] = 1-copy[0];
		copy[1] = 1-copy[1];
		go(1,1);
		for(int i=0;i<n;i++) {
			copy[i] = a[i];
		}
		go(1,0);
		if(min == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(min);
		}
	}
	public void go(int now, int cnt) {
		if(now==n-1) {
			if(copy[now-1]!=b[now-1]) {
				copy[now-1] = 1-copy[now-1];
				copy[now] = 1-copy[now];
				cnt++;
			}
			if(check()) {
				min = Math.min(min, cnt);
			}
			return;
		}
		if(copy[now-1]==b[now-1]) {
			go(now+1,cnt);
		} else {
			for(int i=now-1;i<=now+1;i++) {
				copy[i] = 1-copy[i];
			}
			go(now+1,cnt+1);
		}
	}
	public boolean check() {
		for(int i=0;i<n;i++) {
			if(copy[i]!=b[i]) return false;
		}
		return true;
	}
}