import java.util.*;
import java.math.*;

public class insert	{
	
	public static void main(String[] args)	{
		
		Scanner sc = new Scanner(System.in);
		int num;
		
		while(sc.hasNext())	{
			
			num = sc.nextInt();
			if (num == 0)	break;
			
			BST tree = new BST();
			
			for (int i = 0; i < num; i++)	{
				tree.put(sc.nextInt());
			}
			
			System.out.println(tree.countOrderings(tree.root));
			
		}
	}
}

// modified from algs4.jar (no value needed, big integer operations added)
class BST{
    public Node root;             // root of BST

    public class Node {
        public int key;           // sorted by key
        public Node left, right;  // left and right subtrees
        public int size;          // number of nodes in subtree

        public Node(int key, int size) {
            this.key = key;
            this.size = size;
        }
    }
	
    public BST() {
    }
	
	public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return size(root);
    }

    public int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }


    public void put(int key) {
        root = put(root, key);
    }

    public Node put(Node x, int key) {
        if (x == null) return new Node(key, 1);
        if      (key < x.key) x.left  = put(x.left,  key);
        else if (key >= x.key) x.right = put(x.right, key);
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }
	
	public void inOrder(Node root)	{
		
		if (root != null)	{
			//System.out.println(root.key);
			inOrder(root.left);
			//System.out.println(root.key);
			inOrder(root.right);
			//System.out.println(root.key);
			
		}
	}
	
     //Function to count number of nodes recursively
     public int countNodes(Node root)
     {
         if (root == null)	{
             return 0;
		 }
         else
         {
             int l = 1;
             l += countNodes(root.left);
             l += countNodes(root.right);
             return l;
         }
     }
	 
	 // counts orderings recursively
	 public BigInteger countOrderings(Node node)	{
		 
		 if (node == null)	{
			 return BigInteger.ONE;
		 }
		 else{
			 
				int L = countNodes(node.left);
				int R = countNodes(node.right);
				BigInteger temp = choose((L+R), R);
				return temp.multiply(countOrderings(node.left)).multiply(countOrderings(node.right));
		 }
		 
	 }
	 // n choose m using big integer
	 public static BigInteger choose(long N, long M)	{
		
		BigInteger result = BigInteger.ONE;
		for (int i = 0; i < M; i++)	{
			result = result.multiply(BigInteger.valueOf(N-i)).divide(BigInteger.valueOf(i+1));
		}
		return result;
		
	}
	

	
}