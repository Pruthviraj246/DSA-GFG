class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}

class Solution {
    public ArrayList<Integer> shortestPath(int V, int[][] edges, int src, int dest) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=V;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];

            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,wt));
        }

        long[] dist=new long[V+1];
        for(int i=1;i<=V;i++){
            dist[i]=Long.MAX_VALUE;
        }

        dist[src]=0;

        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
            if(a.second==b.second){
                return Integer.compare(a.first,b.first);
            }
            return Integer.compare(a.second,b.second);
        });

        pq.add(new Pair(src,0));

        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            int node=curr.first;
            int d=curr.second;

            if(d!=dist[node]){
                continue;
            }

            for(Pair p:adj.get(node)){
                int next=p.first;
                int wt=p.second;

                if(dist[node]+wt<dist[next]){
                    dist[next]=dist[node]+wt;
                    pq.add(new Pair(next,(int)dist[next]));
                }
            }
        }

        if(dist[dest]==Long.MAX_VALUE){
            ArrayList<Integer> ans=new ArrayList<>();
            ans.add(-1);
            return ans;
        }

        long[] toDest=new long[V+1];
        for(int i=1;i<=V;i++){
            toDest[i]=Long.MAX_VALUE;
        }

        toDest[dest]=0;

        pq=new PriorityQueue<>((a,b)->{
            if(a.second==b.second){
                return Integer.compare(a.first,b.first);
            }
            return Integer.compare(a.second,b.second);
        });

        pq.add(new Pair(dest,0));

        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            int node=curr.first;
            int d=curr.second;

            if(d!=toDest[node]){
                continue;
            }

            for(Pair p:adj.get(node)){
                int next=p.first;
                int wt=p.second;

                if(toDest[node]+wt<toDest[next]){
                    toDest[next]=toDest[node]+wt;
                    pq.add(new Pair(next,(int)toDest[next]));
                }
            }
        }

        ArrayList<Integer> ans=new ArrayList<>();
        int node=src;
        ans.add(node);

        while(node!=dest){
            int nextNode=Integer.MAX_VALUE;

            for(Pair p:adj.get(node)){
                int next=p.first;
                int wt=p.second;

                if(dist[node]+wt==dist[next] &&
                   dist[next]+toDest[next]==dist[dest]){
                    nextNode=Math.min(nextNode,next);
                }
            }

            if(nextNode==Integer.MAX_VALUE){
                ArrayList<Integer> empty=new ArrayList<>();
                empty.add(-1);
                return empty;
            }

            node=nextNode;
            ans.add(node);
        }

        return ans;
    }
}