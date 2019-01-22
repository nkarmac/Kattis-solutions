// V00819384 Karamanian, Nicolaus

// importing scanner
import java.util.*;

public class kitten	{

	public static void main (String[] args)	{
		
		// initializing variables
		int[] parent = new int[101];
		String line;
		String[] numbers;
		int[] realNums = new int[101];
		int currentNode = -1;
		int rootNode = -1;
		boolean rootNodeFound = false;
		Scanner sc = new Scanner(System.in);
		
		// the branch that the kitty is on
		int kitty = sc.nextInt();
		
		
		while (sc.hasNext())	{
			// scans the whole line
			line = sc.nextLine();
			if (line.equals(""))	{
				continue;
			}
			// splits the line into an array of branches (still in string form)
			numbers = line.split(" ");
	
			for (int i = 0; i < numbers.length; i++)	{
				// converts each element into an int and stores it into an int array
				realNums[i] = Integer.parseInt(numbers[i]);
				// exit case
				if (realNums[i] == -1)	{
					break;
				}
				// uses the first given value as the root (after the kitty value)
				if (rootNodeFound == false)	{
					rootNode = realNums[0];
					parent[rootNode] = rootNode;
					rootNodeFound = true;
				}
				// stores the parent of each branch (the parent is always the first int
				// of each line, hence why i > 0
				if (i > 0)	{
					parent[realNums[i]] = realNums[0];
				}
			}
		}
		
		// traverses and prints from the kitty to the root using the parent array
		currentNode = kitty;
		while (currentNode != rootNode)	{
			System.out.print(currentNode + " ");
			currentNode = parent[currentNode];
		}
		System.out.print(rootNode);
		
		
	}


}