/*
 * BOJ2799
 * 2020.01.17
 * Hyeonseong
 */
import java.util.*;
public class BOJ2799 {
	public static void main(String[] args) {
		Solution s = new Solution();
	}
}
class Solution{
	public Solution() {
		Scanner scan = new Scanner(System.in);
		int m = scan.nextInt();
		int n = scan.nextInt();
		scan.nextLine();
		String[] window = new String[n+1];
		int idx = 0;
		for(int i=0;i<window.length;i++) {
			window[i] = "";
		}
		int[] answer = new int[5];
		for(int i=0;i<m*5+1;i++) {
			String str = scan.nextLine();
			if(str.contains("*") || str.contains(".")) {
				for(int j=1;j<5*n+1;j+=5) {
					window[idx]+=str.charAt(j);
					idx++;
				}
				idx -=n;
			}
			else {
				for(int j=0;j<window.length;j++) {
					if(window[j].equals("....")) {
						answer[0]++;
					}
					else if(window[j].equals("*...")) {
						answer[1]++;
					}
					else if(window[j].equals("**..")) {
						answer[2]++;
					}
					else if(window[j].equals("***.")) {
						answer[3]++;
					}
					else if(window[j].equals("****")){
						answer[4]++;
					}
					window[j] = "";
				}
				idx = 0;
			}
		}
		for(int i : answer) {
			System.out.print(i+" ");
		}
	}
}