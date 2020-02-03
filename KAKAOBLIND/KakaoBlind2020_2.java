/*
 * KAKAO2020 ��ȣ ��ȯ
 * 2020.02.03
 * Hyeonseong 
 */
import java.util.*;	
public class KakaoBlind2020_2 {
	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.solution("()))((()"));
	}
}
class Solution{
	public String solution(String input) {
		if(input.equals("")) { // �� ���ڿ��̸� ����
			return "";
		}
		else {
			int cnt = 0;
			String u = "";
			for(int i=0;i<input.length();i++) {
				if(input.charAt(i)=='(') {
					cnt++;
				} else {
					cnt--;
				}
				if(cnt==0) { // �������� ��ȣ���ڿ��� ���Դ�
					u = input.substring(0,i+1); // u�� ������ְ�
					if(!check(u)) { // u�� �ùٸ� ��ȣ ���ڿ��� �ƴϸ� �۾�����
						String temp = "(";
						temp += solution(input.substring(i+1,input.length())); //v�� ���� ���������
						temp += ")";					
						String temp2 = "";
						for(int j=1;j<u.length()-1;j++) {
							if(u.charAt(j)=='(') {
								temp2+=')';
							} else {
								temp2+='(';
							}
						}
						temp+=temp2;
						return temp; // ���ڿ���ȯ
					}
					u+=solution(input.substring(i+1,input.length())); //�ùٸ� ��ȣ���ڿ� �̾���̱�
					break; // �۾��� �������Ƿ� break
				}
			}
			return u;
		}
	}
	public boolean check(String u) {
		int cnt = 0;
		for(int i=0;i<u.length();i++) {
			if(u.charAt(i)=='(') {
				cnt++;
			} else {
				cnt--;
			}
			if(cnt<0) { // �ݴ°�ȣ�� ���°�ȣ���� 1���� �������ð�� )( �̷����°� �ǹǷ� �ùٸ��� ���� ��ȣ ���ڿ�
				return false;
			}
		}
		return true;
	}
}