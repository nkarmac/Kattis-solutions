import java.util.*;

public class oddmanout	{

	public static void main(String[] args)	{

		Scanner sc = new Scanner(System.in);
		HashMap<Integer, Boolean> list;
		int guests;
		int id;
		
		int cases = sc.nextInt();
		
		for (int i = 1; i < cases+1; i++)	{
			
			System.out.print("Case #" + i + ": ");
			
			list = new HashMap<Integer, Boolean>();
			
			guests = sc.nextInt();
			for (int j = 0; j < guests; j++)	{
				id = sc.nextInt();
				if (list.containsKey(id))	{
					list.replace(id, true);
				}
				else	{
				list.put(id, false);
				}
			}
			
			list.forEach((key, value) ->	{
				if (value == false)	{
					System.out.println(key);
				}
				
			});
			
			
		}

	
	}

}