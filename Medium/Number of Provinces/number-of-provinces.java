//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int V = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            for(int i=0; i<V; i++)
            {
                String S[] = read.readLine().split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int j=0; j<V; j++)
                    temp.add(Integer.parseInt(S[j]));
                adj.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.numProvinces(adj,V));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static void dfs(int i,boolean[] visited,ArrayList<ArrayList<Integer>> adj_list){
        if(visited[i]==true) return;
        visited[i]=true;
        for(int tem : adj_list.get(i)){
            dfs(tem,visited,adj_list);
        }
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int v) {
        int n = adj.size();
        ArrayList<ArrayList<Integer>> adj_list = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj_list.add(new ArrayList<>());
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(adj.get(i).get(j)==1 && i!=j){
                    adj_list.get(i).add(j);
                    adj_list.get(j).add(i);
                }
            }
        }
        boolean [] visited = new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(i,visited,adj_list);
            }
        }
        return count;
    
    }
};