import java.util.ArrayList;

public class KakaoBlind2018_1{
    public static void main(String[] args) {
        Solution s = new Solution();

        String str1 = "FRANCE";
        String str2 = "french";
        System.out.println(s.solution(str1, str2));

    }
}

class Solution {
    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        if(str1.equals(str2)){
            return 65536;
        }
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        makeList(list1,str1);
        makeList(list2,str2);

        // 교집합
        double sameNum = 0; // 교집합 원소 수
        for(int i=0;i<list1.size();i++){
            for(int j=0;j<list2.size();j++){
                if(list1.get(i).equals(list2.get(j))){
                /* list1과 list2중에서 같은 원소가 있다면
                그 원소를 제거하고(원소의 중복을 허용하는 다중집합 확장을위해) 교집합 개수를 1추가한다
                */
                    sameNum++;
                    list2.remove(j);
                    break;
                }
            }
        }

        double sumNum = list1.size()+list2.size(); //합집합 원소 수 원래 교집합 개수를 빼줘야 하지만 다중집합 확장을 위해 미리 제거했으므로 안빼줘도 된다.
        double answer = (sameNum/sumNum)*65536;

        return (int)answer;
    }

    public void makeList(ArrayList<String> list, String str){
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<str.length();i++){
            sb.append(str.charAt(i));
            cnt++;
            if(cnt==2){
                for(int j=0;j<2;j++){
                    if(!Character.isAlphabetic(sb.charAt(j))){ // 만약 알파벳이 아니면 버린다
                        break;
                    }
                    if(j==1){ // 알파벳만 포함되어 있다면 list에 추가
                        list.add(sb.toString());
                    }
                }
                sb = new StringBuilder();
                cnt = 0;
                i--;
            }
        }
    }
}
