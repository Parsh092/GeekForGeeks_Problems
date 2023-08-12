//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} 
// } Driver Code Ends

class Solution 
{
    static int bs(int i, int n, int[] ans, int target){
		while(i<n){
			int mid = i + (n-i)/2;
			if(ans[mid]>=target){
				n=mid;
			}
			else{
				i=mid+1;
			}
		}
		return n;
		
	}
    static int longestSubsequence(int size, int arr[])
    {
      	int n = arr.length;
		int[] ans  = new int[n];
		ans[0]=arr[0];
		int len =1;
		for(int i=1;i<n;i++){
			if(arr[i]>ans[len-1]){
				ans[len]=arr[i];
				len++;
			}
			else{
				int ind = bs(0,len-1,ans,arr[i]);
				ans[ind] = arr[i];
			}
		}
		return len;
    }
} 