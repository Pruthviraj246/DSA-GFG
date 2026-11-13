class Solution {
    public int minimizeCost(int k, int arr[]) {
        int n=arr.length;
        ArrayList<Integer> dp=new ArrayList<>(Collections.nCopies(n+1,-1));
        // return func(k,arr,n-1);
        return mem(k,arr,dp,n-1);
    }
    
    public int func(int k,int[] arr,int ind){
        if(ind==0) return 0;
        int min=Integer.MAX_VALUE;
        int n=arr.length;
        for(int i=1;i<=k;i++){
            if(ind-i>=0){
                int jump = func(k,arr,ind-i) + Math.abs(arr[ind]-arr[ind-i]);
                min=Math.min(jump,min);
            }
        }
        return min;
    }
    
    public int mem(int k,int[] arr,ArrayList<Integer> dp,int ind){
        if(ind==0) return 0;
        if(dp.get(ind)!=-1) return dp.get(ind);
        int min=Integer.MAX_VALUE;
        for(int i=1;i<=k;i++){
            if(ind-i>=0){
                int jump=mem(k, arr, dp, ind-i) + Math.abs(arr[ind]-arr[ind-i]);
                min = Math.min(jump, min);
            }
        }
        dp.set(ind, min);
        return dp.get(ind);
    }
}
