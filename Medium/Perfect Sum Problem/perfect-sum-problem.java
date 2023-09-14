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
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends


class Solution{
    public static int mod = (int) 1e9 + 7;
    static int f(int i,int n,int target,int[] arr,int[][] dp){
        if(i==n){
            return target==0?1:0;
        }
        if(dp[i][target]!=-1) return dp[i][target];
        int nottake = f(i+1,n,target,arr,dp);
        int take = 0;
        if(arr[i]<=target){
            take = f(i+1,n,target-arr[i],arr,dp);
        }
        return dp[i][target] = (nottake + take)%mod;
        
    }
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    int[][] dp = new int[n][sum+1];
	    for(int[] rows : dp) Arrays.fill(rows,-1);
	    return f(0,n,sum,arr,dp);
	} 
}