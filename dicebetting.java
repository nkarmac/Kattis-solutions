import java.util.*;
import java.io.*;

public class dicebetting {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  static int n, s, k;
  static Double[][] memo;

  public static void main(String[] args) throws IOException {

    // Read input
    String[] line = br.readLine().split(" ");
    n = Integer.valueOf(line[0]);
    s = Integer.valueOf(line[1]);
    k = Integer.valueOf(line[2]);

    // Compute and output the probability
    memo = new Double[n + 1][s + 1];
    System.out.println(calculate(n, 0));

  }

  // Calculate the probability recursively using memoization
  static double calculate(int nThrowsLeft, int nNumbersSeen) {

    // Seen enough numbers
    if (nNumbersSeen >= k)
      return 1.0;

    // No throws left
    if (nThrowsLeft == 0)
      return 0.0;

    // Check to see if this sub-problem has already been solved
    if (memo[nThrowsLeft][nNumbersSeen] != null)
      return memo[nThrowsLeft][nNumbersSeen];

    double probabilityOfOldNumber = (double) nNumbersSeen / (double) s;
    double probabilityOfNewNumber = 1.0 - probabilityOfOldNumber;

    // Compute probability
    double probability = probabilityOfOldNumber * calculate(nThrowsLeft - 1, nNumbersSeen) + probabilityOfNewNumber * calculate(nThrowsLeft - 1, nNumbersSeen + 1);

    // Store and return result
    return memo[nThrowsLeft][nNumbersSeen] = probability;

  }

}