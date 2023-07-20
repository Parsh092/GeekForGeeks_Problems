//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            
            char ans=new Solution().nonrepeatingCharacter(st);
            
            if(ans!='$')
            System.out.println(ans);
            else
            System.out.println(-1);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to find the first non-repeating character in a string.
    static char nonrepeatingCharacter(String s)
    {
        HashMap<Character,Integer> map = new HashMap<>();
        char ans='z';
        int n = s.length();
        for(int i=0;i<n;i++){
          char ch = s.charAt(i);
          map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        for(int i=0;i<n;i++){
          int tem = map.get(s.charAt(i));
          if(tem == 1) return s.charAt(i);
        }
        return '$';
        
    }
}

