//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            int S = Integer.parseInt(a[1]);
            
            Solution ob = new Solution();
            System.out.println(ob.findLargest(N, S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String findLargest(int n, int s){
        if(n==1 && s==0) return "0";
        if(n==0 && s>0) return "-1";
        if(n>0 && s==0) return "-1";
        StringBuilder ans = new StringBuilder("");
        int i=9;
        while(i>0 && n>0){
            if(s-i>=0){
                ans.append(Integer.toString(i));
                s=s-i;
                n--;
            }
            else{
                i--;
            }
        }
        if(s>0) return "-1";
        while(n-->0) ans.append('0');
        return ans.toString();
    }
}