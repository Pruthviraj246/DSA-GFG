class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
        }
        boolean[] vis=new boolean[V];
        boolean[] pathVis=new boolean[V];
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                if(dfs(i,adj,vis,pathVis)==true){
                    return true;
                }
            }
        }
        return false;
    }
    
    static boolean dfs(int start,ArrayList<ArrayList<Integer>> adj,boolean[] vis,boolean[] pathVis){
        vis[start]=true;
        pathVis[start]=true;
        for(int it:adj.get(start)){
            if(vis[it]==false){
                if(dfs(it,adj,vis,pathVis)==true){
                    return true;
                }
            }else if(pathVis[it]==true){
                return true;
            }
        }
        pathVis[start]=false;
        return false;
    }
}