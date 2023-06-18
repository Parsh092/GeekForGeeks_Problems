//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int majorityElement(int a[], int size)
    {
        if(a.length==1) return a[0];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int I : a){
            if(map.containsKey(I)){
                map.put(I,map.getOrDefault(I,0)+1);
                if(map.get(I) > size/2){
                    return I;
                }
            }
            else map.put(I,map.getOrDefault(I,0)+1);
        }
        return -1;
    }
}