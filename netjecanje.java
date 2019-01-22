import java.util.*;

public class netjecanje	{
	
	public static void main(String[] args)	{
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int s = sc.nextInt();
		int r = sc.nextInt();
		
		TreeSet<Integer> damaged = new TreeSet<Integer>();
		HashSet<Integer> reserved = new HashSet<Integer>();
		HashSet<Integer> remove = new HashSet<Integer>();
		
		
		for (int i = 0; i < s; i++)	{
			damaged.add(sc.nextInt());
		}
		
		for (int i = 0; i < r; i++)	{
			reserved.add(sc.nextInt());
		}
		
		for (Integer x : damaged)	{
			if (reserved.contains(x-1))	{
				remove.add(x);
				reserved.remove(x-1);
			}
			else if (reserved.contains(x+1))	{
				remove.add(x);
				reserved.remove(x+1);
			}
		}
		
		for (Integer x : remove)	{
			
			damaged.remove(x);
			
		}
		System.out.println(damaged.size());
		
	}
	
}