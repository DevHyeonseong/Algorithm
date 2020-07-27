/**
 * 2020.07.28
 * 백준 6603 : 로또
 * DevHyeonseong
 */
import java.util.*;
public class BOJ6603 {
    public static int[] lotto;
    public static int[] answer;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String input = scan.nextLine();
        while(!input.equals("0")){
            String[] temp = input.split(" ");
            lotto = new int[temp.length-1];
            answer = new int[temp.length-1];

            int k = Integer.parseInt(temp[0]);

            for(int i=1;i<temp.length;i++){
                lotto[i-1] = Integer.parseInt(temp[i]);
            }
            dfs(0,0, k);
            System.out.println();

            input = scan.nextLine();
        }
    }

    public static void dfs(int idx, int depth,int k){
        if(depth==6){
            StringBuilder stringBuilder = new StringBuilder();
            for(int i=0;i<answer.length;i++){
                if(answer[i]==0){
                    break;
                }
                stringBuilder.append(answer[i]+" ");
            }
            System.out.println(stringBuilder.toString().trim());
            return;
        }
        for(int i=idx;i<k;i++){
            answer[depth] = lotto[i];
            dfs(i+1,depth+1,k);
        }
    }
}
