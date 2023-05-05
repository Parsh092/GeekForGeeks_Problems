//{ Driver Code Starts
//Initial Template for Java




import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().print2largest(arr, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int print2largest(int arr[], int n) {
        
        /*
        ArrayList<Integer> st = new ArrayList<>();
       for(int i=0;i<n;i++){
           if(!st.contains(arr[i])) st.add(arr[i]);
       }
       Collections.sort(st);
       
       return st.size()>=2?st.get(st.size()-2):-1;
       */
       
       Arrays.sort(arr);
       for(int i=n-2;i>=0;i--){
           if(arr[i]<arr[i+1]){
               return arr[i];
           }
       }
       return -1;
    }
}