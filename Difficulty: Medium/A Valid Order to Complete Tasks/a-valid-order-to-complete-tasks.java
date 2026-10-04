class Solution {
	public ArrayList<Integer> findOrder(int v, int[][] prerequisites) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i<v; i++) {
			adj.add(new ArrayList<>());
		}
		int m = prerequisites.length;
		for (int i = 0; i<m; i++) {
			int u = prerequisites[i][1];
			int x = prerequisites[i][0];
			adj.get(u).add(x);
		}
		int[] indegree = new int[v];
		for (int i = 0; i<v; i++) {
			for (int it:adj.get(i)) {
				indegree[it]++;
			}
		}
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i<v; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}
		ArrayList<Integer> topo = new ArrayList<>();
		while (!q.isEmpty()) {
			int node = q.peek();
			q.remove();
			topo.add(node);
			for (int it:adj.get(node)) {
				indegree[it]--;
				if (indegree[it] == 0)
					q.add(it);
			}
		}
		if (topo.size() == v) return topo;
		ArrayList<Integer> topo2 = new ArrayList<>();
		return topo2;
	}
}
