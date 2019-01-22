import java.util.*;

public class coloring	{
	
	public static void main(String[] args)	{
		
		// defining scanning variables
		Scanner sc = new Scanner(System.in);
		String temp;
		String words[];
		int tempNum;
		
		// scanning # of verts
		int n = sc.nextInt();
		sc.nextLine();
		
		// creating graph and color array
		boolean[][] graph = new boolean[n][n];
		int[] color = new int[n];
		
		// filling graph
		for (int i = 0; i < n; i++)	{
			temp = sc.nextLine();
			words = temp.split(" ");
			for (String x : words)	{
				tempNum = Integer.parseInt(x);
				graph[i][tempNum] = true;
				graph[tempNum][i] = true;
			}
		}
		
		int result = solve(graph, color, 0, 1);
		
		System.out.println(result);
		
	}
	
	// recursive coloring function (backtracking)
	static int solve(boolean[][] graph, int[] color, int v, int next)	{
		
		// base case (graph is done being traversed)
		if (v == graph.length)	{
			return 0;
		}
		
		// the minimum # of colors
		int maxColor = Integer.MAX_VALUE;
		
		// trying existing colors
		outerLoop: for (int i = 1; i < next; i++)	{
			
			// skipping a node if adjacent node has this color
			for (int j = 0; j < v; j++)	{
				if (graph[v][j] && color[j] == i)	{
					continue outerLoop;
				}
			}
			
			// try current color
			color[v] = i;
			maxColor = Math.min(maxColor, solve(graph, color, v+1, next));
		}
		
		// try new color
		color[v] = next;
		maxColor = Math.min(maxColor, 1 + solve(graph, color, v+1, next+1));
		
		return maxColor;
		
	}
	
}