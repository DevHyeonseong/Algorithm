/*
 * BOJ1107
 * 2020.01.20
 * Hyeonseong
 */
import java.util.*;
public class BOJ1107
{
	public static void main(String[] args) 
	{
		Solution s = new Solution();
	}
}
class Solution{
	public Solution() {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();
		int[] temp;
		int[] arr; // 살아있는 버튼
		int min = Math.abs(100-n);
		if(n==100) {
			System.out.println(0);
			return;
		}
		if(m==0) {
			int a = Integer.toString(n).length();
			System.out.println(Math.min(min,a));
			return;
		}
		temp = new int[10];
		temp[0] = -1;
		for(int i=0;i<m;i++) {
			int a = scan.nextInt();
			temp[a] = a;
		}
		arr = new int[10-m];
		int idx = 0;
		for(int i=0;i<temp.length;i++) {
			if(i!=temp[i]) {
				arr[idx] = i;
				idx++;
			}
		}
		//1자리수
		for(int i=0;i<arr.length;i++) {
			int a = Math.abs(n-arr[i])+1;
			min = Math.min(min, a);
		}
		//2자리수
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				int a = 10*arr[i]+arr[j];
				a = Math.abs(n-a)+2;
				min = Math.min(min, a);
			}
		}
		//3자리수
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				for(int k=0;k<arr.length;k++) {
					int a = 100*arr[i]+10*arr[j]+arr[k];
					a = Math.abs(n-a)+3;
					min = Math.min(min,a);
				}
			}
		}
		//4자리수
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				for(int k=0;k<arr.length;k++) {
					for(int l=0;l<arr.length;l++) {
						int a = 1000*arr[i]+100*arr[j]+10*arr[k]+arr[l];
						a = Math.abs(n-a)+4;
						min = Math.min(min, a);
					}
				}
			}
		}
		//5자리수
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length;j++) {
				for(int k=0;k<arr.length;k++) {
					for(int l=0;l<arr.length;l++) {
						for(int p=0;p<arr.length;p++) {
							int a = 10000*arr[i]+1000*arr[j]+100*arr[k]+10*arr[l]+arr[p];
							a = Math.abs(n-a)+5;
							min = Math.min(min, a);
						}
					}
				}
			}
		}
		//6자리수
		for(int i=0;i<arr.length;i++) {
				for(int j=0;j<arr.length;j++) {
					for(int k=0;k<arr.length;k++) {
						for(int l=0;l<arr.length;l++) {
							for(int p=0;p<arr.length;p++) {
								for(int q=0;q<arr.length;q++) {
									int a = 100000*arr[i]+10000*arr[j]+1000*arr[k]+100*arr[l]+10*arr[p]+arr[q];
									a = Math.abs(n-a)+6;
									min = Math.min(min, a);	
								}
							}
						}
					}
				}	
			}
		System.out.println(min);
	}
}