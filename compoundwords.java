// V00819384 Karamanian, Nicolaus

import java.util.*;

public class compoundwords	{

	public static void main(String[] args)	{
		
		Scanner sc = new Scanner(System.in);
		
		int n = 0;
		String[] array;
		TreeSet<String> result = new TreeSet<String>();
		String compoundString;
		LinkedList<String> list = new LinkedList<String>();
		
		while (sc.hasNext())	{
			list.add(sc.next());
		}
		
		String[] words = new String[list.size()];
		
		
		for (String s : list)	{
			words[n] = s;
			n++;
		}
		
		
		for (int i = 0; i < list.size(); i++)	{
			
			for (int j = 0; j < list.size(); j++)	{
				if (i != j)	{
					compoundString = words[i] + "" + words[j];
					result.add(compoundString);
				}
				
			}
			
		}
		
		for (String s : result)	{
			System.out.println(s);
		}
		
	}
	
}