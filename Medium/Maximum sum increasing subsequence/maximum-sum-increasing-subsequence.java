//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int f(int i,int prev,int n,int[] arr,int[][] dp){
        if(i==n) return 0;
        if(dp[i][prev+1] !=-1) return dp[i][prev+1];
        int nottake = f(i+1,prev,n,arr,dp);
        int take = Integer.MIN_VALUE;
        if(prev==-1 || arr[i]>arr[prev]){
            take = arr[i] + f(i+1,i,n,arr,dp);
        }
        return dp[i][prev+1] = Math.max(take,nottake);
    }
	public int maxSumIS(int arr[], int n)  
	{  
	    int[][] dp = new int[n][n+1];
	    for(int[] rows : dp) Arrays.fill(rows,-1);
	    return f(0,-1,n,arr,dp);
	}  
}