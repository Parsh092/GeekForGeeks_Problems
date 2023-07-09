//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] grid = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.totalWays(N, M, grid);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int mod = (int) 1e9 + 7;
    
    static int f(int i,int j,int[][] grid, int[][] dp){
        if(i<0 || j<0 || grid[i][j]==1) return 0;
        if(i==0 && j==0) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int up = f(i-1,j,grid,dp);
        int left = f(i,j-1,grid,dp);
        return dp[i][j] = (up + left)%mod;
    }
    public int totalWays(int n, int m, int grid[][]) {
        int[][] dp = new int[n][m];
        for(int[] rows : dp) Arrays.fill(rows,-1);
        return (f(n-1,m-1,grid,dp))%mod;
    }
}