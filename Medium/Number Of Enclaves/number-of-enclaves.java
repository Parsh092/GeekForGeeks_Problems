//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(in.readLine());
        while (T-- > 0) {
            String s[] = in.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int a[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                s = in.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    a[i][j] = Integer.parseInt(s[j]);
                }
            }
            Solution ob = new Solution();
            out.println(ob.numberOfEnclaves(a));
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    void dfs(int i,int j,int[][] nums,boolean[][] visited){
        visited[i][j]=true;
        int[][] moves = {{0,-1},{0,1},{-1,0},{1,0}};
        for(int[] move : moves){
            int row = i + move[0];
            int col = j + move[1];
            if(row>=0 && row<nums.length && col>=0 && col<nums[0].length
            && nums[row][col]==1 && !visited[row][col]){
                dfs(row,col,nums,visited);
            }
        }
    }
    int numberOfEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            if(grid[i][0]==1 && !visited[i][0]) dfs(i,0,grid,visited);
            if(grid[i][m-1]==1 && !visited[i][m-1]) dfs(i,m-1,grid,visited);
        }
        for(int j=0;j<m;j++){
            if(grid[0][j]==1 && !visited[0][j]) dfs(0,j,grid,visited);
            if(grid[n-1][j]==1 && !visited[n-1][j]) dfs(n-1,j,grid,visited);
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    count++;
                }
            }
        }
        return count;
    }
}