/*
 * BOJ1759
 * 2020.01.21
 * Hyeonseong
 */
import java.util.*;
public class BOJ1759
{
	public static void main(String[] args) 
	{
		Solution s = new Solution();
	}
}
class Solution{
	int n;
	int c;
	public Solution() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		c = scan.nextInt();
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<c;i++) {
			sb.append(scan.next());
		}
		char[] word = sb.toString().toCharArray();
		Arrays.sort(word);
		go(word,"",0);
	}
	public void go(char[] word, String password, int i) {
		if(password.length()==n) {
			if(check(password)) {
				System.out.println(password);
			}
			return;
		}
		if(i>=word.length) {
			return;
		}
		go(word, password+word[i],i+1);
		go(word, password, i+1);
		
	}
	public boolean check(String password) {
		int ja = 0;
		int mo = 0;
		String str = password.toString();
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u') {
				mo++;
			}
			else {
				ja++;
			}
		}
		if(ja>=2 && mo>=1) {
			return true;
		}
		else {
			return false;
		}
	}
}