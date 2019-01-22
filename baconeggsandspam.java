// importing Scanner, TreeMap, and TreeSet
import java.util.*;

public class baconeggsandspam	{	

	public static void main (String[] args)	{
		
		// initializing variables
		Scanner sc = new Scanner(System.in);
		TreeMap<String, TreeSet<String>> map;
		TreeSet<String> set;
		String line;
		String[] words;
		
		// getting first customer reading
		int customers = sc.nextInt();
		
		while (sc.hasNext())	{
			
			// creating new map for each day
			map = new TreeMap<String, TreeSet<String>>();
			
			while (customers >= 0)	{
				
				// reading line and splitting
				line = sc.nextLine();
				words = line.split(" ");
				
				for (int i = 1; i < words.length; i++)	{
					// creating new node if current food not created
					if (map.get(words[i]) == null)	{
						// creating new set to act as new node value
						set = new TreeSet<String>();
						set.add(words[0]);
						// adding customer name to food type
						map.put(words[i], set);
					}
					else	{
						// retrieving node values
						TreeSet<String> temp = map.get(words[i]);
						temp.add(words[0]);
						// adding customer name to existing customers for food node
						map.put(words[i], temp);
					}
				}
				customers--;
			}
			
			// printing method using 2 iterators (1 along set for each 1 along map)
			if (map.size() > 0)	{
				map.forEach((key, value) -> {
					Iterator<String> itr = value.iterator();
					System.out.print(key);
					while(itr.hasNext())	{
						System.out.print(" " + itr.next());
					}
					System.out.println();
				});
			}
			
			// extra line to divide days
			if (sc.hasNext())	{
				System.out.println();
			}
			
			// next day's customer number reading
			customers = sc.nextInt();
			if (customers == 0)	{
				break;
			}
			
		}
	}
}