/*
 * BOJ14501
 * 2020.01.22
 * Hyeonseong
 */
import java.util.*;
public class BOJ14501
{
	public static void main(String[] args) 
	{
		Solution s = new Solution();
	}
}
class Solution{
	int n;
	int c;
	int[][] sch;
	int max = 0;
	public Solution() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		sch = new int[n][2];
		for(int i=0;i<n;i++) {
			sch[i][0] = scan.nextInt();
			sch[i][1] = scan.nextInt();
		}
		go(0,0,0);
		System.out.println(max);
	}
	public void go(int pay,int date, int i) {
		if(date>n) {
			return;
		}
		if(date<n) {
			if(max < pay) {
				max = pay;
			}
		}
		if(date==n) {
			if(max < pay) {
				max = pay;
			}
			return;
		}
		go(pay+sch[i][1],date+sch[i][0],i+sch[i][0]);
		go(pay,date+1,i+1);
	}
}