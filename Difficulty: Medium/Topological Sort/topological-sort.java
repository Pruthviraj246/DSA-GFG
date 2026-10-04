class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
        }
        boolean[] vis=new boolean[V];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<V;i++){
            if(vis[i]==false){
                dfs(i,adj,vis,st);
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        while(!st.isEmpty()){
            int num=st.peek();
            ans.add(num);
            st.pop();
        }
        return ans;
        
    }
    
    static void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] vis,Stack<Integer> st){
        vis[node]=true;
        for(int it:adj.get(node)){
            if(vis[it]==false){
                dfs(it,adj,vis,st);
            }
        }
        st.push(node);
    }
}