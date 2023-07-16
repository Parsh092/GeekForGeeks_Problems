//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
  
   static int mino(int i,int j,String a,String b,int[][] dp){
        if(j<0) return i+1;
        if(i<0) return j+1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(a.charAt(i)==b.charAt(j)) return dp[i][j]= mino(i-1,j-1,a,b,dp);
        int insert = 1+mino(i,j-1,a,b,dp);
        int delete = 1+mino(i-1,j,a,b,dp);
        int replace= 1+mino(i-1,j-1,a,b,dp);
        return dp[i][j]= Math.min(insert,Math.min(delete,replace));
    }
    
    public int editDistance(String word1, String word2) {
        int n = word1.length();
       int m = word2.length();
       int[][] dp = new int[n][m];
       for(int[] row:dp){
           Arrays.fill(row,-1);
       } 
       return mino(n-1,m-1,word1,word2,dp);
    }
}