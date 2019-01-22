import java.util.*;

public class functionalfun	{

	public static void main(String[] args)	{
		
		// initializing variables
		Scanner sc = new Scanner(System.in);
		String line;
		String[] words;
		int n;
		HashMap<String, Boolean> domain;
		HashMap<String, Boolean> coDomain;
		boolean function;
		boolean injective;
		boolean surjective;
		int count1;
		int count2;
		
		while(sc.hasNext())	{
			
			// initializing current case variables
			domain = new HashMap<String, Boolean>();
			coDomain = new HashMap<String, Boolean>();
			function = true;
			injective = false;
			surjective = false;
			
			// putting domain into hashmap
			line = sc.nextLine();
			words = line.split(" ");
			if (words.length < 2)	{
				continue;
			}
			for(int i = 1; i < words.length; i++)	{
				domain.put(words[i], false);
			}
			
			// putting codomain into hashmap
			line = sc.nextLine();
			words = line.split(" ");
			if (words.length < 2)	{
				continue;
			}
			for(int i = 1; i < words.length; i++)	{
				coDomain.put(words[i], false);
			}
			
			// reading n and following domain and codomain pairings
			n = sc.nextInt();
			sc.nextLine();
			if (n == 0)	{
				continue;
			}
			for (int i = 0; i < n; i++)	{
				
				line = sc.nextLine();
				words = line.split(" ");
				
				for (int j = 0; j < words.length; j++)	{
					if (j == 0)	{
						// if a domain value has already been mapped once, than any more mappings makes it not a function
						if (domain.get(words[j]) == true)	{
							function = false;
						}
						else{
							domain.replace(words[j], true);
						}
					}
					if (j == 2)	{
						coDomain.replace(words[j], true);
					}
				}
			}
			
			// counting how many values from domain and codomain were used in function
			count1 = 0;
			count2 = 0;
			for(Boolean x : domain.values())	{
				if(x)	{
					count1++;
				}
			}
			for(Boolean x : coDomain.values())	{
				if(x)	{
					count2++;
				}
			}
			
			// 1 to 1
			if (count1 == count2)	{
				injective = true;
			}
			// onto
			if (count2 == coDomain.size())	{
				surjective = true;
			}
			
			// printing cases
			if (!function)	{
				System.out.println("not a function");
			}
			else if(injective && surjective)	{
				System.out.println("bijective");
			}
			else if(injective && !surjective)	{
				System.out.println("injective");
			}
			else if(!injective && surjective)	{
				System.out.println("surjective");
			}
			else	{
				System.out.println("neither injective nor surjective");
			}
		}
	}
}