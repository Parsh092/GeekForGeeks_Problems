//{ Driver Code Starts
//Initial Template for Java

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
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String f(int i,int j,String s){
        while(i>=0 && j<s.length()){
            if(s.charAt(i)==s.charAt(j)){
                i--;
                j++;
            }
            else{
                break;
            }
        }
        return s.substring(i+1,j);
    }
    
    String longestPalindrome(String s){
        String str = "";
        for(int i=0;i<s.length();i++){
            String a = f(i,i,s);
            String b = f(i,i+1,s);
            String maxi = a.length()>b.length()?a:b;
            str = maxi.length()>str.length()?maxi:str;
        }
        return str;
    }
}