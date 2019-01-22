import java.util.*;

public class towering	{

	public static void main(String[] args)	{
		
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> list = new PriorityQueue<Integer>(6, Collections.reverseOrder());
		int[] boxes = new int[6];
		int n = 0;
		LinkedList<Integer> result1 = new LinkedList<Integer>();
		LinkedList<Integer> result2 = new LinkedList<Integer>();
		
		for(int i = 0; i < 6; i++)	{
			list.add(sc.nextInt());
		}
		
		int h1 = sc.nextInt();
		int h2 = sc.nextInt();
		
		for (int x : list)	{
			boxes[n] = x;
			n++;
		}
		
		for (int i = 0; i < 6; i++)	{
			for (int j = 0; j < 6; j++)	{
				if (j==i)	{
					continue;
				}
				for (int k = 0; k < 6; k++)	{
					if (k == i || k == j)	{
						continue;
					}
					if ((boxes[i] + boxes[j] + boxes[k]) == h1)	{
						if (boxes[i] >= boxes[j])	{
							if (boxes[j] >= boxes[k])	{
								result1.add(boxes[i]);
								result1.add(boxes[j]);
								result1.add(boxes[k]);
							}
						}
					}
					else if ((boxes[i] + boxes[j] + boxes[k]) == h2)	{
						if (boxes[i] >= boxes[j])	{
							if (boxes[j] >= boxes[k])	{
								result2.add(boxes[i]);
								result2.add(boxes[j]);
								result2.add(boxes[k]);
							}
						}
					}
				}
			}
		}
		
		boolean first = false;
		for (int x : result1)	{
			if (first == false)	{
				System.out.print(x);
				first = true;
				continue;
			}
			System.out.print(" " + x);
		}
		for (int x : result2)	{
			System.out.print(" " + x);
		}
		
		System.out.println();
		
		
	}
	
}