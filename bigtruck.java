import java.util.*;

public class bigtruck   {

    public static void main(String[] args)  {
    
        Scanner sc = new Scanner(System.in);
        
        // variable init
        int nodes = sc.nextInt() + 1;
        
        // array to keep track of items at a node
        int[] items = new int[nodes];
        for (int i = 1; i < nodes; i++) {
            items[i] = sc.nextInt();
        }
        
        int edges = sc.nextInt();
        
        EdgeWeightedDigraph graph = new EdgeWeightedDigraph(nodes);
        int node1;
        int node2;
        int distance;
        DirectedEdge newEdge;
        for (int i = 0; i < edges; i++) {
            node1 = sc.nextInt();
            node2 = sc.nextInt();
            distance = sc.nextInt();
            
            newEdge = new DirectedEdge(node1, node2, distance);
            graph.addEdge(newEdge);
            newEdge = new DirectedEdge(node2, node1, distance);
            graph.addEdge(newEdge);
        }
        BellmanFord shortestDistGraph = new BellmanFord(graph, 1, items);
        
        if (shortestDistGraph.distTo[nodes-1] == Integer.MAX_VALUE) {
            System.out.print("impossible");
        }
        else    {
            System.out.print(shortestDistGraph.distTo[nodes-1] + " " + shortestDistGraph.maxItems[nodes-1]);
        }
    }
}

// Bellman Ford from textbook
class DirectedEdge  {
    int v;
    int w;
    int weight;
    
    public DirectedEdge(int v, int w, int weight)   {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    public int weight() {
        return weight;
    }
    public int from()   {
        return v;
    }
    public int to() {
        return w;
    }
}

class EdgeWeightedDigraph   {
    int V;                // number of vertices in this digraph
    int E;                      // number of edges in this digraph
    edgeLinkedList[] adj;    // adj[v] = adjacency list for vertex v
    
    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        adj = new edgeLinkedList[V];
        for (int v = 1; v < V; v++)
            adj[v] = new edgeLinkedList();
    }
    
    public void addEdge(DirectedEdge e) {
        adj[e.from()].add(e);
        E++;
    }
}

class BellmanFord   {
    int[] distTo;
    DirectedEdge[] edgeTo;
    boolean[] onQueue;
    LinkedList<Integer> queue;
    int cost;
    int[] items;
    int[] maxItems;
    
    public BellmanFord(EdgeWeightedDigraph G, int s, int[] items)   {
        distTo = new int[G.V];
        edgeTo = new DirectedEdge[G.V];
        onQueue = new boolean[G.V];
        queue = new LinkedList<Integer>();
        
        // initializing maxItem count at source node
        maxItems = new int[G.V];
        this.items = items;
        maxItems[s] = items[s];
        
        for (int v = 1; v < G.V; v++)   {
            distTo[v] = Integer.MAX_VALUE;
        }
        distTo[s] = 0;
        queue.add(s);
        onQueue[s] = true;
        while(queue.size() > 0) {
            int v = queue.remove();
            onQueue[v] = false;
            relax(G, v);
        }
        
    }
    void relax(EdgeWeightedDigraph G, int v)    {
        edgeNode current = G.adj[v].head;
        
        while (current != null) {
            int w = current.value.to();
            if(distTo[w] > distTo[v] + current.value.weight() || (distTo[w] == distTo[v] + current.value.weight() &&  maxItems[w] < maxItems[v] + items[w]))    {
                distTo[w] = distTo[v] + current.value.weight();
                edgeTo[w] = current.value;
                maxItems[w] = maxItems[v] + items[w];
                if (!onQueue[w])    {
                    queue.add(w);
                    onQueue[w] = true;
                }
            }
            current = current.next;
        }
    }
}



// New edgeNode and edgeLinkedList for directed edges
class edgeNode  {
    DirectedEdge value;
    edgeNode next;
    
    public edgeNode(DirectedEdge x) {
        value = x;
        next = null;
    }
}

class edgeLinkedList    {
    edgeNode head;
    edgeNode tail;
    int size;
    
    public edgeLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }
    
    public void add(DirectedEdge x) {
        edgeNode newNode = new edgeNode(x);
        if (head == null)   {
            head = newNode;
            tail = newNode;
            size++;
        }
        else    {
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }
}