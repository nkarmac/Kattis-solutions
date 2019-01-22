import java.util.*;

public class kornislav	{
	
	public static void main(String[] args)	{
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		
		queue.add(a);
		queue.add(b);
		queue.add(c);
		queue.add(d);
		
		
		int first, second, third, fourth;
		
		first = queue.poll();
		second = queue.poll();
		third = queue.poll();
		fourth = queue.poll();
		
		
		System.out.println(first*third);
		
		
		
		
	}
	
	
}