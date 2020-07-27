/**
 * 2020.07.27
 * 백준 1011 :Fly me to the Alpha Centauri
 * DevHyeonseong
 */
import java.math.BigDecimal;
import java.util.*;
public class BOJ1011 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long t = scan.nextLong();

        while(t-->0){
            long x = scan.nextLong();
            long y = scan.nextLong();

            long distance = y-x;
            long answer = 0;
            long cnt = 0;
            for(long i=1;answer<distance;i++){
                answer+=i;
                cnt++;
                if(answer>=distance){
                    break;
                }
                answer+=i;
                cnt++;
            }
            System.out.println(cnt);
        }
    }
}

/**
 * 1 -> 1 / 1번
 * 2 -> 11 / 2번
 * 3 -> 111 / 3번
 * 4 -> 121 / 3번
 * 5 -> 1211 / 4번
 * 6 -> 1221 / 4번
 * 7 -> 12211 / 5번
 * 8 -> 12221 / 5번
 * 9 -> 12321 / 5번
 * 10 -> 123211 / 6번
 * 13 -> 7번
 * 17 -> 8번
 * 1 -> 2-> 3-> 5 -> 7 -> 10 -> 13 > 17
 */