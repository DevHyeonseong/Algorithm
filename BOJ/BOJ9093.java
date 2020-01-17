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
	
	int n; // 테스트케이스 수
	ArrayList<String> list; // 입력받는 문장
	ArrayList<String> answer; // 정답
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
			String[] str = list.get(i).split(" "); // 공백을 기준으로 단어를 자른다
			StringBuilder revStr = new StringBuilder();
			for(int j=0;j<str.length;j++) {
				revStr.append(new StringBuilder(str[j]).reverse()+" "); // 뒤집어서 붙인다
			}
			answer.add(revStr.toString().trim()); // 앞뒤공백제거
		}
		for(String s : answer) {
			System.out.println(s); // 출력
		}
	}
}

