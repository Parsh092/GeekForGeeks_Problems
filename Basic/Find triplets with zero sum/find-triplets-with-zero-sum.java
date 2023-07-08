//{ Driver Code Starts
import java.util.*;
class Triplets{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			int n=sc.nextInt();
			int[] a=new int[n];
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
			}
			Solution g=new Solution();
			if(g.findTriplets(a,n))
				System.out.println("1");
			else
				System.out.println("0");
			
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum.
	public boolean findTriplets(int arr[] , int n)
    {
        if(n<3) return false;
        Arrays.sort(arr);
        int i=0;
        while(i<n-2){
            int j = i+1;
            int k = n-1;
            int sum =0;
            while(j<k){
                sum = arr[i] + arr[j] + arr[k];
                if(sum==0) return true;
                if(sum<=0) while(arr[j]==arr[++j] && j<k);
                if(sum>=0) while(arr[k]==arr[--k] && j<k);
            }
            while(arr[i]==arr[++i] && i<j);
        }
        return false;
    }
}