// V00819384 Karamanian, Nicolaus

import java.util.*;

public class bishops	{
	
	
	public static void main(String[] args)	{
		
		Scanner sc = new Scanner(System.in);
		int n;
		int result;
		
		while (sc.hasNext())	{
			
			n = sc.nextInt();
			if (n < 0)	{
				continue;
			}
			if (n == 0)	{
				System.out.print("0");
				if (sc.hasNext())	{
					System.out.println();
				}
				continue;
			}
			if (n == 1)	{
				System.out.print("1");
				if (sc.hasNext())	{
					System.out.println();
				}
				continue;
			}
			
			
			
			result = 2*n - 2;
			System.out.print(result);
			if (sc.hasNext())	{
				System.out.println();
			}
		}
		
	}
	
}