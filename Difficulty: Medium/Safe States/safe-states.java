class Solution {
	public ArrayList<Integer> safeNodes(int V, int[][] edges) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i<V; i++) {
			adj.add(new ArrayList<>());
		}
		int[] indegree = new int[V];
		for (int i = 0; i<edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			
			adj.get(v).add(u);
			indegree[u]++;
		}
		
		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i<V; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}
		while (!q.isEmpty()) {
			int node = q.peek();
			q.remove();
			list.add(node);
			for (int it:adj.get(node)) {
				indegree[it]--;
				if (indegree[it] == 0)
					q.add(it);
			}
		}
		Collections.sort(list);
		return list;
	}
}
