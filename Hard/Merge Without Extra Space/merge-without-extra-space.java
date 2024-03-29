//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.io.*;

public class Main
{
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int m = Integer.parseInt(inputLine[1]);
		    long arr1[] = new long[n];
		    long arr2[] = new long[m];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr1[i] = Long.parseLong(inputLine[i]);
		    }
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<m; i++){
		        arr2[i] = Long.parseLong(inputLine[i]);
		    }
		    Solution ob = new Solution();
		    ob.merge(arr1, arr2, n, m);
		    
		    StringBuffer str = new StringBuffer();
		    for(int i=0; i<n; i++){
		        str.append(arr1[i]+" ");
		    }
		    for(int i=0; i<m; i++){
		        str.append(arr2[i]+" ");
		    }
		    System.out.println(str);
		}
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    //Function to merge the arrays.
    public static void merge(long arr1[], long arr2[], int n, int m) 
    {
        int i=0;
        int j=0;
        int k=0;
        long[] ans = new long[n+m];
        while(i<n && j<m){
            if(arr1[i]<arr2[j]){
                ans[k++] = arr1[i++];
            }
            else{
                ans[k++] = arr2[j++];
            }
        }
        while(i<n) ans[k++] = arr1[i++];
        while(j<m) ans[k++] = arr2[j++];
        
        k=0;
        for(i=0;i<n;i++){
            arr1[i] = ans[k++];
        }
        
        for(i=0;i<m;i++){
            arr2[i] = ans[k++];
        }
        return;
        
    }
}

/*
while(i<n){
            if(arr1[i]==arr2[j]){
                i++;
                continue;
            }
            if(arr1[i]>arr2[j]){
                long tem = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = tem;
                i++;
            }
            Arrays.sort(arr2);
        }
        return;
*/
