//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static List<Integer> nextPermutation(int N, int arr[]){
        List<Integer> ans = new ArrayList<>();
        int index = -1;
        
        // Finding the break point
        for(int i=N-2;i>=0;i--){
            if(arr[i] < arr[i+1]){
                index = i;
                break;
            }
        }
    
        // If the given array is last permutation
        if(index == -1){
            for(int i=N-1;i>=0 ;i--){
                ans.add(arr[i]);
            }
            return ans;
        }
       
        // Finding the next greater element in array than index element
        for(int i =N-1;i>index;i--){
           if(arr[i]> arr[index]){
               int tem = arr[index];
               arr[index] = arr[i];
               arr[i] = tem;
               break;
           }
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // Sort the element after the index.
        for(int i=index+1;i<N;i++){
            pq.add(arr[i]);
        }
        
        for(int i=0;i<=index;i++){
            ans.add(arr[i]);
        }
        for(int i=index+1;i<N;i++){
            int tem = pq.remove();
            ans.add(tem);
        }
        return ans;
    }
}