//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[][] grid = new int[n][n];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < n; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.minimumCostPath(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Tuple{
    int wt;
    int first;
    int second;
    public Tuple(int wt,int first,int second){
        this.wt = wt;
        this.first = first;
        this.second = second;
    }
}
class Solution
{
    public int minimumCostPath(int[][] grid)
    {
       int n = grid.length;
       int m = grid[0].length;
       PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((x,y)-> x.wt - y.wt);
       pq.offer(new Tuple(grid[0][0],0,0));
       int[][] dis  = new int[n][m];
       for(int[] rows : dis) Arrays.fill(rows,(int) 1e9);
       dis[0][0] = grid[0][0];
       int[][] moves = {{0,-1},{0,1},{-1,0},{1,0}};
       while(!pq.isEmpty()){
           Tuple t = pq.poll();
           int wt = t.wt;
           int i = t.first;
           int j = t.second;
           for(int[] move : moves){
               int adjI = i + move[0];
               int adjJ = j + move[1];
               
               if(adjI>=0 && adjI<n && adjJ>=0 && adjJ<m){
                   int adjW = grid[adjI][adjJ];
                   if(dis[adjI][adjJ] > dis[i][j] + adjW){
                       dis[adjI][adjJ] = dis[i][j] + adjW;
                       pq.offer(new Tuple(dis[adjI][adjJ],adjI,adjJ));
                   }
               }
           }
       }
       return dis[n-1][m-1];
    }
}