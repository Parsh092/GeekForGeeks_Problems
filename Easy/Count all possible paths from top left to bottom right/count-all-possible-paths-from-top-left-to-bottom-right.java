//{ Driver Code Starts
//Initial Template for Java
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
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int m = Integer.parseInt(input[0]); 
            int n = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.numberOfPaths(m,n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public static int mod = (int) 1e9 + 7;
    static int f(int i,int j,int[][] dp){
        if(i<0 || j<0) return 0;
        if(i==0 && j==0) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int up = f(i-1,j,dp);
        int left = f(i,j-1,dp);
        return dp[i][j] = (up + left)%mod;
    }
    long numberOfPaths(int a, int b)
    {
        int[][] dp = new int[a][b];
        for(int[] row : dp) Arrays.fill(row,-1);
        return f(a-1,b-1,dp);
    }
}