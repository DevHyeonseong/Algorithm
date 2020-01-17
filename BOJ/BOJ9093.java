import java.util.*;
/*
 * BOJ 9093
 * 2020.01.15
 * Hyeonseong
 */
public class BOJ9093 {

	public static void main(String[] args) {
		Solution s = new Solution();
		s.solution();
	}
}
class Solution{
	
	int n; // �׽�Ʈ���̽� ��
	ArrayList<String> list; // �Է¹޴� ����
	ArrayList<String> answer; // ����
	Solution(){
		Scanner scan = new Scanner(System.in);
		list = new ArrayList<String>();
		answer = new ArrayList<String>();
		n = scan.nextInt();
		scan.nextLine();
		for(int i=0;i<n;i++) {
			list.add(scan.nextLine());
		}
	}
	public void solution() {
		for(int i=0;i<list.size();i++) {
			String[] str = list.get(i).split(" "); // ������ �������� �ܾ �ڸ���
			StringBuilder revStr = new StringBuilder();
			for(int j=0;j<str.length;j++) {
				revStr.append(new StringBuilder(str[j]).reverse()+" "); // ����� ���δ�
			}
			answer.add(revStr.toString().trim()); // �յڰ�������
		}
		for(String s : answer) {
			System.out.println(s); // ���
		}
	}
}

