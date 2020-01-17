import java.util.*;
public class LIS_length
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
		
		int[] ans = new int[n];
		int idx = 0;
		ans[0] = array[0];
		
		for(int i=1;i<n;i++)
		{
			if(ans[idx]<array[i])
			{
				idx++;
				ans[idx] = array[i];
			}
			else
			{
				int start = 0;
				int end = idx;
				int mid;
				while(end>start)
				{
					mid = (start+end) /2;
					if(ans[mid] < array[i])
					{
						start = mid+1;
					}
					else
					{
						end = mid;
					}
				}
				ans[end] = array[i];
			}
		}
		System.out.println(idx+1);
	}
}
