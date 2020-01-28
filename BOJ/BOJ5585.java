/*
 * BOJ5585
 * 2020.01.18
 * Hyeonseong
 */
import java.util.*;
public class BOJ5585
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int spare[] = new int[6];
		spare[0] = 500;
		spare[1] = 100;
		spare[2] = 50;
		spare[3] = 10;
		spare[4] = 5;
		spare[5] = 1;
		
		int money = 1000-scan.nextInt();
		int cnt = 0;
		for(int i=0;i<6;i++)
		{
			cnt+=money/spare[i];
			money = money % spare[i];
		}
		System.out.println(cnt);
	}
}