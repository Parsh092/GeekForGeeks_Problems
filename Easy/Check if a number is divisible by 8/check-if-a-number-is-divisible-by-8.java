//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S=read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.DivisibleByEight(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    int DivisibleByEight(String s){
        int n = s.length();
        int a = s.charAt(n - 1) - '0';
        if(n >=2 ) a = (10 * s.charAt(n-2) - '0') + a;
        if(n >=3 ) a = (100 * s.charAt(n-3) - '0') + a;
        if(a%8==0) return 1;
        return -1;
    }
}