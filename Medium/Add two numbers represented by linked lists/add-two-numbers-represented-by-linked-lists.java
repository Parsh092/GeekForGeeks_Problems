//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node first = new Node(val);
            Node tail = first;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node second = new Node(val);
            tail = second;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(first, second);
            printList(res);
        }
    }
}

// } Driver Code Ends


/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
    //Function to add two numbers represented by linked list.
    static Node reverseList(Node node){
        Node prev = null;
        Node curr = node;
        Node next = node;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    static Node addTwoLists(Node first, Node second){
        
        // Reverse lists
        Node a = reverseList(first);
        Node b = reverseList(second);
        
        int sum =0,carry=0;
        Node ans = new Node(0);
        Node tem = ans;
        while(carry!=0 || a!=null || b!=null){
            sum = carry;
            
            if(a!=null){
                sum+=a.data;
                a = a.next;
            }
            if(b!=null){
                sum+=b.data;
                b = b.next;
            }
            carry = sum/10;
            int total = sum%10;
            Node t = new Node(total);
            ans.next = t;
            ans = t;
        }
        return reverseList(tem.next);
    }
}