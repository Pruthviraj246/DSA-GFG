class Solution {
    int minCost(int[] height) {
        int n=height.length;
        ArrayList<Integer> list=new ArrayList<>(Collections.nCopies(n,-1));
        int ans=mem(n-1,height,list);
        return ans;
    }
    
    static int mem(int n,int[] height,ArrayList<Integer> list){
        if(n==0) return 0;
        if(list.get(n)!=-1) return list.get(n);
        int left=mem(n-1,height,list)+Math.abs(height[n]-height[n-1]);
        int right=Integer.MAX_VALUE;
        if(n>1){
            right=mem(n-2,height,list)+Math.abs(height[n]-height[n-2]);
        }
        int min=Math.min(left,right);
        list.set(n,min);
        return list.get(n);
    }
}