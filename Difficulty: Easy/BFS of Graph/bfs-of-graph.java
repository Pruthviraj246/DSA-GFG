class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs=new ArrayList<>();
        int v=adj.size();
        Queue<Integer> q=new LinkedList<>();
        boolean[] vis=new boolean[v];
        q.add(0);
        vis[0]=true;
        while(!q.isEmpty()){
            Integer node=q.poll();
            bfs.add(node);
            for(Integer x:adj.get(node)){
                if(vis[x]==false){
                    vis[x]=true;
                    q.add(x);
                }
            }
        }
        return bfs;
        
    }
}