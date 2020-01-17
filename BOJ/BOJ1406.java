/*
 * BOJ 1406
 * 2020.01.15
 * Hyeonseong
 */
import java.util.*;
public class BOJ1406 {
	public static void main(String[] args) {
		Solution s = new Solution();
	}
}
class Solution{
	String str; // 초기에 입력되는 문자열
	int m; // 입력되는 명령어의 수 
	Solution(){
		Scanner scan = new Scanner(System.in);
		str = scan.nextLine();
		m = scan.nextInt();
		scan.nextLine();
		
		Stack<Character> left = new Stack<Character>();
		Stack<Character> right = new Stack<Character>();
		
		for(int i=0;i<str.length();i++) {
			left.push(str.charAt(i));
		}
		for(int i=0;i<m;i++) {
			String com = scan.next();
			if(com.equals("L")) {
				if(!left.isEmpty()) {
					right.push(left.pop());
				}
			}
			else if(com.equals("D")) {
				if(!right.isEmpty()) {
					left.push(right.pop());
				}
			}
			else if(com.equals("B")) {
				if(!left.isEmpty()) {
					left.pop();
				}
			}
			else {
				String word = scan.next();
				left.push(word.charAt(0));
			}
		}
		StringBuilder sb = new StringBuilder();
		for(char a : left) {
			sb.append(a);
		}
		while(!right.isEmpty()) {
			sb.append(right.pop());
		}
		System.out.println(sb.toString());
	}
}

