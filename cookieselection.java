import java.util.*;

public class cookieselection	{

	public static void main(String[] args)	{
	
		// initializing variables
		Scanner sc = new Scanner(System.in);
		// min heap
		PriorityQueue<Integer> cookies1 = new PriorityQueue<Integer>();
		// max heap
		PriorityQueue<Integer> cookies2 = new PriorityQueue<Integer>(11, Collections.reverseOrder());
		int numCookies = 0;
		int currentCookie;
		String line;
		int medianCookie;
		
		// scanning for next character...
		while (sc.hasNext())	{
			line = sc.nextLine();
			
			
			if (line.equals("#"))	{
				// if there are no cookies, continue
				if (numCookies == 0)	{
					continue;
				}
				// checks if median is at top of max heap
				if (( cookies2.size() - cookies1.size() ) == 1)	{
					medianCookie = cookies2.poll();
				}
				// else it is at top of min heap
				else	{
					medianCookie = cookies1.poll();
				}			
				// prints median cookie
				System.out.print(medianCookie);
				numCookies--;
				if (sc.hasNext())	{
					System.out.println();
				}
				continue;
			}
			
			
			// converting the line to an int
			currentCookie = Integer.parseInt(line);
			
			// first case
			if (numCookies == 0)	{
				cookies1.add(currentCookie);
				numCookies++;
				continue;
			}
			
			// taking median from correct heap
			if (( cookies2.size() - cookies1.size() ) == 1)	{
				medianCookie = cookies2.peek();
			}
			else	{
				medianCookie = cookies1.peek();
			}
			
			// adding cookie to correct heap
			if (currentCookie >= medianCookie)	{
				cookies1.add(currentCookie);
			}
			else{
				cookies2.add(currentCookie);
			}
			
			// readjusting heaps
			if (cookies1.size() - cookies2.size() > 1)	{
				currentCookie = cookies1.poll();
				cookies2.add(currentCookie);
			}
			if (cookies2.size() - cookies1.size() > 1)	{
				currentCookie = cookies2.poll();
				cookies1.add(currentCookie);
			}
			
			numCookies++;
		}
	}
}