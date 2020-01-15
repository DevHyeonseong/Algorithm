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
	
	int n; // �׽�Ʈ���̽� ��
	ArrayList<String> answer; // ����
	Solution(){
		answer = new ArrayList<String>();
	}
	public void solution() {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		scan.nextLine();
		Stack<Character> stack = new Stack<Character>();
		for(int i=0;i<n;i++) {
			String str = scan.nextLine(); // ��ȣ���ڿ��� �Է¹ް�
			for(int j=0;j<str.length();j++) {
				if(str.charAt(j)=='(') { // ������ȣ��
					stack.push(str.charAt(j)); // ���ÿ� �־��ش�
				}
				else {
					if(!stack.isEmpty()) { // �����̺������������ ������ȣ���� ����ִ°�
						stack.pop(); // ��������
					}
					else { // ������ ����ִµ� ������ȣ�������� �ùٸ��� ���� ��ȣ
						stack.push(')'); // ������ Ȯ���۾��� ���� �߰��ϰ�
						break; // �ð������� ���� break
					}
				}
			}
			if(stack.isEmpty()) { // ������ ����ִٸ�
				answer.add("YES"); // �ùٸ���ȣ
			}
			else {
				answer.add("NO"); 
			}
			stack.clear(); // ���� �׽�Ʈ���̽������� ���� ����
		}
		for(String s : answer) {
			System.out.println(s);
		}
	}
}

