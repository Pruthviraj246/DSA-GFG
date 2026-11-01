class Solution {
    public int maxChildren(int[] greed, int[] cookie) {
        int n=greed.length;
        int m=cookie.length;
        int l=0;
        int r=0;
        Arrays.sort(greed);
        Arrays.sort(cookie);
        while(l<n && r<m){
            if(greed[l]<=cookie[r]){
                l=l+1;
            }
            r=r+1;
        }
        return l;
        
    }
}