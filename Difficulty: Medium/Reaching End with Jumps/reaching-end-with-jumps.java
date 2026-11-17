class Solution {
    public boolean canReach(int[] arr) {
        int max=0;
        for(int i=0;i<arr.length;i++){
            if(i>max) return false;
            max=Math.max(max,i+arr[i]);
        }
        return true;
    }
}