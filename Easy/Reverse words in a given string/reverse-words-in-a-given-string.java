//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String S)
    {
        if(S.length()<=1) return S;
        String ans="";
        int start=0;
        int end = 0;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='.'){
                if(ans==""){
                    ans="."+S.substring(start,i);
                }
                else{
                    ans = S.substring(start,i)+ ans;
                }
                start=i;
            }
        }
        if(start==0) return S;
        ans = S.substring(start+1,S.length()) + ans;
        return ans;
        
    }
}