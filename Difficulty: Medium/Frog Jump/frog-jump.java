class Solution {
    int minCost(int[] height) {
        int[] dp=new int[height.length+1];
        return func(height.length-1,height,dp);
    }

    static int func(int ind,int[] height,int[] dp) {
        if(ind==0) return 0;
        if(dp[ind]!=0) return dp[ind];

        int left=func(ind-1,height,dp)+Math.abs(height[ind]-height[ind-1]);

        int right=Integer.MAX_VALUE;

        if(ind>1){
            right=func(ind-2,height,dp)+Math.abs(height[ind]-height[ind-2]);
        }

        return dp[ind]=Math.min(left,right);
    }
}