import java.util.ArrayList;

public class KakaoBlind2020_1{
    public static void main(String[] args) {
        Solution s = new Solution();

        String str ="aabbaccc";
        System.out.println(s.solution(str));

    }
}

class Solution {
    public int solution(String str) {
        int answer = Integer.MAX_VALUE;

        if(str.length()==1){
            return 1;
        }

        for(int i=1;i<=str.length()/2;i++){
            int tempAnswer = 0;
            int cnt = 0;
            int num = 1;
            StringBuilder preSb = new StringBuilder();
            for(int j=0;j<str.length();j++){
                if(cnt!=i){ // 압축 개수가 아니면
                    preSb.append(str.charAt(j));
                    cnt++;
                    if(cnt==i){ // 압축 개수 도달
                        StringBuilder postSb = new StringBuilder();
                        int idx = j+1;
                        for(int p=0;p<cnt && idx<str.length();p++){ // 압축 개수 만큼 문자열 생성
                            postSb.append(str.charAt(idx));
                            idx++;
                        }

                        if(preSb.toString().equals(postSb.toString())){ // 같으면 압축개수+1, temp 유지
                            num++;
                            preSb = new StringBuilder();
                        } else { // 다르면 더해줌
                            if(num==1){
                                tempAnswer += preSb.length();
                                preSb = new StringBuilder();
                            } else {
                                tempAnswer += Integer.toString(num).length()+cnt;
                                preSb = new StringBuilder();
                                num = 1;
                            }
                        }
                        cnt = 0;
                    }
                }
                if(j==str.length()-1){
                    tempAnswer += cnt;
                }
            }
            if(answer > tempAnswer){
                answer = tempAnswer;
            }
        }

        return answer;
    }
}