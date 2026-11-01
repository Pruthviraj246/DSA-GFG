class Solution {
    static int solve(int bt[]) {
        Arrays.sort(bt);
        int wt=0;
        int t=0;
        int n=bt.length;
        for(int i=0;i<bt.length;i++){
            wt+=t;
            t+=bt[i];
        }
        return (wt/n);
        
    }
}
