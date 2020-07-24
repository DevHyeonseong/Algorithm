/*
 * BOJ1074
 * 2020.02.03
 * Hyeonseong 
 */
import java.util.*;	
public class BOJ1074 {
	public static void main(String[] args) {
		Solution s = new Solution();
	}
}
class Solution{
	int n,r,c;
	int num;
	public Solution() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		r = scan.nextInt();
		c = scan.nextInt();
		num = 0;
		solve(0,0,(int)Math.pow(2,n));
	}
	public void solve(int x, int y, int n) {
		int m = n/2;
		if(m==1) {
			for(int i=0;i<2;i++) {
				for(int j=0;j<2;j++) {
					if(x+i==r && y+j ==c) { // 원하는 인덱스가 오면 순서 출력후 종료
						System.out.println(num);
						System.exit(0);
					}
					num++; // 4칸짜리가 되면 순서기록
				}
			}
			return;
		}
		for(int i=0;i<2;i++) {
			for(int j=0;j<2;j++) {
				solve(x+i*m,y+j*m,m); // 4칸이될때까지 쪼갠다
			}
		}
	}
}