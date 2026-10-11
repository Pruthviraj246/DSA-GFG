class Solution {
    static int perfectSum(int[] arr, int target) {
        ArrayList<ArrayList<Integer>> dp=new ArrayList<>();
        int n=arr.length;
        for(int i=0;i<n;i++){
            dp.add(new ArrayList<>(Collections.nCopies(target+1,-1)));
        }
        return mem(arr,target,n-1,dp);
    }
    
    static int mem(int[] arr, int target,int ind,ArrayList<ArrayList<Integer>> dp){
        if(ind==0){
            if(target==0 && arr[0]==0) return 2;
            if(target==0 || arr[0]==target) return 1;
            return 0;
        }
        if(dp.get(ind).get(target)!=-1) return dp.get(ind).get(target);
        int notPick=mem(arr,target,ind-1,dp);
        int pick=0;
        if(target>=arr[ind]){
            pick=mem(arr,target-arr[ind],ind-1,dp);
        }
        dp.get(ind).set(target,pick+notPick);
        return dp.get(ind).get(target);
    }
    
    // static int tab(int[] arr, int target,ArrayList<ArrayList<Integer>> dp){
        
    //     for(int i=0;i<n;i++){
    //         dp.get(i).set(0,1);
    //     }
    //     if(arr[0]<=target){
    //         dp.get(0).set(arr[0],1);
    //     }
        
    // }
    
    
}