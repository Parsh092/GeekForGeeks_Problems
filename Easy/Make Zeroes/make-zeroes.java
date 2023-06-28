//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++)
                    matrix[i][j] = Integer.parseInt(S[j]);
            }
            Solution ob = new Solution();
            ob.MakeZeros(matrix);
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}

// } Driver Code Ends


class Solution
{
    public void  MakeZeros(int[][] matrix)
    {
        int[][] moves = {{-1,0},{1,0},{0,-1},{0,1}};
        int[][] visited = new int[matrix.length][matrix[0].length];
        for(int[] row : visited) Arrays.fill(row,Integer.MAX_VALUE);
        
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==0){
                visited[i][j]=0;
                    for(int[] move : moves){
                        int ii = i+ move[0];
                        int ij = j+ move[1];
                        if(ii>=0 && ii< matrix.length && ij<matrix[i].length && ij>=0){
                            visited[i][j]+=matrix[ii][ij];
                            visited[ii][ij]=0;
                        }
                    }
                }
                else if(visited[i][j]!=0){
                    visited[i][j]=matrix[i][j];
                }
            }
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                matrix[i][j] = visited[i][j];
            }
        }
        return;
    }
}