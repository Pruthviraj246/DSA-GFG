/* Node Structure
class Node{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
} */
class Solution {
    public boolean isSumProperty(Node root) {
        return isSum(root)!=-1;
        
    }
    
    int isSum(Node root){
        if(root==null) return 0;
        if(root.left==null && root.right==null){
            return root.data;
        }
        int ls=isSum(root.left);
        if(ls==-1) return -1;
        int rs=isSum(root.right);
        if(rs==-1) return -1;
        int sum=ls+rs;
        
        if(sum!=root.data) return -1;
        return root.data;
    }
}