import java.util.*;
public class LIS_element 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] array = new int[n];
		for(int i=0;i<n;i++)
		{
			array[i] = scan.nextInt();
		}
		
		int[] lisLen = new int[n]; // 최장증가수열의 길이를 담는배열
		int idx = 0;
		lisLen[0] = array[0]; 
		
		int[][] lis = new int[n][2]; // 요소 역추적 배열
		lis[0][0] = 0;
		lis[0][1] = array[0];
		// 길이구하기
		for(int i=1;i<n;i++)
		{
			if(lisLen[idx]<array[i])
			{
				idx++;
				lisLen[idx] = array[i];
				lis[i][0] = idx;
				lis[i][1] = array[i];
			}
			else
			{
				int start = 0;
				int end = idx;
				int mid;
				while(end>start)
				{
					mid = (start+end) /2;
					if(lisLen[mid] < array[i])
					{
						start = mid+1;
					}
					else
					{
						end = mid;
					}
				}
				lisLen[end] = array[i];
				lis[i][0] = end;
				lis[i][1] = array[i];
			}
		}
		// 역추적 시작
		int max = Integer.MIN_VALUE;
		int maxidx = 0;
		for(int i=0;i<lis.length;i++) // 길이가 가장길때의 요소 구하기
		{
			if(max<lis[i][0])
			{
				max = lis[i][0];
				maxidx = i;
			}
		}
		//역추적
		Stack<Integer> ans = new Stack<Integer>();
		ans.push(lis[maxidx][1]);
		for(int i=maxidx;i>=0;i--)
		{
			if(lis[i][0]==max-1)
			{
				max = lis[i][0];
				ans.push(lis[i][1]);
			}
		}
		while(!ans.isEmpty())
		{
			System.out.print(ans.pop()+" ");
		}

	}
}

