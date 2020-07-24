/*
 * KAKAO2020 괄호 변환
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
		if(input.equals("")) { // 빈 문자열이면 리턴
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
				if(cnt==0) { // 균형잡힌 괄호문자열이 나왔다
					u = input.substring(0,i+1); // u를 만들어주고
					if(!check(u)) { // u가 올바른 괄호 문자열이 아니면 작업실행
						String temp = "(";
						temp += solution(input.substring(i+1,input.length())); //v에 대해 재귀적수행
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
						return temp; // 문자열반환
					}
					u+=solution(input.substring(i+1,input.length())); //올바른 괄호문자열 이어붙이기
					break; // 작업이 끝났으므로 break
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
			if(cnt<0) { // 닫는괄호가 여는괄호보다 1개라도 먼저나올경우 )( 이런형태가 되므로 올바르지 않은 괄호 문자열
				return false;
			}
		}
		return true;
	}
}