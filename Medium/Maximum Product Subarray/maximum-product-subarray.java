//{ Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}

// } Driver Code Ends


class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        long ans = Integer.MIN_VALUE;
        long left = 1;
        long right = 1;
        for(int i=0;i<n;i++){
            left *=arr[i];
            right *= arr[n-1-i];
            ans = Math.max(ans,Math.max(left,right));
            if(left == 0 ) left = 1;
            if(right == 0) right = 1;
        }
        return ans;
    }
}