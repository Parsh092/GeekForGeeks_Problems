//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int f(int i,int j,int n,int[][] arr,int[][] dp){
        if(i==n-1) return arr[i][j];
        if(dp[i][j]!=-1) return dp[i][j];
        int down = Integer.MIN_VALUE;
        int leftdown = Integer.MIN_VALUE;
        int rightdown = Integer.MIN_VALUE;
        
        if(i+1<n){
            down = f(i+1,j,n,arr,dp);
            if(j-1 >= 0) leftdown = f(i+1,j-1,n,arr,dp);
            if(j+1 < n) rightdown = f(i+1,j+1,n,arr,dp);
        } 
        return dp[i][j] = arr[i][j] + Math.max(down,Math.max(leftdown,rightdown));
    }
    
    static int maximumPath(int n, int Matrix[][])
    {
        int[][] dp = new int[n][n];
        for(int[] row : dp) Arrays.fill(row,-1);
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            ans = Math.max(ans,f(0,i,n,Matrix,dp));
        }
        return ans;
    }
}