import java.util.*;

public class zoo	{

	public static void main(String[] args)	{
	
		Scanner sc = new Scanner(System.in);
		int animals;
		String oneAnimal = new String();
		String[] words;
		String theAnimal;
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		int value;
		int k = 1;
		
		while (sc.hasNext())	{
			
			animals = sc.nextInt();
			if (animals == 0)	{
				System.exit(0);
			}
			for (int i = 0; i<animals; i++)	{
				if (i == 0)	{
					sc.nextLine();
				}
				oneAnimal = sc.nextLine();
				
				words = oneAnimal.split(" ");
				theAnimal = words[words.length-1];
				theAnimal = theAnimal.toLowerCase();
				
				if(map.containsKey(theAnimal))	{
					value = map.get(theAnimal);
					value++;
					map.replace(theAnimal, value);
				}
				else	{
					map.put(theAnimal, 1);
				}
			}

			System.out.println("List " + k + ":");
			map.forEach((key, v) ->	{
			System.out.println(key + " | " + v);
				
			});
			map = new TreeMap<String, Integer>();
			k++;
			
			
		}
	
	}



}