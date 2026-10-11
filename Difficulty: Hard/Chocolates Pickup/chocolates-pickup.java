class Solution {
	public int maxChocolate(int grid[][]) {
		int r = grid.length;
		int c = grid[0].length;
		ArrayList<ArrayList<ArrayList<Integer>> > dp = new ArrayList<>();
		for (int i = 0; i<r; i++) {
			ArrayList<ArrayList<Integer>> row = new ArrayList<>();
			for (int j = 0; j<c; j++) {
				row.add(new ArrayList<>(Collections.nCopies(c, -1)));
			}
			dp.add(row);
		}
		return mem(0, 0, c - 1, r, c, grid, dp);
		
	}
	
	static int mem(int i, int j1, int j2, int r, int c, int[][] grid, ArrayList<ArrayList<ArrayList<Integer>> > dp) {
		if (j1<0 || j2<0 || j1 >= c || j2 >= c) {
			return (int)(-1e8);
		}
		if (i == r - 1) {
			if (j1 == j2) {
				return grid[i][j1];
			} else {
				return grid[i][j1]+grid[i][j2];
			}
		}
		if (dp.get(i).get(j1).get(j2) != -1)
			return dp.get(i).get(j1).get(j2);
		
		int max = (int)(-1e8);
		for (int dj1 = -1; dj1 <= 1; dj1++) {
			for (int dj2 = -1; dj2 <= 1; dj2++) {
				int value = 0;
				if (j1 == j2) {
					value = grid[i][j1];
				} else {
					value = grid[i][j1]+grid[i][j2];
				}
				value += mem(i + 1, j1 + dj1, j2 + dj2, r, c, grid, dp);
				max = Math.max(max, value);
			}
		}
		dp.get(i).get(j1).set(j2, max);
		return dp.get(i).get(j1).get(j2);
	}
	
}
