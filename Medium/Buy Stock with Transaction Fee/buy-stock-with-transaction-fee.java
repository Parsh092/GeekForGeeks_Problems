//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            long []prices=new long[N];
            for(int i=0;i<N;i++){
                prices[i]=sc.nextLong();
            }
            int fee=sc.nextInt();
            Solution obj=new Solution();
            long res=obj.maximumProfit(prices,N,fee);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    public long maximumProfit(long prices[], int n, int fee){
        long[][] dp = new long[n+1][2];
        dp[n][0]=0;
        dp[n][1]=0;
        
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<2;buy++){
                if(buy==1) dp[i][buy]=Math.max(-prices[i] + dp[i+1][0],dp[i+1][1]);
                else dp[i][buy] = Math.max(dp[i+1][0], prices[i]-fee+dp[i+1][1]);
            }
        }
        return dp[0][1];
    }
}