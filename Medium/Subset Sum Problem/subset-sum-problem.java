//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static Boolean f(int i,int[] arr,int target,int[][] dp){
        if(target == 0) return true;
        if(i==0) return arr[i]==target?true:false;
        if(dp[i][target]!=-1) return dp[i][target]==1?true:false;
        boolean nottake = f(i-1,arr,target,dp);
        boolean take = false;
        if(arr[i]<=target){
            take = f(i-1,arr,target-arr[i],dp);
        }
        dp[i][target] = take || nottake?1:0;
        return take || nottake;
    }
    static Boolean isSubsetSum(int n, int arr[], int sum){
        int[][] dp = new int[n][sum+1];
        for(int[] row : dp) Arrays.fill(row,-1);
        return f(n-1,arr,sum,dp);
    }
}