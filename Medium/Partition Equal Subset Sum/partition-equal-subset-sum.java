//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int f(int i,int target,int[] arr,int[][] dp){
        if(i==arr.length){
            return target==0?1:0;
        }
        if(dp[i][target]!=-1) return dp[i][target];
        int nottake = f(i+1,target,arr,dp);
        int take = 0;
        if(arr[i]<=target){
            take = f(i+1,target-arr[i],arr,dp);
        }
        dp[i][target] = take | nottake;
        return dp[i][target];
    }
    static int equalPartition(int n, int arr[])
    {
        int sum=0;
        for(int i : arr) sum+=i;
        if(sum%2!=0) return -1;
        int[][] dp = new int[n][(sum/2)+1];
        for(int[] rows : dp){
            Arrays.fill(rows,-1);
        }
        return f(0,sum/2,arr,dp);
    }
}