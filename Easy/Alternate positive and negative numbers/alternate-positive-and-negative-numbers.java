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

            new Solution().rearrange(arr, n);
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java




class Solution {
    void rearrange(int arr[], int n) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int num : arr){
            if(num>=0) pos.add(num);
            else neg.add(num);
        }
        int i=0;
        while(!pos.isEmpty() && !neg.isEmpty()){
            if(i%2==0){
                ans.add(pos.get(0));
                pos.remove(0);
            } 
            else{
                ans.add(neg.get(0));
                neg.remove(0);
            } 
            i++;
        }
        
        while(!pos.isEmpty()){
            ans.add(pos.get(0));
            pos.remove(0);
        }
        
        while(!neg.isEmpty()){
            ans.add(neg.get(0));
            neg.remove(0);
        }
        
        for(i=0;i<ans.size();i++) arr[i] = ans.get(i);
        return;
    }
}