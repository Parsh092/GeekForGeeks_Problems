// User function Template for Java
class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}
class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    
	    // Adjacency List
	    ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
	    for(int i=0;i<V;i++){
	        adj.add(new ArrayList<>());
	    }
	    for(int i=0;i<edges.length;i++){
	        adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
	        adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
	    }
	    
	    // Priority Queue
	    PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y)->x.first-y.first);
	    pq.offer(new Pair(0,0));
	    
	    // Visited Array
	    int[] visited = new int[V];
	    
	    //Minimum spanning tree sum
	    int sum=0;
	    
	    // Prims ALgorithm
	    while(pq.size()>0){
	        int wt = pq.peek().first;
            int node = pq.peek().second;
            pq.remove();
            if(visited[node]==1) continue;
            
            sum+=wt;
            visited[node]=1;
            
          for(Pair i : adj.get(node)){
              int adjNode = i.first;
              int weight = i.second;
              if(visited[adjNode]==0)
              pq.offer(new Pair(weight,adjNode));
            }
        }
    return sum;
   }
}
