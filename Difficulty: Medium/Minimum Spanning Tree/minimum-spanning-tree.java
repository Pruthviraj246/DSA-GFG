class Pair {
	int node;
	int distance;
	public Pair(int node, int distance) {
		this.node = node;
		this.distance = distance;
	}
}

class Solution {
	public int spanningTree(int V, int[][] edges) {
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for (int i = 0; i<V; i++) {
			adj.add(new ArrayList<>());
		}
		
		for (int i = 0; i<edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			int wt = edges[i][2];
			
			adj.get(u).add(new Pair(v, wt));
			adj.get(v).add(new Pair(u, wt));
		}
		
		PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) ->Integer.compare(x.distance, y.distance));
		int[] vis = new int[V];
		
		pq.add(new Pair(0, 0));
		int sum = 0;
		while (!pq.isEmpty()) {
			int wt = pq.peek().distance;
			int node = pq.peek().node;
			pq.remove();
			
			if (vis[node] == 1)
				continue;
			vis[node] = 1;
			sum += wt;
			
			for (int i = 0; i < adj.get(node).size(); i++) {
				int edW = adj.get(node).get(i).distance;
				int adjNode = adj.get(node).get(i).node;
				
				if (vis[adjNode] == 0) {
					pq.add(new Pair(adjNode,edW));
				}
			}
		}
		return sum;
	}
}
