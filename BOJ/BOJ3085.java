/*
 * BOJ3085
 * 2020.01.20
 * Hyeonseong
 */
import java.util.*;
public class BOJ3085
{
	public static void main(String[] args) 
	{
		Solution s = new Solution();
	}
}
class Solution{
	char[][] candy;
	int max;
	public Solution() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		max = 0;
		candy = new char[n][n];
		for(int i=0;i<n;i++) {
			candy[i] = scan.next().toCharArray();
		}
		char temp=' ';
		
		for(int i=0;i<n;i++) { // 가로 확인
			for(int j=0;j<n-1;j++) {
				if(candy[i][j] != candy[i][j+1]) {
					temp= candy[i][j];
					candy[i][j] = candy[i][j+1];
					candy[i][j+1] = temp;
					check();
					temp = candy[i][j];
					candy[i][j] = candy[i][j+1];
					candy[i][j+1] = temp;
				}
			}
		}
		for(int i=0;i<n;i++) { // 세로확인
			for(int j=0;j<n-1;j++) {
				if(candy[j][i]!=candy[j+1][i]) {
					temp = candy[j][i];
					candy[j][i] = candy[j+1][i];
					candy[j+1][i] = temp;	
					check();
					temp = candy[j][i];
					candy[j][i] = candy[j+1][i];
					candy[j+1][i] = temp;	
				}
			}
		}
		System.out.println(max);
	}
	public void check(){
		int num = 1;
		for(int i=0;i<candy.length;i++) { // 가로체크
			num = 1;
			for(int j=0;j<candy[i].length-1;j++) {
				if(candy[i][j]==candy[i][j+1]) {
					num++;
					if(max < num) {
						max = num;
					}
				}
				else {
					num = 1;
				}
			}
		}
		for(int i=0;i<candy.length;i++) { // 세로체크
			num = 1;
			for(int j=0;j<candy[i].length-1;j++) {
				if(candy[j][i]==candy[j+1][i]) {
					num++;
					if(max < num) {
						max = num;
					}
				}
				else {
					num = 1;
				}
			}
		}
	}
	
}