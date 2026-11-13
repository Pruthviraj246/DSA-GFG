class Solution {
	int minCost(int[] height) {
		int n = height.length;
		ArrayList<Integer> list = new ArrayList<>(Collections.nCopies(n + 1, -1));
// 		return mem(height, n - 1, list);
        // return tab(height,list);
        return so(height);
	}
	
	public int func(int[] height, int i) {
		if (i == 0)
			return 0;
		int left = func(height, i - 1) + Math.abs(height[i]-height[i - 1]);
		int right = Integer.MAX_VALUE;
		if (i>1) {
			right = func(height, i - 2) + Math.abs(height[i]-height[i - 2]);
		}
		return Math.min(left, right);
	}
	
	public int mem(int[] height, int i, ArrayList<Integer> list) {
		if (i == 0)
			return 0;
		
		if (list.get(i) != -1)
			return list.get(i);
		
		int left = mem(height, i - 1, list)
		+ Math.abs(height[i] - height[i - 1]);
		
		int right = Integer.MAX_VALUE;
		
		if (i > 1) {
			right = mem(height, i - 2, list)
			+ Math.abs(height[i] - height[i - 2]);
		}
		
		list.set(i, Math.min(left, right));
		
		return list.get(i);
	}
	
	public int tab(int[] height,ArrayList<Integer> list){
	    int n=height.length;
	    list.set(0,0);
	    for(int i=1;i<n;i++){
	        int left=list.get(i-1)+Math.abs(height[i] - height[i - 1]);
	        int right = Integer.MAX_VALUE;
	        if(i>1){
	            right=list.get(i-2)+Math.abs(height[i] - height[i - 2]);
	        }
	        list.set(i,Math.min(left, right));
	    }
	    return list.get(n-1);
	}
	
	public int so(int[] height){
	    int prev=0;
	    int prev2=0;
	    int n=height.length;
	    for(int i=1;i<n;i++){
	        int left=prev+Math.abs(height[i] - height[i - 1]);
	        int right = Integer.MAX_VALUE;
	        if(i>1){
	            right=prev2+Math.abs(height[i] - height[i - 2]);
	        }
	        int cur=Math.min(left,right);
	        prev2=prev;
	        prev=cur;
	    }
	    return prev;
	}
}
