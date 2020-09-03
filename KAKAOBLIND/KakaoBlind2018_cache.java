import java.util.*;
public class KakaoBlind2018_cache {
    public static void main(String[] args) {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        System.out.println(new Solution().solution(cacheSize, cities));
    }

}

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize==0){
            return 5*cities.length;
        }

        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        int idx = 0;
        for(int i=0;i<cities.length;i++){
            String str = cities[i].toLowerCase();
            if(map.containsKey(str)){ // cache hit
                map.put(str, idx);
                idx++;
                answer += 1;
            } else { // cache miss
                if(map.size()<cacheSize){ // cache 공간이 남은 경우
                    map.put(str,idx);
                    idx++;
                    answer += 5;
                } else { // cache 공간이 남지 않은 경우 LRU 실행
                    Iterator<String> it = map.keySet().iterator();
                    String removeData = "";
                    int min = Integer.MAX_VALUE;
                    while(it.hasNext()){
                        String temp = it.next();
                        // idx 값이 작을 수록 나온지 오래된 캐시 데이터
                        if(min >= map.get(temp)){
                            min = map.get(temp);
                            removeData = temp;
                        }
                    }
                    map.remove(removeData);
                    map.put(str,idx);
                    idx++;
                    answer += 5;
                }
            }
        }
        return answer;
    }
}
