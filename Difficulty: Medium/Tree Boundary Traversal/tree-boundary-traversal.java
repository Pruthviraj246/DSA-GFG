/* Node Structure
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {

    public ArrayList<Integer> boundaryTraversal(Node root) {

        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        // Root
        if (!isLeaf(root)) {
            ans.add(root.data);
        }

        
        leftBoundary(root, ans);

      
        addLeaves(root, ans);

       
        rightBoundary(root, ans);

        return ans;
    }

    void leftBoundary(Node root, ArrayList<Integer> res) {

        Node cur = root.left;

        while (cur != null) {

            if (!isLeaf(cur)) {
                res.add(cur.data);
            }

            if (cur.left != null) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
    }

    void rightBoundary(Node root, ArrayList<Integer> res) {

        Node cur = root.right;

        ArrayList<Integer> temp = new ArrayList<>();

        while (cur != null) {

            if (!isLeaf(cur)) {
                temp.add(cur.data);
            }

            if (cur.right != null) {
                cur = cur.right;
            } else {
                cur = cur.left;
            }
        }

       
        for (int i = temp.size() - 1; i >= 0; i--) {
            res.add(temp.get(i));
        }
    }

    void addLeaves(Node root, ArrayList<Integer> res) {

        if (isLeaf(root)) {
            res.add(root.data);
            return;
        }

        if (root.left != null) {
            addLeaves(root.left, res);
        }

        if (root.right != null) {
            addLeaves(root.right, res);
        }
    }

    boolean isLeaf(Node root) {
        return root != null &&
               root.left == null &&
               root.right == null;
    }
}