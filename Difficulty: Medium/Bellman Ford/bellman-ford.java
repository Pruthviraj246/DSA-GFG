class Solution {
    public ArrayList<Integer> bellmanFord(int V, int[][] edges, int src) {
        ArrayList<Integer> dist=new ArrayList<>(Collections.nCopies(V,100000000));
        dist.set(src,0);

        for(int i=0;i<V-1;i++){
            for(int[] it:edges){
                int u=it[0];
                int v=it[1];
                int w=it[2];

                if(dist.get(u)!=100000000 && dist.get(u)+w<dist.get(v)){
                    dist.set(v,dist.get(u)+w);
                }
            }
        }

        for(int[] it:edges){
            int u=it[0];
            int v=it[1];
            int w=it[2];

            if(dist.get(u)!=100000000 && dist.get(u)+w<dist.get(v)){
                ArrayList<Integer> temp=new ArrayList<>();
                temp.add(-1);
                return temp;
            }
        }

        return dist;
    }
}