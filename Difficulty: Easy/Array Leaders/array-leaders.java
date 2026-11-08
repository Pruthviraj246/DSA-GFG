class Solution {
    static ArrayList<Integer> leaders(int nums[]) {
        ArrayList<Integer> list=new ArrayList<>();
        int n=nums.length;
        list.add(nums[n-1]);
        int max=nums[n-1];
        for(int i=n-2;i>=0;i--){
            if(nums[i]>=max){
                max=nums[i];
                list.add(max);
            }
        }
        Collections.reverse(list);
        return list;
        
    }
}
