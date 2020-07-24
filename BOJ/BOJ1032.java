/**
 * 2020.07.24
 * 백준 1032 : 명령 프롬프트
 * DevHyeonseong
 */
import java.util.Scanner;
public class BOJ1032 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int len = scan.nextInt();
        scan.nextLine();

        String[] words = new String[len];
        for (int i = 0; i < words.length; i++) {
            words[i] = scan.nextLine();
        }

        boolean[] answer = new boolean[words[0].length()];

        for (int i = 0; i < words[0].length(); i++) {
            for (int j = 0; j < words.length; j++) {
                if (j == words.length - 1) { // 인덱스를 넘어갈 수 있으므로 break 해준다
                    break;
                }
                if (words[j].charAt(i) != words[j + 1].charAt(i)) { // 하나라도 다른게 있다면 체크해주고 break
                    answer[i] = true;
                    break;
                }
            }
        }

        for (int i = 0; i < words[0].length(); i++) {
            if (answer[i]) { // 다른 파일과 이름이 다른 것
                System.out.print("?");
            } else {
                System.out.print(words[0].charAt(i));
            }
        }
    }
}
