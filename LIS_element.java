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
		
		int[] lisLen = new int[n]; // �������������� ���̸� ��¹迭
		int idx = 0;
		lisLen[0] = array[0]; 
		
		int[][] lis = new int[n][2]; // ��� ������ �迭
		lis[0][0] = 0;
		lis[0][1] = array[0];
		// ���̱��ϱ�
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
		// ������ ����
		int max = Integer.MIN_VALUE;
		int maxidx = 0;
		for(int i=0;i<lis.length;i++) // ���̰� ����涧�� ��� ���ϱ�
		{
			if(max<lis[i][0])
			{
				max = lis[i][0];
				maxidx = i;
			}
		}
		//������
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

