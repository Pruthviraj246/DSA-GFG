class Solution {
    public int maximumPoints(int mat[][]) {
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        int n=mat.length;
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>(Collections.nCopies(4,-1)));
        }
        return mem(n-1,3,mat,list);
        
    }
    
    static int mem(int day,int last,int mat[][],ArrayList<ArrayList<Integer>> list){
        if(day==0){
            int maxi=0;
            for(int task=0;task<3;task++){
                if(task!=last){
                    maxi=Math.max(maxi,mat[0][task]);
                }
            }
            return maxi;
        }
        
        if(list.get(day).get(last)!=-1) return list.get(day).get(last);
        
        int maxi=0;
        for(int task=0;task<3;task++){
            if(task!=last){
                int points=mat[day][task]+mem(day-1,task,mat,list);
                maxi=Math.max(maxi,points);
            }
        }
        list.get(day).set(last,maxi);
        return maxi;
    }
}