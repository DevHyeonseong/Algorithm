import java.util.*;
/*
 * BOJ 9012
 * 2020.01.15
 * Hyeonseong
 */
public class BOJ9012 {

	public static void main(String[] args) {
		Solution s = new Solution();
		s.solution();
		System.out.println();
	}
}
class Solution{
	
	int n; // 테스트케이스 수
	ArrayList<String> answer; // 정답
	Solution(){
		answer = new ArrayList<String>();
	}
	public void solution() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		scan.nextLine();
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<n;i++) {
			String str = scan.nextLine(); // 괄호문자열을 입력받고
			for(int j=0;j<str.length();j++) {
				if(str.charAt(j)=='(') { // 열린괄호면
					stack.push(str.charAt(j)); // 스택에 넣어준다
				}
				else {
					if(!stack.isEmpty()) { // 스택이비어있지않으면 열린괄호열이 들어있는것
						stack.pop(); // 빼버리고
					}
					else { // 스택이 비어있는데 닫힌괄호가들어오면 올바르지 않은 괄호
						stack.push(')'); // 마지막 확인작업을 위해 추가하고
						break; // 시간절약을 위한 break
					}
				}
			}
			if(stack.isEmpty()) { // 스택이 비어있다면
				answer.add("YES"); // 올바른괄호
			}
			else {
				answer.add("NO"); 
			}
			stack.clear(); // 다음 테스트케이스를위해 스택 정리
		}
		for(String s : answer) {
			System.out.println(s);
		}
	}
}

