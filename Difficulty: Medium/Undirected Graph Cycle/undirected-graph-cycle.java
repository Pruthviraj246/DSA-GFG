class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}

class Solution {
    public boolean isCycle(int V, int[][] edges) {
        int n=edges.length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<n;i++){
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis=new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(check(i, V, edges, vis, adj)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    static boolean check(int src,int V,int[][] edges,boolean[] vis,ArrayList<ArrayList<Integer>> adj){
        vis[src]=true;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(src,-1));
        while(!q.isEmpty()){
            int node=q.peek().first;
            int parent=q.peek().second;
            q.remove();
            for(int it:adj.get(node)){
                if(vis[it]==false){
                    vis[it]=true;
                    q.add(new Pair(it,node));
                }
                else if(parent!=it){
                    return true;
                }
            }
        }
        return false;
    }
}