import java.util.*;

public class nodup	{


	public static void main(String[] args)	{
	
		Scanner sc = new Scanner(System.in);
		HashSet<String> set = new HashSet<String>();
		String word;
		
		while (sc.hasNext())	{
			
			word = sc.next();
			if (set.contains(word))	{
				System.out.print("no");
				System.exit(0);
			}
			else	{
				set.add(word);
			}
			
		}
		
		System.out.print("yes");
		
	
	}


}