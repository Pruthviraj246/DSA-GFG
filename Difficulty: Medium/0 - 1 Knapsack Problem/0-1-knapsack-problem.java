class Solution {
    public int knapsack(int W, int val[], int wt[]) {
        ArrayList<ArrayList<Integer>> dp=new ArrayList<>();
        int n=wt.length;
        for(int i=0;i<n;i++){
            dp.add(new ArrayList<>(Collections.nCopies(W+1,-1)));
        }
        // return mem(W,n-1,val,wt,dp);
        // return tab(W,val,wt);
        return tab2(W,val,wt);
        
    }
    
    static int mem(int W,int ind, int val[], int wt[],ArrayList<ArrayList<Integer>> dp){
        if(ind==0){
            if(wt[0]<=W) return val[0];
            return 0;
        }
        if(dp.get(ind).get(W) !=-1 ) return dp.get(ind).get(W);
        int notTake=mem(W,ind-1,val,wt,dp);
        int take=0;
        if(wt[ind]<=W){
            take=val[ind]+mem(W-wt[ind],ind-1,val,wt,dp);
        }
        dp.get(ind).set(W,Math.max(take,notTake));
        return dp.get(ind).get(W);
    }
    
    static int tab(int W, int val[], int wt[]){
        ArrayList<ArrayList<Integer>> dp=new ArrayList<>();
        int n=wt.length;
        for(int i=0;i<n;i++){
            dp.add(new ArrayList<>(Collections.nCopies(W+1,-1)));
        }
        for(int i=wt[0];i<=W;i++){
            dp.get(0).set(i,val[0]);
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<=W;j++){
                int notTake=dp.get(i-1).get(j);
                int take=0;
                if(wt[i]<=j){
                    take=val[i]+dp.get(i-1).get(j-wt[i]);
                }
                dp.get(i).set(j,Math.max(take,notTake));
            }
        }
        return dp.get(n-1).get(W);
        
    }
    
    static int tab2(int W, int val[], int wt[]){
        ArrayList<Integer> prev=new ArrayList<>(Collections.nCopies(W+1,0));
        ArrayList<Integer> cur=new ArrayList<>(Collections.nCopies(W+1,0));
        int n=wt.length;
        for(int i=wt[0];i<=W;i++){
            prev.set(i,val[0]);
        }
        for(int i=1;i<n;i++){
            cur=new ArrayList<>(Collections.nCopies(W+1,0));
            for(int j=0;j<=W;j++){
                int notTake=prev.get(j);
                int take=0;
                if(wt[i]<=j){
                    take=val[i]+prev.get(j-wt[i]);
                }
                cur.set(j,Math.max(take,notTake));
            }
            prev=cur;
        }
        return prev.get(W);
    }
}
