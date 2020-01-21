/*
 * BOJ9935
 * 2020.01.21
 * Hyeonseong
 */
import java.util.*;
public class BOJ9935 {

	public static void main(String[] args) {
		Solution s = new Solution();
	}
}
class Solution{

	public Solution() {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		String bomb = scan.next();
		Stack<Character> stack1 = new Stack<Character>();
		Stack<Character> stack2 = new Stack<Character>();
		for(int i=0;i<str.length();i++) {
			stack1.push(str.charAt(i));
		}
		int idx = 0;
		while(!stack1.isEmpty()) {
			stack2.push(stack1.pop());
			if(stack2.peek()==bomb.charAt(bomb.length()-(idx+1))) {
				idx++;
			}
			else {
				idx = 0;
				if(stack2.peek()==bomb.charAt(bomb.length()-(idx+1))) {
					idx++;
				}
			}
			if(idx==bomb.length()) {
				for(int i=0;i<bomb.length();i++) {
					stack2.pop();
				}
				for(int i=0;i<bomb.length();i++) {
					if(!stack2.isEmpty()) {
						stack1.push(stack2.pop());
					}
					else {
						break;
					}
				}
				idx = 0;
			}
		}
		if(stack2.isEmpty()) {
			System.out.println("FRULA");
		}
		else {
			StringBuilder sb = new StringBuilder();
			while(!stack2.isEmpty()) {
				sb.append(stack2.pop());
			}
			System.out.println(sb.toString());
		}
	}
}
